package com.example.framework;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

public final class Config {
    private static final Properties PROPS = new Properties();

    static {
        try (InputStream is = Config.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (is != null) {
                PROPS.load(is);
            }
        } catch (IOException e) {
            throw new RuntimeException("Unable to load configuration", e);
        }
    }

    private Config() {}

    public static boolean isHeadless() {
        return Boolean.parseBoolean(PROPS.getProperty("headless", "true"));
    }

    public static Duration waitTimeout() {
        String val = PROPS.getProperty("timeoutInSeconds", "10");
        return Duration.ofSeconds(Long.parseLong(val));
    }
}
