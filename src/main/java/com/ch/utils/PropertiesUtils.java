package com.ch.utils;

import com.ch.Main;

import java.io.*;
import java.util.Properties;

/**
 * Created by Devid on 2016/10/25.
 */
public class PropertiesUtils {
    private static final String CONFIG_NAME = "config.properties";
    private static Properties properties = null;

    public synchronized static String getProperties(String key){
        if(properties == null){
            InputStream inputStream = PropertiesUtils.class.getResourceAsStream("/"+CONFIG_NAME);
            properties = new Properties();
            try {
                properties.load(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        return properties.getProperty(key);
    }
}
