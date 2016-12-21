package com.sync.sz.netty.nio;

/**
 * Created by YH on 2016-12-21.
 */
public class TimerServer {

    public static void main(String[] args) {
        int port = 8080;
        if (args != null & args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NullPointerException e) {
                // Use default port
            }
        }

    }

}
