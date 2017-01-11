package com.sync.sz.netty.protocol.netty.codec;

import io.netty.buffer.ByteBuf;
import java.io.IOException;
import org.jboss.marshalling.ByteOutput;

/**
 * Created by Administrator on 2017/1/11 0011.
 */
public class ChannelBufferByteOutput implements ByteOutput {

  private final ByteBuf buffer;

  public ChannelBufferByteOutput(ByteBuf buffer) {
    this.buffer = buffer;
  }

  @Override public void write(int b) throws IOException {

  }

  @Override public void write(byte[] b) throws IOException {

  }

  @Override public void write(byte[] b, int off, int len) throws IOException {

  }

  @Override public void close() throws IOException {

  }

  @Override public void flush() throws IOException {

  }
}
