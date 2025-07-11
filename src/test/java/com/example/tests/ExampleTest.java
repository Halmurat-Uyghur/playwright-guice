package com.example.tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.example.framework.WaitUtil;

class ExampleTest extends BaseTest {
    @Test
    void homePageHasTitle() {
        page.navigate("https://playwright.dev/");
        WaitUtil.waitForSelector(page, "text=Get started");
        String title = page.title();
        assertTrue(title.contains("Playwright"));
    }
}
