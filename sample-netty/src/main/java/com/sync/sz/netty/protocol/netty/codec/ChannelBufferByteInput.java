package com.sync.sz.netty.protocol.netty.codec;

import io.netty.buffer.ByteBuf;
import java.io.IOException;
import org.jboss.marshalling.ByteInput;

/**
 * Created by Administrator on 2017/1/10 0010.
 */
public class ChannelBufferByteInput implements ByteInput {
  private final ByteBuf buffer;

  public ChannelBufferByteInput(ByteBuf buffer) {
    this.buffer = buffer;
  }

  @Override public int read() throws IOException {
    if (buffer.isReadable()) {
      return buffer.readByte() & 0xff;
    }
    return -1;
  }

  @Override public int read(byte[] bytes) throws IOException {
    return read(bytes, 0, bytes.length);
  }

  @Override public int read(byte[] dest, int dstIndex, int length) throws IOException {
    int available = available();
    if (available == 0) {
      return -1;
    }
    length = Math.min(available, length);
    buffer.readBytes(dest, dstIndex, length);
    return length;
  }

  @Override public int available() throws IOException {
    return buffer.readableBytes();
  }

  @Override public long skip(long bytes) throws IOException {
    int readable = buffer.readableBytes();
    if (readable < bytes) {
      bytes = readable;
    }
    buffer.readerIndex((int) (buffer.readerIndex() + bytes));
    return bytes;
  }

  @Override public void close() throws IOException {
    // no thing to do
  }
}
