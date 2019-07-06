package com.skycong.core.request;

import com.skycong.constant.HttpMethod;
import com.skycong.constant.HttpProtocol;

/**
 * @author RMC 2019/7/6 10:57
 */
public class HttpRequest {

    // s = GET / HTTP/1.1

    // s = Host: 127.0.0.1
    // s = Connection: keep-alive
    // s = Cache-Control: max-age=0
    // s = Upgrade-Insecure-Requests: 1
    // s = User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.169 Safari/537.36
    // s = Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3
    // s = Accept-Encoding: gzip, deflate, br
    // s = Accept-Language: zh-CN,zh;q=0.9

    private HttpProtocol protocol;

    private HttpMethod method;

    private String requestUri;

    private HttpRequestHeader header;

    private HttpRequestBody requestBody;

    public HttpProtocol getProtocol() {
        return protocol;
    }

    public void setProtocol(HttpProtocol protocol) {
        this.protocol = protocol;
    }

    public HttpMethod getMethod() {
        return method;
    }

    public void setMethod(HttpMethod method) {
        this.method = method;
    }

    public String getRequestUri() {
        return requestUri;
    }

    public void setRequestUri(String requestUri) {
        this.requestUri = requestUri;
    }

    public HttpRequestHeader getHeader() {
        return header;
    }

    public void setHeader(HttpRequestHeader header) {
        this.header = header;
    }

    public HttpRequestBody getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(HttpRequestBody requestBody) {
        this.requestBody = requestBody;
    }
}
