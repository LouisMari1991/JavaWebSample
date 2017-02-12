package com.sync.sz.netty.protocol.netty.server;

import com.sync.sz.netty.protocol.netty.MessageType;
import com.sync.sz.netty.protocol.netty.struct.Header;
import com.sync.sz.netty.protocol.netty.struct.NettyMessage;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * Created by YH on 2017-02-12.
 */
public class HeartBeatRespHandler extends ChannelHandlerAdapter {

  @Override public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
    NettyMessage message = (NettyMessage) msg;
    // 返回心跳应答消息
    if (message != null && message.getHeader().getType() == MessageType.HEARTBEAT_REQ.value()) {
      System.out.println("Receive client heart beat message : ---> " + message);
      NettyMessage heartBeat = buildHeatBeat();
      System.out.println("Send heart beat response message to client : ---> " + heartBeat);
      ctx.writeAndFlush(heartBeat);
    } else {
      ctx.fireChannelRead(msg);
    }
  }

  private NettyMessage buildHeatBeat() {
    NettyMessage message = new NettyMessage();
    Header header = new Header();
    header.setType(MessageType.HEARTBEAT_RESP.value());
    message.setHeader(header);
    return message;
  }
}
