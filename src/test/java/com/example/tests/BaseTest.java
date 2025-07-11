package com.example.tests;

import com.example.framework.PlaywrightModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public abstract class BaseTest {
    protected static Injector injector;
    protected static Browser browser;
    protected static Page page;

    @BeforeAll
    static void setUpBase() {
        injector = Guice.createInjector(new PlaywrightModule());
        browser = injector.getInstance(Browser.class);
        page = browser.newPage();
    }

    @AfterAll
    static void tearDownBase() {
        if (page != null) {
            page.close();
        }
        if (browser != null) {
            browser.close();
        }
        if (injector != null) {
            injector = null;
        }
    }
}
