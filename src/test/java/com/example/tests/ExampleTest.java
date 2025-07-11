package com.example.tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ExampleTest extends BaseTest {
    @Test
    void homePageHasTitle() {
        page.navigate("https://playwright.dev/");
        String title = page.title();
        assertTrue(title.contains("Playwright"));
    }
}
