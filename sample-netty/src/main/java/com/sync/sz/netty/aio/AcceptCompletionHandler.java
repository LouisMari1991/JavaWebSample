package com.sync.sz.netty.aio;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * Created by Administrator on 2016/12/24 0024.
 */
public class AcceptCompletionHandler implements CompletionHandler<AsynchronousSocketChannel, AsyncTimerServerHandler> {

  @Override public void completed(AsynchronousSocketChannel result, AsyncTimerServerHandler attachment) {
    attachment.asynchronousServerSocketChannel.accept(attachment, this);
    ByteBuffer buffer = ByteBuffer.allocate(1024);
    result.read(buffer, buffer, new ReadCompletionHandler(result));
  }

  @Override public void failed(Throwable exc, AsyncTimerServerHandler attachment) {
    exc.printStackTrace();
    attachment.latch.countDown();
  }
}
