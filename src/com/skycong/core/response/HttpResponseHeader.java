package com.skycong.core.response;

import com.skycong.util.StrUtil;

import java.util.HashMap;
import java.util.Set;

/**
 * @author RMC 2019/7/6 19:45
 */
public class HttpResponseHeader extends HashMap<String, String> {

    public void setHeader(String name, String value) {
        put(name, value);
    }

    public String getHeader(String name) {
        return get(name);
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        Set<String> keys = this.keySet();
        for (String key : keys) {
            sb.append(key).append(StrUtil.HEADER_SPLIT).append(StrUtil.BLANK_SPACE)
                    .append(this.get(key)).append(StrUtil.LINE_SPLIT);
        }
        return sb.toString();
    }
}
