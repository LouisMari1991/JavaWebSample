package com.sync.sz.netty.frame.delimiter;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import java.util.logging.Logger;

/**
 * Created by YH on 2016-12-27.
 */
public class EchoClientHandler extends ChannelHandlerAdapter {

  private static final Logger logger = Logger.getLogger(EchoClientHandler.class.getName());

  private int counter;

  static final String ECHO_REQ = "Hi,XN. Welcome to Netty.$_";

  public EchoClientHandler() {

  }

  @Override public void channelActive(ChannelHandlerContext ctx) throws Exception {
    for (int i = 0; i < 10; i++) {
      ctx.writeAndFlush(Unpooled.copiedBuffer(ECHO_REQ.getBytes()));
    }
  }

  @Override public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
    System.out.println("This is " + ++counter + " times receiver server : [" + msg + "]");
  }

  @Override public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    logger.warning(cause.toString());
    ctx.close();
  }
}
