package com.ch;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * Created by Devid on 2016/10/25.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("http://zentao.fbi-china.com/zentao/index.php?m=bug&f=browse").get();
        String title = doc.title();
        System.out.println(title);
    }
}
