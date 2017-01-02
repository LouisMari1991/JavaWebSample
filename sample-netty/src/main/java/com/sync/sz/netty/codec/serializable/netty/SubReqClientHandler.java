package com.sync.sz.netty.codec.serializable.netty;

import com.sync.sz.netty.codec.serializable.pojo.SubScribeReq;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * Created by Administrator on 2017/1/1 0001.
 */
public class SubReqClientHandler extends ChannelHandlerAdapter {

  public SubReqClientHandler() {

  }

  @Override public void channelActive(ChannelHandlerContext ctx) throws Exception {
    for (int i = 0; i < 10; i++) {
      ctx.write(subReq(i));
    }
    ctx.flush();
  }

  private SubScribeReq subReq(int i) {
    SubScribeReq req = new SubScribeReq();
    req.setAddress("深圳市南山区");
    req.setProductName("Netty");
    req.setSubReqID(i);
    req.setUserName("SYNC");
    return req;
  }

  @Override public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
    System.out.println("Receiver server response : [" + msg + "]");
  }

  @Override public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
    ctx.flush();
  }

  @Override public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    cause.printStackTrace();
    ctx.close();
  }
}
