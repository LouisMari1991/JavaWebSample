package com.sync.sz.netty.aio;

/**
 * Created by Administrator on 2016/12/24 0024.
 */
public class TimerServer {

  public static void main(String[] args) {
    int port = 8080;
    if (args != null && args.length > 0) {
      try {
        port = Integer.valueOf(port);
      } catch (NumberFormatException e) {
        // 使用默认端口
      }
    }
    AsyncTimeServerHandler timeServer = new AsyncTimeServerHandler(port);
    new Thread(timeServer, "AIO-AsyncTimeServerHandler-001").start();
  }

}
