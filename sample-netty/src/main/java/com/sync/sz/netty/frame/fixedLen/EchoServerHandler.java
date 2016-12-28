package com.sync.sz.netty.frame.fixedLen;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * Created by YH on 2016-12-27.
 */
public class EchoServerHandler extends ChannelHandlerAdapter {

  private int counter;

  @Override public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
    System.out.println("this timer : " + counter + " ; Receiver client : [" + msg + "]");
    ctx.writeAndFlush(Unpooled.copiedBuffer("Hi,XN. Welcome to N.".getBytes()));
    counter++;
  }

  @Override public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    ctx.close();
  }
}
