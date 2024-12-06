package utils;

import com.microsoft.playwright.*;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Paths;


public class Hooks {
//    public static Playwright playwright;
//    static Browser browser;
    static final Logger log = LoggerFactory.getLogger(Hooks.class);
    static final Utils utils = new Utils();
//    BrowserContext context;
    public Page page;


//    @BeforeAll
//    public static void launchBrowser() {
//        log.info("Opening browser...");
//        playwright = Playwright.create();
//        browser = utils.launchBrowser(playwright, "chrome");
//    }

//    @AfterAll
//    public static void closeBrowser() {
//        log.info("Closing browser...");
//        playwright.close();
//    }

    @Before
    public void createContextAndPage() {
        log.info("Opening browser...");
        page = utils.initDriver();
    }

    @After
    public void closeContext() {
//        page.close();
        log.info("Closing browser...");
        page.close();
    }
}