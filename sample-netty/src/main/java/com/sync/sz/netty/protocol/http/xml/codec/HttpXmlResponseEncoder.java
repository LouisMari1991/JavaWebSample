package com.sync.sz.netty.protocol.http.xml.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import java.util.List;

/**
 * Created by Administrator on 2017/1/7 0007.
 */
public class HttpXmlResponseEncoder extends AbstractHttpXmlEncoder<HttpXmlResponse> {
  @Override protected void decode(ChannelHandlerContext ctx, HttpXmlResponse msg, List<Object> out) throws Exception {
    ByteBuf body = encode0(ctx, msg.getResult());
    FullHttpResponse response = msg.getHttpResponse();
    if (response == null) {
      response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, body);
    } else {
      response = new DefaultFullHttpResponse(msg.getHttpResponse().getProtocolVersion(), msg.getHttpResponse().getStatus(), body);
    }
    response.headers().set(HttpHeaders.Names.CONTENT_TYPE, "text/xml");
    HttpHeaders.setContentLength(response, body.readableBytes());
    out.add(response);

  }
}
