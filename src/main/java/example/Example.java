package example;

import com.microsoft.playwright.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.Hooks;

public class Example{
    public static void main(String[] args) {
        Logger log = LoggerFactory.getLogger(Example.class);
        try(Playwright playwright = Playwright.create()){
            BrowserType.LaunchOptions options = new BrowserType.LaunchOptions();
            options.setHeadless(Boolean.parseBoolean("false"));
            Browser browser = playwright.chromium().launch(options);
            BrowserContext bc = browser.newContext();
            Page page = bc.newPage();
            page.navigate("https://playwright.dev/java/");
            log.info(String.format("Page title: %s", page.title()));
        }
    }
}