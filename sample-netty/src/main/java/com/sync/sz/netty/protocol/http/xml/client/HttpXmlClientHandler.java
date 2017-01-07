package com.sync.sz.netty.protocol.http.xml.client;

import com.sync.sz.netty.protocol.http.xml.codec.HttpXmlRequest;
import com.sync.sz.netty.protocol.http.xml.codec.HttpXmlResponse;
import com.sync.sz.netty.protocol.http.xml.pojo.OrderFactory;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Created by Administrator on 2017/1/7 0007.
 */
public class HttpXmlClientHandler extends SimpleChannelInboundHandler<HttpXmlResponse> {

  @Override public void channelActive(ChannelHandlerContext ctx) throws Exception {
    HttpXmlRequest request = new HttpXmlRequest(null,
        OrderFactory.create(123));
    ctx.writeAndFlush(request);
  }

  @Override protected void messageReceived(ChannelHandlerContext ctx, HttpXmlResponse msg) throws Exception {
    System.out.println("The client receive response of http header is : " + msg.getHttpResponse().headers().names());
    System.out.println("The client receive response of http body is : " + msg.getResult());
  }

  @Override public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    cause.printStackTrace();
    ctx.close();
  }
}
