package com.ch.service;

import com.ch.utils.FetchUtils;
import com.ch.utils.PropUtils;
import org.apache.log4j.Logger;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ListIterator;

/**
 * Created by Devid on 2016/10/26.
 */
public class FetchService {
    private static final Logger logger = Logger.getLogger(FetchService.class);
    private static final String QUERY_URL = "/query?q=&s=ka&s=sr&s=jr&s=mr&s=accept360&p=kwbw&start=";
    private static final int PAGE_SIZE = 15;

    /**
     * 递归获取列表页
     */
    public void fetchPage(int start) throws IOException {
        logger.info("开始抓取数据： " + start);
        String fetchUrl = PropUtils.getProp("url.server") + QUERY_URL + start;
        try {
            Document document = FetchUtils.getByUrl(fetchUrl);
            // TODO 需要判断EOF 是否继续地轨抓取
            fetchList(document);
            start += PAGE_SIZE;
            fetchPage(start);
        } catch (IOException e) {   // 抛出异常，抓取失败，停止抓取
            logger.info(e);
        }
    }

    /**
     * 获取列表页中的15个条目
     */
    public void fetchList(Document document) {
        logger.info("抓取列表中的条目：" + document);
        ListIterator listIterator = document.select("table ol li a").listIterator();
        while (listIterator.hasNext()) {
            Document detailDoc = (Document) listIterator.next();
            logger.info("列表： " + detailDoc);
            // TODO 处理条目信息
            String detailUrl = PropUtils.getProp("url.server") + detailDoc.attr("href");
            fetchDetail(detailUrl);
        }
    }

    /**
     * 获取列表页中的15个条目
     */
    public void fetchList(String url) throws IOException {
        Document document = FetchUtils.getByUrl(url);
        fetchList(document);
    }

    public void fetchDetail(String url){

    }
}
