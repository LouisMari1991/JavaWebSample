package com.sync.sz.netty.protocol.netty.server;

import com.sync.sz.netty.protocol.netty.MessageType;
import com.sync.sz.netty.protocol.netty.struct.Header;
import com.sync.sz.netty.protocol.netty.struct.NettyMessage;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import java.net.InetSocketAddress;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by YH on 2017-02-12.
 */
public class LoginAuthRespHandler extends ChannelHandlerAdapter {

  private Map<String, Boolean> nodeCheck = new ConcurrentHashMap<>();

  @Override public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
    NettyMessage message = (NettyMessage) msg;
    // 如果是握手请求消息，处理，其他消息透传
    if (message.getHeader() != null && message.getHeader().getType() == MessageType.LOGIN_REQ.value()) {
      String nodeIndex = ctx.channel().remoteAddress().toString();
      NettyMessage loginResp = null;
      // 重复登录，拒绝
      if (nodeCheck.containsKey(nodeIndex)) {
        loginResp = buildResponse((byte) -1);
      } else {
        InetSocketAddress address = (InetSocketAddress) ctx.channel().remoteAddress();
        String ip = address.getAddress().getHostAddress();
        boolean isOK = false;
        if ("127.0.0.1".equals(ip)) {
          isOK = true;
        }
        loginResp = isOK ? buildResponse((byte) 0)
            : buildResponse((byte) -1);
      }
      System.out.println("The login response is : " + loginResp + " body [" + loginResp.getBody() + "]");
      ctx.writeAndFlush(loginResp);
    } else {
      ctx.fireChannelRead(msg);
    }
  }

  private NettyMessage buildResponse(byte result) {
    NettyMessage message = new NettyMessage();
    Header header = new Header();
    header.setType(MessageType.LOGIN_RESP.value());
    message.setHeader(header);
    message.setBody(result);
    return message;
  }

  @Override public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    cause.printStackTrace();
    nodeCheck.remove(ctx.channel().remoteAddress().toString());// 删除缓存
    ctx.close();
    ctx.fireExceptionCaught(cause);
  }
}
