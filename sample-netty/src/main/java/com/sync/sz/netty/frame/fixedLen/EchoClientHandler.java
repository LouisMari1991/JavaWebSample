package com.sync.sz.netty.frame.fixedLen;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import java.util.logging.Logger;

/**
 * Created by YH on 2016-12-27.
 */
public class EchoClientHandler extends ChannelHandlerAdapter {

  private static final Logger logger = Logger.getLogger(EchoClientHandler.class.getName());

  @Override public void channelActive(ChannelHandlerContext ctx) throws Exception {

  }

  @Override public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

  }

  @Override public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    logger.warning(cause.getMessage());
    ctx.close();
  }
}
