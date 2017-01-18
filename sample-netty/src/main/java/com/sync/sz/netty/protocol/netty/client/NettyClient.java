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

  public static void main(String[] args) {
    int port = 8080;
  }
}
