package com.sync.sz.netty.protocol.netty.client;

import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;

/**
 * Created by Administrator on 2017/1/9 0009.
 */
public class NettyClient {

  private void connect(int port) throws Exception {
    EventLoopGroup group = new NioEventLoopGroup();
  }

  public static void main(String[] args) throws Exception {
    int port = 8080;
    if (args != null && args.length > 0) {
      try {
        port = Integer.valueOf(args[0]);
      } catch (NumberFormatException e) {

      }
      new NettyClient().connect(port);
    }
  }
}
