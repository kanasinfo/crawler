package com.ch.service;

import com.ch.core.RequestParams;
import com.ch.utils.PropUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;

/**
 * Created by Devid on 2016/10/25.
 */
public class LoginService {
    private final String username = PropUtils.getProp("form.login.value.username");
    private final String password = PropUtils.getProp("form.login.value.password");

    public void login() throws IOException {
        Connection.Response res = Jsoup.connect(PropUtils.getProp("url.login"))
                .data(
                        PropUtils.getProp("form.login.key.username"), username,
                        PropUtils.getProp("form.login.key.password"), password
                )
                .method(Connection.Method.POST)
                .ignoreContentType(true)
                .execute();
        RequestParams.getInstance().setCookies(res.cookies());
    }
}
