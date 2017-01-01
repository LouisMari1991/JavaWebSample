package com.sync.sz.netty.codec.serializable.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;

/**
 * Created by YH on 2016-12-30.
 */
public class SubReqServer {

  public void bind(int port) throws Exception {
    EventLoopGroup boosGroup = new NioEventLoopGroup();
    EventLoopGroup workGroup = new NioEventLoopGroup();
    try {
      ServerBootstrap b = new ServerBootstrap();

    } finally {
      boosGroup.shutdownGracefully();
      workGroup.shutdownGracefully();
    }
  }

  public static void main(String[] args) {

  }

}
