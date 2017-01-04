package com.sync.sz.netty.codec.marshalling;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * Created by Administrator on 2017/1/3 0003.
 */
public class SubReqClient {

  public void connect(int port, String host) throws Exception {
    EventLoopGroup group = new NioEventLoopGroup();
    try {
      Bootstrap b = new Bootstrap();
      b.group(group).channel(NioSocketChannel.class)
          .option(ChannelOption.TCP_NODELAY, true)
          .handler(new ChannelInitializer<SocketChannel>() {
            protected void initChannel(SocketChannel ch) throws Exception {
              ch.pipeline().addLast(MarshallingCodeCFactory.buildMarshallingEncoder());
              ch.pipeline().addLast(MarshallingCodeCFactory.buildMarshallingDecoder());
              ch.pipeline().addLast(new SubReqClientHandler());
            }
          });
      ChannelFuture f = b.connect(host, port).sync();
      f.channel().closeFuture().sync();
    } finally {
      group.shutdownGracefully();
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
    new SubReqClient().connect(port, "127.0.0.1");
  }
}
