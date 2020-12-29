package com.tankGame.manage;

import java.io.IOException;
import java.util.Properties;

public class PropertiesMag {

    static Properties properties = new Properties();
    private static PropertiesMag propertiesMag = new PropertiesMag();

    static {
        try {
            properties.load(PropertiesMag.class.getClassLoader().getResourceAsStream("config/config"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private PropertiesMag() {
    }

    public static PropertiesMag getProperMagInstance() {
        return propertiesMag;
    }

    public Integer getInt(String key) {
        return Integer.valueOf(properties.get(key).toString());
    }

    public String getStr(String key) {
        return properties.get(key).toString();
    }

}
