package com.sync.sz.netty.protocol.netty.codec;

import com.sync.sz.netty.protocol.netty.struct.NettyMessage;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import java.io.IOException;

/**
 * Created by Administrator on 2017/1/12 0012.
 */
public class NettyMessageEncoder extends MessageToByteEncoder<NettyMessage> {
  MarshallingEncoder marshallingEncoder;

  public NettyMessageEncoder() throws IOException {
    this.marshallingEncoder = new MarshallingEncoder();
  }

  @Override protected void encode(ChannelHandlerContext ctx, NettyMessage msg, ByteBuf out) throws Exception {

  }
}
