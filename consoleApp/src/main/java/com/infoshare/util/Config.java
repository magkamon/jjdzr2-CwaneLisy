package com.infoshare.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public enum Config {
    IS_VALIDATOR_ENABLED;

    static Properties properties;
    String value;

    Config() {
        init();
    }

    private void init() {
        properties = new Properties();
        try {
            InputStream inputStream = Config.class.getClassLoader().getResourceAsStream("config.properties");
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        value = (String) properties.get(this.toString());

    }
    public boolean getBooleanValue() {
        return Boolean.parseBoolean(value);

    }

    public String getValue() {
        return value;
    }
}
