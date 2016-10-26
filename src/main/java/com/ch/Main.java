package com.ch;

import com.ch.service.FetchListService;
import com.ch.service.LoginService;
import com.ch.utils.FetchUtils;
import com.ch.utils.PropUtils;
import org.apache.log4j.Logger;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ListIterator;

/**
 * Created by Devid on 2016/10/25.
 */
public class Main {
    private static final Logger logger = Logger.getLogger(Main.class);

        FetchListService service = new FetchListService();
        service.fetchPage(PropUtils.getProp("url.list"));
    }


}
