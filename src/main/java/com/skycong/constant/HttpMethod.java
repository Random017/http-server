package com.skycong.constant;

/**
 * @author RMC 2019/7/6 10:57
 */
public enum HttpMethod {
    POST, GET, OPTIONS, PUT, DELETE;

    public static HttpMethod get(String method) {
        HttpMethod[] values = HttpMethod.values();
        for (HttpMethod value : values) {
            if (value.name().equals(method.toUpperCase())) {
                return value;
            }
        }
        throw new IllegalArgumentException("not support http method");
    }
}
