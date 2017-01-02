package com.sync.sz.netty.codec.msgpack;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.msgpack.MessagePack;

/**
 * Created by Administrator on 2017/1/2 0002.
 */
public class MsgpackEncoder extends MessageToByteEncoder<Object> {
  @Override protected void encode(ChannelHandlerContext ctx, Object msg, ByteBuf out) throws Exception {
    MessagePack msgpack = new MessagePack();
    byte[] raw = msgpack.write(ctx);
    out.writeBytes(raw);
  }
}
