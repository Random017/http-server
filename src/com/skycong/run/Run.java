package com.skycong.run;

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

            new Thread(new HttpRequestHandler(client)).start();

            //
            // final boolean[] isFirst = {true};
            // HttpRequest httpRequest = new HttpRequest();
            // httpRequest.setHeaders(new HashMap<>());
            // bufferedReader.lines().forEach(s -> {
            //     if (!Assert.isEmpty(s)) {
            //         System.out.println("s = " + s);
            //         if (isFirst[0]) {
            //             String[] first = StrUtil.splitByBlankSpace(s);
            //             httpRequest.setMethod(HttpMethod.get(first[0]));
            //             httpRequest.setRequestUri(first[1]);
            //             httpRequest.setProtocol(HttpProtocol.get(first[2]));
            //             isFirst[0] = false;
            //         } else {
            //             int i = s.indexOf(":");
            //             String headKey = s.substring(0, i);
            //             String headValue = s.substring(i + 2);
            //             httpRequest.getHeaders().put(headKey, headValue);
            //         }
            //     }
            // });
            //
            // System.out.println("httpRequest = " + httpRequest);
            // client.getOutputStream()
            // bufferedReader.close();
            // inputStream.close();
            // client.getOutputStream().
            //         write(("HTTP/1.1 200 OK\r\n" +  //响应头第一行
            //                 "Content-Type: text/html; charset=utf-8\r\n" +  //简单放一个头部信息
            //                 "\r\n" +  //这个空行是来分隔请求头与请求体的
            //                 "<h1>这是响应报文</h1>\r\n").getBytes());
        }
    }

}
