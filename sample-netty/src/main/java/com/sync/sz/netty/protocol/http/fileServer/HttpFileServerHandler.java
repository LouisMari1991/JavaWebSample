package com.sync.sz.netty.protocol.http.fileServer;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.util.CharsetUtil;
import java.io.File;
import javax.activation.MimetypesFileTypeMap;

/**
 * Created by YH on 2017-01-04.
 */
public class HttpFileServerHandler extends SimpleChannelInboundHandler<FullHttpRequest> {

  private final String url;

  public HttpFileServerHandler(String url) {
    this.url = url;
  }

  @Override protected void messageReceived(ChannelHandlerContext ctx, FullHttpRequest msg) throws Exception {
    if (!msg.getDecoderResult().isSuccess()) {

    }
  }

  private static void sendListing(ChannelHandlerContext ctx, File dir) {
    FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK);
    response.headers().set(HttpHeaders.Names.CONTENT_TYPE, "text/html; charset=UTF-8");
    StringBuilder buf = new StringBuilder();
    String dirPath = dir.getPath();
    //buf.append()
  }

  private static void sendRedirect(ChannelHandlerContext ctx, String newUri) {
    FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.FOUND);
    response.headers().set(HttpHeaders.Names.LOCATION, newUri);
    ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
  }

  private static void sendError(ChannelHandlerContext ctx, HttpResponseStatus status) {
    FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, status,
        Unpooled.copiedBuffer("Failure: " + status.toString() + "\r\n", CharsetUtil.UTF_8));
    response.headers().set(HttpHeaders.Names.CONTENT_TYPE, "text/plain; charset=UTF-8");
    ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
  }

  private static void sendContentTypeHeader(HttpResponse response, File file) {
    MimetypesFileTypeMap mimeTypesMap = new MimetypesFileTypeMap();
    response.headers().set(HttpHeaders.Names.CONTENT_TYPE, mimeTypesMap.getContentType(file.getPath()));
  }
}
