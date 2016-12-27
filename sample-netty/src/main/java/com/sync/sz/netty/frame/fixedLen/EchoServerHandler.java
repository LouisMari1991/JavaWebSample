package com.sync.sz.netty.frame.fixedLen;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * Created by YH on 2016-12-27.
 */
public class EchoServerHandler extends ChannelHandlerAdapter {

  private int counter;

  @Override public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
    System.out.println("this timer : " + counter + " ; Receiver client : [" + msg + "]");
    ctx.writeAndFlush("Hello XN.");
    counter++;
  }

  @Override public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    ctx.close();
  }
}
