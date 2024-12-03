package org.example;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Custom1 {
    // Shared between all tests in this class.
    static Playwright playwright;
    static Browser browser;
    static Logger logger = LoggerFactory.getLogger(Custom1.class);

    // New instance for each test method.
    BrowserContext context;
    Page page;

    @BeforeAll
    static void launchBrowser() {
        logger.info("Opening browser...");
        playwright = Playwright.create();
        BrowserType.LaunchOptions options = new BrowserType.LaunchOptions();
        options.setHeadless(false);
        browser = playwright.chromium().launch(options);
    }

    @AfterAll
    static void closeBrowser() {
        logger.info("Closing browser...");
        playwright.close();
    }

    @BeforeEach
    void createContextAndPage() {
        context = browser.newContext();
        page = context.newPage();
    }

    @AfterEach
    void closeContext() {
        context.close();
    }

    @Test
    void shouldClickButton() {
        page.navigate("https://playwright.dev/java/");
        String text = page.locator("a[class=\"getStarted_Sjon\"]").textContent();
        logger.info(text);
//        page.locator("a[class=\"getStarted_Sjon\"]").
//        assertEquals("Installation | Playwright Java", page.title());
    }
}