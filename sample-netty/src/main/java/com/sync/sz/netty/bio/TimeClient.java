package com.sync.sz.netty.bio;

import java.net.Socket;

/**
 * Created by YH on 2016-12-21.
 */
public class TimeClient {

    public static void main(String[] args) {
        int port = 8080;
        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
                // use default port;
            }
        }
        Socket socket = null;
    }

}
