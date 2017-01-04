package com.sync.sz.netty.protocol.http.fileServer;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.stream.ChunkedWriteHandler;
import java.net.InetAddress;

/**
 * Created by YH on 2017-01-04.
 */
public class HttpFileServer {

  private static final String DEFAULT_URL = "/src/main/java/com/sync/sz/netty/";

  public void run(final int port, final String url) throws Exception {
    EventLoopGroup bossGroup = new NioEventLoopGroup();
    EventLoopGroup workerGroup = new NioEventLoopGroup();
    try {
      ServerBootstrap b = new ServerBootstrap();
      b.group(bossGroup, workerGroup)
          .channel(NioServerSocketChannel.class)
          .childHandler(new ChannelInitializer<SocketChannel>() {
            @Override protected void initChannel(SocketChannel ch) throws Exception {
              ch.pipeline().addLast("http-decoder", new HttpRequestDecoder());
              ch.pipeline().addLast("http-aggregator", new HttpObjectAggregator(65536));
              ch.pipeline().addLast("http-encoder", new HttpResponseEncoder());
              ch.pipeline().addLast("http-chunked", new ChunkedWriteHandler());
              ch.pipeline().addLast("fileServerHandler", new HttpFileServerHandler(url));
            }
          });
      String ip = InetAddress.getLocalHost().getHostAddress();
      ChannelFuture f = b.bind(ip, port).sync();
      System.out.println("HTTP文件目录服务器启动，网址是 : http://" + ip + ":" + port + url);
      f.channel().closeFuture().sync();
      System.out.println("HTTP文件目录服务器关闭");
    } finally {
      bossGroup.shutdownGracefully();
      workerGroup.shutdownGracefully();
    }
  }

  public static void main(String[] args) throws Exception {
    int port = 8080;
    if (args != null && args.length > 0) {
      try {
        port = Integer.valueOf(port);
      } catch (NumberFormatException e) {
        e.printStackTrace();
      }
    }
    String url = DEFAULT_URL;
    if (args.length > 1) url = args[1];
    new HttpFileServer().run(port, url);
  }
}
