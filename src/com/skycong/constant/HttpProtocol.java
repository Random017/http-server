package com.skycong.constant;

/**
 * @author RMC 2019/7/6 11:01
 */
public enum HttpProtocol {

    HTTP_1_0("HTTP/1.0"),
    HTTP_1_1("HTTP/1.1"),
    HTTP_2_0("HTTP/2.0"),
    ;

    private String protocol;

    HttpProtocol(String protocol) {
        this.protocol = protocol;
    }

    public static HttpProtocol get(String protocol) {
        protocol = protocol.toUpperCase();
        if (HTTP_1_0.protocol.equals(protocol)) return HTTP_1_0;
        if (HTTP_1_1.protocol.equals(protocol)) return HTTP_1_1;
        if (HTTP_2_0.protocol.equals(protocol)) return HTTP_2_0;
        else throw new IllegalArgumentException("http protocol error");
    }
}
