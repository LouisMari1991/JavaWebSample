package com.sync.sz.netty.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by YH on 2016-12-21.
 */
public class TimeServer {

  public static void main(String[] args) throws IOException {
    int port = 8080;
    if (args != null && args.length > 0) {
      try {
        port = Integer.valueOf(args[0]);
      } catch (NumberFormatException e) {
        // use default port;
      }
    }
    ServerSocket server = null;
    try {
      server = new ServerSocket(port);
      System.out.printf("The time server is start in port : " + port);
      Socket socket = null;
      TimeServerHandlerExecutePool singleExecutor = new TimeServerHandlerExecutePool(50, 1000);
      while (true) {
        socket = server.accept();
        singleExecutor.exector(new TimeServerHandler(socket));
      }
    } finally {
      if (server != null) {
        System.out.printf("The time server close");
        server.close();
        server = null;
      }
    }
  }
}
