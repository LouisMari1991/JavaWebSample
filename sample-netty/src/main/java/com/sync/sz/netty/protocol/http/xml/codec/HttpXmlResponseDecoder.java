package com.sync.sz.netty.protocol.http.xml.codec;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import java.util.List;

/**
 * Created by Administrator on 2017/1/7 0007.
 */
public class HttpXmlResponseDecoder extends AbstractHttpXmlDecoder<DefaultFullHttpResponse> {
  protected HttpXmlResponseDecoder(Class<?> clazz) {
    super(clazz);
  }

  protected HttpXmlResponseDecoder(Class<?> clazz, boolean isPrint) {
    super(clazz, isPrint);
  }

  @Override protected void decode(ChannelHandlerContext ctx, DefaultFullHttpResponse msg, List<Object> out) throws Exception {
    HttpXmlResponse resHttpXmlResponse = new HttpXmlResponse(msg, decode0(ctx, msg.content()));
    out.add(resHttpXmlResponse);
  }
}
