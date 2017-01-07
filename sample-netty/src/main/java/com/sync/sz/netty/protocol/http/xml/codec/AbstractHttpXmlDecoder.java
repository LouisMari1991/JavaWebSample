package com.sync.sz.netty.protocol.http.xml.codec;

import io.netty.handler.codec.MessageToMessageDecoder;
import java.io.StringReader;
import org.jibx.runtime.IBindingFactory;

/**
 * Created by Administrator on 2017/1/7 0007.
 */
public abstract class AbstractHttpXmlDecoder<T> extends MessageToMessageDecoder<T> {
  private IBindingFactory factory;
  private StringReader reader;
  private Class<T> clazz;
  private boolean isPrint;
}
