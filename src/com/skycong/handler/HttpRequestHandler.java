package com.skycong.handler;

import com.skycong.core.request.HttpRequest;
import com.skycong.core.request.HttpRequestBody;
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

    public HttpRequest getHttpRequest() {
        HttpRequest httpRequest = new HttpRequest();
        try {
            String s = _getRequestStr();
            int i = s.indexOf(StrUtil.BLOCK_SPLIT);
            if (i>0){
                String requestBody = s.substring(i);
                HttpRequestBody httpRequestBody = new HttpRequestBody();
                httpRequestBody.setBodyString(requestBody);
                httpRequest.setRequestBody(httpRequestBody);
            }else {
                i = s.length();
            }
            String head = s.substring(0, i);


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
        res.append("http/1.1 200 ok").append(StrUtil.Line_split);
        res.append("head1:va1").append(StrUtil.Line_split);
        res.append("head2:va33").append(StrUtil.Line_split);
        res.append("content-type:text/plan;charset=utf-8").append(StrUtil.Line_split);
        //响应体
        res.append(StrUtil.Line_split);
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
