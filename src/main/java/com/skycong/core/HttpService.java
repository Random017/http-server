package com.skycong.core;

import com.skycong.core.request.HttpRequest;
import com.skycong.core.response.HttpResponse;

/**
 * @author RMC 2019/7/16 11:04
 */
public interface HttpService {

    void service(HttpRequest request, HttpResponse response);
}
