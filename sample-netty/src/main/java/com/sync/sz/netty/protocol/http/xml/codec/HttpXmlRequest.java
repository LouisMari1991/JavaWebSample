package com.sync.sz.netty.protocol.http.xml.codec;

import io.netty.handler.codec.http.FullHttpRequest;

/**
 * Created by Administrator on 2017/1/7 0007.
 */
public class HttpXmlRequest {
  private FullHttpRequest request;
  private Object body;

  public HttpXmlRequest(FullHttpRequest request, Object body) {
    this.request = request;
    this.body = body;
  }

  public final FullHttpRequest getRequest() {
    return request;
  }

  public final void setRequest(FullHttpRequest request) {
    this.request = request;
  }

  public final Object getBody() {
    return body;
  }

  public final void setBody(Object body) {
    this.body = body;
  }

  @Override public String toString() {
    return "HttpXmlRequest{" +
        "request=" + request +
        ", body=" + body +
        '}';
  }
}