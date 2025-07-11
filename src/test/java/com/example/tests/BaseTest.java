package com.example.tests;

import com.example.framework.PlaywrightModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public abstract class BaseTest {
    protected static Injector injector;
    protected static Browser browser;
    protected BrowserContext context;
    protected Page page;

    @BeforeAll
    static void setUpBase() {
        injector = Guice.createInjector(new PlaywrightModule());
        browser = injector.getInstance(Browser.class);
    }

    @BeforeEach
    void setUp() {
        context = browser.newContext();
        page = context.newPage();
    }

    @AfterEach
    void tearDown() {
        if (page != null) {
            page.close();
        }
        if (context != null) {
            context.close();
        }
    }

    @AfterAll
    static void tearDownBase() {
        if (browser != null) {
            browser.close();
        }
        if (injector != null) {
            injector = null;
        }
    }
}
