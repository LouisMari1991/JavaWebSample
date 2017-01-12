package com.sync.sz.netty.protocol.netty.codec;

import java.io.IOException;

/**
 * Created by Administrator on 2017/1/12 0012.
 */
public class NettyMessageEncoder {
  MarshallingEncoder marshallingEncoder;

  public NettyMessageEncoder() throws IOException {
    this.marshallingEncoder = new MarshallingEncoder();
  }


}
