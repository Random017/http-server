package com.skycong.handler;

import com.skycong.constant.HttpMethod;
import com.skycong.constant.HttpProtocol;
import com.skycong.constant.HttpStatus;
import com.skycong.core.request.HttpRequest;
import com.skycong.core.request.HttpRequestBody;
import com.skycong.core.request.HttpRequestHeader;
import com.skycong.core.response.HttpResponse;
import com.skycong.core.response.HttpResponseBody;
import com.skycong.core.response.HttpResponseHeader;
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
        HttpRequest httpRequest = null;
        try {
            String s = _getRequestStr();
            httpRequest = resolveRequestFromRequestString(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return httpRequest;
    }

    private void _setResponse(HttpResponse httpResponse) {
        StringBuilder res = new StringBuilder();
        res.append(httpResponse.getProtocol()).append(StrUtil.BLANK_SPACE)
                .append(httpResponse.getHttpStatus().value()).append(StrUtil.BLANK_SPACE)
                .append(httpResponse.getHttpStatus().getReasonPhrase()).append(StrUtil.LINE_SPLIT)
                .append(httpResponse.getHeaders().toString())
                .append(StrUtil.BLOCK_SPLIT)
                .append(httpResponse.getHttpResponseBody().getResponseString());
        try {
            OutputStream outputStream = request.getOutputStream();
            outputStream.write(res.toString().getBytes());
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setResponse(HttpResponse httpResponse) {
        _setResponse(httpResponse);
    }


    private HttpResponse temmmmmmmmmmm() {
        HttpResponse httpResponse = new HttpResponse();
        httpResponse.setProtocol(HttpProtocol.HTTP_1_1);
        httpResponse.setHttpStatus(HttpStatus.OK);
        HttpResponseHeader httpResponseHeader = new HttpResponseHeader();
        httpResponseHeader.put("head1", "sfasasfsaf");
        httpResponseHeader.put("head3", "sfasasfsaf");
        httpResponseHeader.put("token", "sfasasfsd34234234af");
        httpResponseHeader.put("content-type", "text/plan;charset=utf-8");
        httpResponse.setHeaders(httpResponseHeader);
        HttpResponseBody httpResponseBody = new HttpResponseBody();
        httpResponseBody.setResponseString("我爱王其");
        httpResponse.setHttpResponseBody(httpResponseBody);


        return httpResponse;
    }


    @Override
    public void run() {
        try {
            HttpRequest httpRequest = getHttpRequest();
            System.out.println("httpRequest = " + httpRequest);
            // do something
            setResponse(temmmmmmmmmmm());
        } finally {
            try {
                request.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private HttpRequest resolveRequestFromRequestString(String requestString) {
        HttpRequest httpRequest = new HttpRequest();
        String requestHeaderString, requestBodyString;
        int requestBodySplit = requestString.indexOf(StrUtil.BLOCK_SPLIT);
        if (requestBodySplit > 0) {
            //    有 request body
            requestBodyString = requestString.substring(requestBodySplit);
            requestHeaderString = requestString.substring(0, requestBodySplit);
        } else {
            //    无 request body
            requestBodyString = null;
            requestHeaderString = requestString;
        }
        //解析第一行 获取 method protocol uri
        int first = requestHeaderString.indexOf(StrUtil.LINE_SPLIT);
        String firstString = requestHeaderString.substring(0, first);
        String[] strings = StrUtil.split(firstString, StrUtil.BLANK_SPACE);
        // request method
        HttpMethod httpMethod = HttpMethod.get(strings[0]);
        // request uri
        String requestUri = strings[1];
        // http protocol
        HttpProtocol httpProtocol = HttpProtocol.get(strings[2]);
        // 删除request header 的第一行
        requestHeaderString = requestHeaderString.substring(first);
        HttpRequestHeader httpRequestHeader = resolveRequestHeaderFromRequestString(requestHeaderString);
        HttpRequestBody httpRequestBody = resolveRequestBodyFromRequestString(requestBodyString);
        httpRequest.setProtocol(httpProtocol);
        httpRequest.setMethod(httpMethod);
        httpRequest.setRequestUri(requestUri);
        httpRequest.setHeader(httpRequestHeader);
        httpRequest.setRequestBody(httpRequestBody);
        return httpRequest;
    }

    private HttpRequestHeader resolveRequestHeaderFromRequestString(String requestHeaderString) {
        HttpRequestHeader httpRequestHeader = new HttpRequestHeader();
        String[] headerString = StrUtil.split(requestHeaderString, StrUtil.LINE_SPLIT);
        for (String head : headerString) {
            String[] split = StrUtil.split(head, StrUtil.HEADER_SPLIT);
            String headKey = split[0];
            String headValue = split[1].trim();
            httpRequestHeader.put(headKey, headValue);
        }
        return httpRequestHeader;
    }

    private HttpRequestBody resolveRequestBodyFromRequestString(String requestBodyString) {
        if (requestBodyString == null) return null;
        HttpRequestBody httpRequestBody = new HttpRequestBody();
        httpRequestBody.setBodyString(requestBodyString);
        return httpRequestBody;
    }
}
