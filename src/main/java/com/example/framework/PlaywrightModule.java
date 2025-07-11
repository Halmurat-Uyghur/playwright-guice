package com.example.framework;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import javax.inject.Singleton;

public class PlaywrightModule extends AbstractModule {
    @Provides
    @Singleton
    Playwright providePlaywright() {
        return Playwright.create();
    }

    @Provides
    @Singleton
    Browser provideBrowser(Playwright playwright) {
        BrowserType.LaunchOptions options = new BrowserType.LaunchOptions();
        options.setHeadless(true);
        return playwright.chromium().launch(options);
    }
}
