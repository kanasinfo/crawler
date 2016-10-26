package com.ch.service;

import com.ch.utils.FetchUtils;
import com.ch.utils.PropUtils;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ListIterator;

/**
 * Created by Devid on 2016/10/26.
 */
public class FetchListService {
    private static final String QUERY_URL = "/query?q=&s=ka&s=sr&s=jr&s=mr&s=accept360&p=kwbw&start=";

    public String fetchPage(String url) throws IOException {
        Document document = FetchUtils.getByUrl(url);
        String pageFun = document.select("div[align='center'] script").outerHtml();
        System.out.println("pageFun: " + pageFun);
//        TODO

        String funParam = "'184163','15','1','/query?q=&s=ka&s=sr&s=jr&s=mr&s=accept360&p=kwbw&start='".replace("'", "");
        String[] params = StringUtils.split(",");

        return null;
    }

    private Document listPage(String url, int start){
        String fetchUrl = PropUtils.getProp("url.server") + QUERY_URL + start;
        FetchUtils.getByUrl(fetchUrl)
    }

    public void fetchList(String url) throws IOException {
        Document document = FetchUtils.getByUrl(url);
        ListIterator listIterator = document.select("table ol li a").listIterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }
    }
}
