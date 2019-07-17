package com.skycong.core.response;

import com.skycong.constant.HttpProtocol;
import com.skycong.constant.HttpStatus;

/**
 * @author RMC 2019/7/6 17:10
 */
public class HttpResponse {

    private HttpProtocol protocol;

    private HttpStatus httpStatus;

    private HttpResponseHeader headers;

    private HttpResponseBody httpResponseBody;

    public HttpProtocol getProtocol() {
        return protocol;
    }

    public void setProtocol(HttpProtocol protocol) {
        this.protocol = protocol;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public HttpResponseHeader getHeaders() {
        return headers;
    }

    public void setHeaders(HttpResponseHeader headers) {
        this.headers = headers;
    }

    public HttpResponseBody getHttpResponseBody() {
        return httpResponseBody;
    }

    public void setHttpResponseBody(HttpResponseBody httpResponseBody) {
        this.httpResponseBody = httpResponseBody;
    }

}
