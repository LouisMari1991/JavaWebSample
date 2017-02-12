package com.sync.sz.netty.protocol.netty.client;

import com.sync.sz.netty.protocol.netty.MessageType;
import com.sync.sz.netty.protocol.netty.struct.Header;
import com.sync.sz.netty.protocol.netty.struct.NettyMessage;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * Created by YH on 2017-02-12.
 */
public class HeartBeatReqHandler extends ChannelHandlerAdapter {

  private volatile ScheduledFuture<?> heartBeat;

  @Override public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
    NettyMessage message = (NettyMessage) msg;
    // 握手成功，主动发送心跳消息
    if (message.getHeader() != null && message.getHeader().getType() == MessageType.LOGIN_RESP.value()) {
      heartBeat = ctx.executor().scheduleAtFixedRate(
          new HeartBeatReqHandler.HeartBeatTask(ctx), 0, 5000, TimeUnit.MILLISECONDS
      );
    } else if (message.getHeader() != null && message.getHeader().getType() == MessageType.HEARTBEAT_RESP.value()) {
      System.out.println("Client receiver heart beat message : ---> " + message);
    } else {
      ctx.fireChannelRead(msg);
    }
  }

  private class HeartBeatTask implements Runnable {

    private final ChannelHandlerContext ctx;

    public HeartBeatTask(ChannelHandlerContext ctx) {
      this.ctx = ctx;
    }

    @Override public void run() {
      NettyMessage heatBeat = buildHeatBeat();
      System.out.println("Client send heart beat message to server : ---> ");
      ctx.writeAndFlush(heatBeat);
    }

    private NettyMessage buildHeatBeat() {
      NettyMessage message = new NettyMessage();
      Header header = new Header();
      header.setType(MessageType.HEARTBEAT_REQ.value());
      message.setHeader(header);
      return message;
    }
  }

  @Override public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    cause.printStackTrace();
    if (heartBeat != null) {
      heartBeat.cancel(true);
      heartBeat = null;
    }
    ctx.fireExceptionCaught(cause);
  }
}
