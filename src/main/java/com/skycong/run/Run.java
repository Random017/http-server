package com.skycong.run;

import com.skycong.factory.ThreadPool;
import com.skycong.handler.HttpRequestHandler;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author RMC 2019/7/6 10:36
 */
public class Run {

    public static void main(String[] args) throws Exception {
        int port = 8080;
        ServerSocket server = new ServerSocket();
        server.bind(new InetSocketAddress(port));
        while (true) {
            Socket client = server.accept();
            ThreadPool.execute(new HttpRequestHandler(client));
        }
    }
}
