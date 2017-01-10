package com.sync.sz.netty.protocol.netty.codec;

import java.io.IOException;
import org.jboss.marshalling.Marshaller;
import org.jboss.marshalling.MarshallerFactory;
import org.jboss.marshalling.Marshalling;
import org.jboss.marshalling.MarshallingConfiguration;
import org.jboss.marshalling.Unmarshaller;

/**
 * Created by YH on 2017-01-10.
 */
public class MarshallingCodecFactory {
  protected static Marshaller buildMarshalling() throws IOException {
    final MarshallerFactory marshallerFactory = Marshalling.getProvidedMarshallerFactory("serial");
    final MarshallingConfiguration configuration = new MarshallingConfiguration();
    configuration.setVersion(5);
    Marshaller marshaller = marshallerFactory.createMarshaller(configuration);
    return marshaller;
  }

  protected static Unmarshaller buildUnmarshalling() throws IOException {
    final MarshallerFactory marshallerFactory = Marshalling.getProvidedMarshallerFactory("serial");
    final MarshallingConfiguration configuration = new MarshallingConfiguration();
    configuration.setVersion(5);
    final Unmarshaller unmarshaller = marshallerFactory.createUnmarshaller(configuration);
    return unmarshaller;
  }
}
