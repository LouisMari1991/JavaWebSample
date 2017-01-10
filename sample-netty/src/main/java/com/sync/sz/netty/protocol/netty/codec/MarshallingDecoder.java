package com.sync.sz.netty.protocol.netty.codec;

import com.sync.sz.netty.codec.marshalling.MarshallingCodeCFactory;
import io.netty.buffer.ByteBuf;
import java.io.IOException;
import org.jboss.marshalling.ByteInput;
import org.jboss.marshalling.Unmarshaller;
import org.msgpack.core.buffer.ChannelBufferInput;

/**
 * Created by YH on 2017-01-10.
 */
public class MarshallingDecoder {
  private final Unmarshaller unmarshaller;

  public MarshallingDecoder() throws IOException {
    unmarshaller = MarshallingCodecFactory.buildUnmarshalling();
  }

  protected Object decode(ByteBuf in) throws Exception {
    int objectSize = in.readInt();
    ByteBuf buf = in.slice(in.readerIndex(), objectSize);
    //ByteInput input = new ChannelBufferByteInput(buf);
    return null;
  }
}
