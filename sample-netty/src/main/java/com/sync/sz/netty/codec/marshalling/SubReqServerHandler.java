package com.sync.sz.netty.codec.marshalling;

import com.sync.sz.netty.codec.serializable.pojo.SubScribeReq;
import com.sync.sz.netty.codec.serializable.pojo.SubscribeResp;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * Created by Administrator on 2017/1/3 0003.
 */
public class SubReqServerHandler extends ChannelHandlerAdapter {

  @Override public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
    SubScribeReq req = (SubScribeReq) msg;
    if ("SYNC".equalsIgnoreCase(req.getUserName())) {
      System.out.println("Service accept client subscrib req : [" + req.toString() + "]");
      ctx.writeAndFlush(resp(req.getSubReqID()));
    }
  }

  public SubscribeResp resp(int subReqID) {
    SubscribeResp resp = new SubscribeResp();
    resp.setSubReqID(subReqID);
    resp.setRespCode(0);
    resp.setDesc("Netty book order succeed, 3 days later, sent to the designated address");
    return resp;
  }

  @Override public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    cause.printStackTrace();
    ctx.close();
  }
}
