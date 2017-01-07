package com.sync.sz.netty.protocol.http.xml.client;

import com.sync.sz.netty.protocol.http.xml.codec.HttpXmlRequestDecoder;
import com.sync.sz.netty.protocol.http.xml.codec.HttpXmlRequestEncoder;
import com.sync.sz.netty.protocol.http.xml.pojo.Order;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpRequestEncoder;
import java.net.InetSocketAddress;

/**
 * Created by Administrator on 2017/1/7 0007.
 */
public class HttpXmlClient {
  public void connect(int port) throws Exception {
    EventLoopGroup group = new NioEventLoopGroup();
    try {
      Bootstrap b = new Bootstrap();
      b.group(group).channel(NioSocketChannel.class)
          .option(ChannelOption.TCP_NODELAY, true)
          .handler(new ChannelInitializer<SocketChannel>() {
            @Override protected void initChannel(SocketChannel ch) throws Exception {
              ch.pipeline().addLast("http-decoder", new HttpRequestDecoder());
              ch.pipeline().addLast("http-aggregator", new HttpObjectAggregator(65536));
              ch.pipeline().addLast("xml-decoder", new HttpXmlRequestDecoder(Order.class, true));
              ch.pipeline().addLast("http-encoder", new HttpRequestEncoder());
              ch.pipeline().addLast("xml-encoder", new HttpXmlRequestEncoder());
            }
          });
      ChannelFuture f = b.connect(new InetSocketAddress(port)).sync();
      f.channel().closeFuture();
    } finally {
      group.shutdownGracefully();
    }
  }

  public static void main(String[] args) throws Exception {
    int port = 8080;
    if (args != null && args.length > 0) {
      try {
        port = Integer.valueOf(args[0]);
      } catch (NumberFormatException e) {
      }
    }
    new HttpXmlClient().connect(port);
  }
}
