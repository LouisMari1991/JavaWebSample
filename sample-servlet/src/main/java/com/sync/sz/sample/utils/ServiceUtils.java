package com.sync.sz.sample.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import sun.misc.BASE64Encoder;

/**
 * Created by Administrator on 2017/2/25 0025.
 */
public class ServiceUtils {

  public static String md5(String message) {
    try {
      MessageDigest md = MessageDigest.getInstance("md5");
      byte[] md5 = md.digest(message.getBytes());
      BASE64Encoder encoder = new BASE64Encoder();
      return encoder.encode(md5);
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException(e);
    }
  }
}
