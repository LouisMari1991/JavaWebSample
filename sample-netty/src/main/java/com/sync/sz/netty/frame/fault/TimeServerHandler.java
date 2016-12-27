package com.sync.sz.netty.frame.fault;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import java.util.Date;

/**
 * Created by YH on 2016-12-27.
 */
public class TimeServerHandler extends ChannelHandlerAdapter {

  private int counter;

  @Override public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
    ByteBuf buf = (ByteBuf) msg;
    byte[] req = new byte[buf.readableBytes()];
    buf.readBytes(req);
    String body = new String(req, "UTF-8").substring(0, req.length - System.getProperty("line.separator").length());
    System.out.printf("The time server receiver order : " + body + " ; the counter is : " + ++counter);
    String currentTime =
        "QUERY ORDER TIME".equalsIgnoreCase(body) ? new Date(System.currentTimeMillis()).toString() : "BAD QUERY";

    currentTime = currentTime + System.getProperty("line.separator");
    ByteBuf resp = Unpooled.copiedBuffer(currentTime.getBytes());
    ctx.writeAndFlush(resp);
  }

  @Override public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    ctx.close();
  }
}
