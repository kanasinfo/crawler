package com.ch.utils;

import com.ch.core.RequestParams;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * Created by Devid on 2016/10/25.
 */
public final class FetchUtils {
    public static Document getByUrl(String url) throws IOException {
        Document doc = Jsoup.connect(url)
                .cookies(RequestParams.getInstance().getCookies())
                .get();
        return doc;
    }
}
