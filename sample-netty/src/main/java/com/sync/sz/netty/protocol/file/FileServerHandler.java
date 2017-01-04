package com.sync.sz.netty.protocol.file;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpRequest;

/**
 * Created by YH on 2017-01-04.
 */
public class FileServerHandler extends SimpleChannelInboundHandler<FullHttpRequest> {
  @Override protected void messageReceived(ChannelHandlerContext ctx, FullHttpRequest msg) throws Exception {

  }
}
