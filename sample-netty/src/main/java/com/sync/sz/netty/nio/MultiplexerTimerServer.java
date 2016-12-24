package com.sync.sz.netty.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by YH on 2016-12-21.
 */
public class MultiplexerTimerServer implements Runnable {

  private Selector selector;

  private ServerSocketChannel servChannel;

  private volatile boolean stop;

  /**
   * 初始化多路复用器，绑定监听端口
   *
   * @param port
   */
  public MultiplexerTimerServer(int port) {
    try {
      selector = Selector.open(); // 创建多路复用器
      servChannel = ServerSocketChannel.open(); // 打开ServerSocketChannel,用于监听客服端的连接，它是所有的客服端连接的父管道
      servChannel.configureBlocking(false); // 设置为异步非阻塞状态
      servChannel.bind(new InetSocketAddress(port), 1024); // 绑定监听端口
      servChannel.register(selector, SelectionKey.OP_ACCEPT); // 将ServerSocketChannel注册到多路复用器Selector上，监听ACCEPT时间
      System.out.println("The time server start in port : " + port);
    } catch (IOException e) {
      e.printStackTrace();
      System.exit(1);
    }
  }

  public void stop() {
    this.stop = true;
  }

  @Override public void run() {
    while (!stop) {
      try {
        selector.select(100); // 休眠一秒
        Set<SelectionKey> selectedKeys = selector.selectedKeys(); // 轮询准备就绪的Key
        Iterator<SelectionKey> it = selectedKeys.iterator();
        SelectionKey key = null;
        while (it.hasNext()) {
          key = it.next();
          it.remove();
          try {
            handleInput(key);
          } catch (Exception e) {
            if (key != null) {
              key.cancel();
              if (key.channel() != null) {
                key.channel().close();
              }
            }
          }
        }
      } catch (Throwable t) {
        t.printStackTrace();
      }
    }
    // 多路复用器关闭后，所有注册在上面的Channel和Pipe等资源都会被自动去注册并关闭，所以不需要重复释放资源。
    if (selector != null) {
      try {
        selector.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  private void handleInput(SelectionKey key) throws IOException {
    if (key.isValid()) {
      // 处理新接入的请求消息
      if (key.isAcceptable()) {
        // Accept the new connection
        ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
        SocketChannel sc = ssc.accept(); // 多路复用器监听到有新的客户端接入，处理新的接入请求，完成TCP三次握手，建立物理链路
        sc.configureBlocking(false);
        // Add the new connection to the selector
        sc.register(selector, SelectionKey.OP_READ);
      }
      if (key.isReadable()) {
        // Read the data
        SocketChannel sc = (SocketChannel) key.channel();
        ByteBuffer readBuffer = ByteBuffer.allocate(1024);
        int readBytes = sc.read(readBuffer);
        if (readBytes > 0) {
          readBuffer.flip();
          byte[] bytes = new byte[readBuffer.remaining()];
          readBuffer.get(bytes);
          String body = new String(bytes, "UTF-8");
          System.out.println("The time server receiver order : " + body);
          String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body) ?
              new Date(System.currentTimeMillis()).toString() : "BAD ORDER";
          doWrite(sc, currentTime);
        } else if (readBytes < 0) {
          // 对端链路关闭
          key.cancel();
          sc.close();
        } else {
          ; // 读到0字节,忽略
        }
      }
    }
  }

  private void doWrite(SocketChannel channel, String response) throws IOException {
    if (response != null && response.trim().length() > 0) {
      byte[] bytes = response.getBytes();
      ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
      writeBuffer.put(bytes);
      writeBuffer.flip();
      channel.write(writeBuffer);
    }
  }
}
