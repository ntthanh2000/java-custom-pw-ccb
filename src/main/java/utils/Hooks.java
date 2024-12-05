package utils;

import com.microsoft.playwright.*;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Hooks {
    static Playwright playwright;
    static Browser browser;
    static final Logger log = LoggerFactory.getLogger(Hooks.class);
    static final Utils utils = new Utils();
    BrowserContext context;
    Page page;

    @BeforeAll
    public static void launchBrowser() {
        log.info("Opening browser...");
        playwright = Playwright.create();
        browser = utils.launchBrowser(playwright, "chrome");
    }

    @AfterAll
    public static void closeBrowser() {
        log.info("Closing browser...");
        playwright.close();
    }

    @Before
    void createContextAndPage() {
        context = browser.newContext();
        page = context.newPage();
    }

    @After
    void closeContext() {
        context.close();
    }

    public Playwright getPlaywright() {
        return playwright;
    }

    public BrowserContext getBrowserContext() {
        return context;
    }

    public Page getPage() {
        return page;
    }
}