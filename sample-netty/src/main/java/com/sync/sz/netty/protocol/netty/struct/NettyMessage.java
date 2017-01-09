package com.sync.sz.netty.protocol.netty.struct;

/**
 * Created by Administrator on 2017/1/9 0009.
 */
public class NettyMessage {
  private Header header;
  private Object body;

  public Header getHeader() {
    return header;
  }

  public void setHeader(Header header) {
    this.header = header;
  }

  public Object getBody() {
    return body;
  }

  public void setBody(Object body) {
    this.body = body;
  }

  @Override public String toString() {
    return "NettyMessage{" +
        "header=" + header +
        ", body=" + body +
        '}';
  }
}
