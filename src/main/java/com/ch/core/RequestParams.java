package com.ch.core;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Devid on 2016/10/25.
 */
public class RequestParams {
    private static RequestParams ourInstance = new RequestParams();

    private Map<String, String> cookies = new HashMap<>();

    public static RequestParams getInstance() {
        return ourInstance;
    }

    private RequestParams() {
    }

    public Map<String, String> getCookies() {
        return cookies;
    }

    public void setCookies(Map<String, String> cookies) {
        this.cookies = cookies;
    }
}
