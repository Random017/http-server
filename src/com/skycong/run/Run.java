package com.skycong.run;

import com.skycong.factory.ThreadPool;
import com.skycong.handler.HttpRequestHandler;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author RMC 2019/7/6 10:36
 */
public class Run {

    public static void main(String[] args) throws IOException {
        int port = 80;
        ServerSocket server = new ServerSocket();
        server.bind(new InetSocketAddress(port));
        while (true) {
            Socket client = server.accept();
            ThreadPool.excute(new HttpRequestHandler(client));
        }
    }

}
