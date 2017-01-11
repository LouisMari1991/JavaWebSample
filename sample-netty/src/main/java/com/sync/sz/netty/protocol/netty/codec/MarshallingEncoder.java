package com.sync.sz.netty.protocol.netty.codec;

import java.io.IOException;
import org.jboss.marshalling.Unmarshaller;

/**
 * Created by Administrator on 2017/1/11 0011.
 */
public class MarshallingEncoder {
  private final Unmarshaller unmarshaller;

  public MarshallingEncoder() throws Exception {
    this.unmarshaller = MarshallingCodecFactory.buildUnmarshalling();
  }
}
