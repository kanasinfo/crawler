package com.ch;

import com.ch.service.FetchService;
import com.ch.utils.PropUtils;
import org.apache.log4j.Logger;

import java.io.IOException;

/**
 * Created by Devid on 2016/10/25.
 */
public class Main {
    private static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        FetchService service = new FetchService();
        try {
            service.fetchPage(1);
        } catch (IOException e) {
            logger.info(e);
        }
    }

}
