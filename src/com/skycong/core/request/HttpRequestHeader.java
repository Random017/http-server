package com.skycong.core.request;

import java.util.HashMap;

/**
 * @author RMC 2019/7/6 17:19
 */
public class HttpRequestHeader extends HashMap<String, String> {

    public void setHeader(String name, String value) {
        put(name, value);
    }

    public String getHeader(String name) {
        return get(name);
    }
}
