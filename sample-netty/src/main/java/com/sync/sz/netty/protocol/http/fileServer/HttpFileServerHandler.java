package com.sync.sz.netty.protocol.http.fileServer;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpRequest;

/**
 * Created by YH on 2017-01-04.
 */
public class HttpFileServerHandler extends SimpleChannelInboundHandler<FullHttpRequest> {

  private final String url;

  public HttpFileServerHandler(String url) {
    this.url = url;
  }

  @Override protected void messageReceived(ChannelHandlerContext ctx, FullHttpRequest msg) throws Exception {

  }
}
