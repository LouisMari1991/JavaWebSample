package com.sync.sz.netty.protocol.netty.codec;

import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import java.nio.ByteOrder;

/**
 * Created by Administrator on 2017/1/12 0012.
 */
public class NettyMessageDecoder extends LengthFieldBasedFrameDecoder {
  public NettyMessageDecoder(int maxFrameLength, int lengthFieldOffset, int lengthFieldLength) {
    super(maxFrameLength, lengthFieldOffset, lengthFieldLength);
  }

  public NettyMessageDecoder(int maxFrameLength, int lengthFieldOffset, int lengthFieldLength,
      int lengthAdjustment, int initialBytesToStrip) {
    super(maxFrameLength, lengthFieldOffset, lengthFieldLength, lengthAdjustment, initialBytesToStrip);
  }

  public NettyMessageDecoder(int maxFrameLength, int lengthFieldOffset, int lengthFieldLength,
      int lengthAdjustment, int initialBytesToStrip, boolean failFast) {
    super(maxFrameLength, lengthFieldOffset, lengthFieldLength, lengthAdjustment, initialBytesToStrip, failFast);
  }

  public NettyMessageDecoder(ByteOrder byteOrder, int maxFrameLength, int lengthFieldOffset,
      int lengthFieldLength, int lengthAdjustment, int initialBytesToStrip, boolean failFast) {
    super(byteOrder, maxFrameLength, lengthFieldOffset, lengthFieldLength, lengthAdjustment, initialBytesToStrip,
        failFast);
  }
}
