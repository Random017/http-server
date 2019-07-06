package com.skycong.handler;

import com.skycong.core.request.HttpRequest;
import com.skycong.util.StrUtil;
import com.skycong.util.StreamUtil;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author RMC 2019/7/6 16:49
 */
public class HttpRequestHandler implements Runnable {

    private Socket request;

    public HttpRequestHandler(Socket request) {
        this.request = request;
    }

    private String _getRequestStr() throws IOException {
        return StreamUtil.readFromInputStream(request.getInputStream());
    }

    public HttpRequest getHttpRequest() {
        try {
            String s = _getRequestStr();
            System.out.println("s = " + s);

            return new HttpRequest();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new HttpRequest();
    }

    private void setResponse() throws IOException {
        StringBuilder res = new StringBuilder();
        //响应头
        res.append("http/1.1 200 ok").append(StrUtil.SPLITSTR);
        res.append("head1:va1").append(StrUtil.SPLITSTR);
        res.append("head2:va33").append(StrUtil.SPLITSTR);
        res.append("content-type:text/plan;charset=utf-8").append(StrUtil.SPLITSTR);
        //响应体
        res.append(StrUtil.SPLITSTR);
        res.append("响应内容");
        OutputStream outputStream = request.getOutputStream();
        outputStream.write(res.toString().getBytes());
        outputStream.flush();
        outputStream.close();
    }

    @Override
    public void run() {
        getHttpRequest();
        try {
            setResponse();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                request.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
