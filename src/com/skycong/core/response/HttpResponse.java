package com.skycong.core.response;

import com.skycong.constant.HttpProtocol;
import com.skycong.constant.HttpStatus;

import java.util.Map;

/**
 * @author RMC 2019/7/6 17:10
 */
public class HttpResponse {

    private HttpProtocol protocol;

    private HttpStatus httpStatus;

    private Map<String, String> headers;

}
