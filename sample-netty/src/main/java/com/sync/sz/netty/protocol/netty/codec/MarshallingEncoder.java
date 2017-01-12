package com.sync.sz.netty.protocol.netty.codec;

import io.netty.buffer.ByteBuf;
import java.io.IOException;
import org.jboss.marshalling.Marshaller;

/**
 * Created by Administrator on 2017/1/11 0011.
 */
public class MarshallingEncoder {

  private static final byte[] LENGTH_PLACEHOLDER = new byte[4];
  private final Marshaller marshaller;

  public MarshallingEncoder() throws IOException {
    this.marshaller = MarshallingCodecFactory.buildMarshalling();
  }

  protected Object encode(Object msg, ByteBuf out) throws Exception {
    try {
      int lengthPos = out.writerIndex();
      out.writeBytes(LENGTH_PLACEHOLDER);
      ChannelBufferByteOutput output = new ChannelBufferByteOutput(out);
      marshaller.start(output);
      marshaller.writeObject(msg);
      marshaller.finish();
      out.setInt(lengthPos, out.writerIndex() - lengthPos - 4);
    } finally {
      marshaller.close();
    }
    return null;
  }
}
