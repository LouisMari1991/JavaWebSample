package com.sync.sz.netty.protocol.http.websocket.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * Created by Administrator on 2017/1/7 0007.
 */
public class WebSocketServer {
  public void run(int port) throws Exception {
    EventLoopGroup bossGroup = new NioEventLoopGroup();
    EventLoopGroup workerGroup = new NioEventLoopGroup();
    try {
      ServerBootstrap b = new ServerBootstrap();
      b.group(bossGroup, workerGroup)
          .channel(NioServerSocketChannel.class)
          .childHandler(new ChannelInitializer<SocketChannel>() {
            @Override protected void initChannel(SocketChannel ch) throws Exception {
              ChannelPipeline pipeline = ch.pipeline();
              pipeline.addLast("http-codec", new HttpServerCodec());
              pipeline.addLast("aggregator", new HttpObjectAggregator(65536));
              pipeline.addLast("http-chunked", new ChunkedWriteHandler());
              pipeline.addLast("handler", new WebSocketServerHandler());
            }
          });
      Channel ch = b.bind(port).sync().channel();
      System.out.println("Web socket server start at port : " + port + '.');
      ch.closeFuture().sync();
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

      }
    }
    new WebSocketServer().run(port);
  }
}
