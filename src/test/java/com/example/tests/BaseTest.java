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
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Execution(ExecutionMode.CONCURRENT)
public abstract class BaseTest {
    protected Injector injector;
    protected Browser browser;
    protected com.microsoft.playwright.Playwright playwright;
    protected BrowserContext context;
    protected Page page;

    @BeforeAll
    void setUpBase() {
        injector = Guice.createInjector(new PlaywrightModule());
        playwright = injector.getInstance(com.microsoft.playwright.Playwright.class);
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
    void tearDownBase() {
        if (browser != null) {
            browser.close();
        }
        if (playwright != null) {
            playwright.close();
        }
        if (injector != null) {
            injector = null;
        }
    }
}
