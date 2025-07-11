package com.example.framework;

import com.microsoft.playwright.Page;
import java.time.Duration;
import java.util.function.Predicate;

public final class WaitUtil {
    private static final Duration TIMEOUT = Config.waitTimeout();

    private WaitUtil() {}

    public static void waitForSelector(Page page, String selector) {
        page.waitForSelector(selector, new Page.WaitForSelectorOptions().setTimeout(TIMEOUT.toMillis()));
    }

    public static void waitUntil(Page page, Predicate<Page> condition) {
        long end = System.currentTimeMillis() + TIMEOUT.toMillis();
        while (System.currentTimeMillis() < end) {
            if (condition.test(page)) {
                return;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }
        throw new RuntimeException("Condition not met within " + TIMEOUT);
    }
}
