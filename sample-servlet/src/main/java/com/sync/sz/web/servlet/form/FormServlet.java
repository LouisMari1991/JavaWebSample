package com.sync.sz.web.servlet.form;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sun.misc.BASE64Encoder;

/**
 * Created by YH on 2017-02-19.
 */
public class FormServlet extends HttpServlet {

  @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    // 产生随机数
    String token = TokenProcessor.getInstance().generateToken();
    req.getSession().setAttribute("token", token);
    req.getRequestDispatcher("jsp/form.jsp").forward(req, resp);
  }

  @Override protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    this.doGet(req, resp);
  }
}

class TokenProcessor {

  private TokenProcessor() {

  }

  private static TokenProcessor INSTANCE = new TokenProcessor();

  public static TokenProcessor getInstance() {
    return INSTANCE;
  }

  public String generateToken() {
    String token = System.currentTimeMillis() + new Random().nextInt() + "";
    try {
      // MD5加密 128位，16个字节(8位一个字节)
      MessageDigest messageDigest = MessageDigest.getInstance("md5");
      byte[] md5 = messageDigest.digest(token.getBytes());

      //BASE64 把3个字节变成4个字节,BASE64编码后每个字节只装6位,少了2位在前面2位补两个零
      // 这样就把3个字节变成了4个字节,不管任何字节最小数是0，最大是00111111,所以每个字节最大不会超过64
      // BASE64 自己有一个码表,每一个数字对应一个字符,所以任何数据BASE64编码以后,都是键盘上的字符,是明文字符。

      //base64
      BASE64Encoder encoder = new BASE64Encoder();
      return encoder.encode(md5);
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException(e);
    }
  }
}