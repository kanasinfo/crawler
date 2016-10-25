package com.ch;

import com.ch.core.RequestParams;
import com.ch.utils.PropertiesUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * Created by Devid on 2016/10/25.
 */
public class Main {
    public static void main(String[] args) throws IOException {

        initParams();

        Document doc = Jsoup.connect(PropertiesUtils.getProperties("url.list"))
                .cookies(RequestParams.getInstance().getCookies())
                .get();
        String title = doc.title();
        System.out.println(title);
    }

    private static void initParams() throws IOException {
        Connection.Response res = Jsoup.connect(PropertiesUtils.getProperties("url.login"))
                .data(
                        PropertiesUtils.getProperties("form.login.key.username"), "devid.ge",
                        PropertiesUtils.getProperties("form.login.key.password"), "aibing0420"
                )
                .method(Connection.Method.POST)
                .ignoreContentType(true)
                .execute();
        RequestParams.getInstance().setCookies(res.cookies());
    }
}
