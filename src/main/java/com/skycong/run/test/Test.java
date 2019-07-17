package com.skycong.run.test;

import com.skycong.constant.HttpProtocol;
import com.skycong.constant.HttpStatus;
import com.skycong.core.HttpService;
import com.skycong.core.request.HttpRequest;
import com.skycong.core.response.HttpResponse;
import com.skycong.core.response.HttpResponseBody;
import com.skycong.core.response.HttpResponseHeader;

/**
 * @author RMC 2019/7/16 11:07
 */
public class Test implements HttpService {

    @Override
    public void service(HttpRequest request, HttpResponse response) {
        response.setProtocol(HttpProtocol.HTTP_1_1);
        response.setHttpStatus(HttpStatus.OK);
        HttpResponseHeader httpResponseHeader = new HttpResponseHeader();
        httpResponseHeader.put("content-type", "text/plan;charset=utf-8");
        response.setHeaders(httpResponseHeader);
        HttpResponseBody httpResponseBody = new HttpResponseBody();
        httpResponseBody.setResponseString("响应内容" + request);
        response.setHttpResponseBody(httpResponseBody);
    }
}