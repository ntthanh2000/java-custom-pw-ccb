package utils;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

public class Utils {
    String headless = System.getenv("headless");

    public BrowserType.LaunchOptions setChromeOptions() {
        BrowserType.LaunchOptions options = new BrowserType.LaunchOptions();
        options.setHeadless(Boolean.parseBoolean(headless));
        return options;
    }

    public Browser launchBrowser(Playwright playwright, String browserName) {
        BrowserType.LaunchOptions options;
        Browser browser;
        switch (browserName) {
            case "chrome":
                options = setChromeOptions();
                browser = playwright.chromium().launch(options);
                break;
            case "edge":
                options = new BrowserType.LaunchOptions().setChannel("msedge");
                browser = playwright.chromium().launch(options);
                break;
            case "firefox":
                browser = playwright.firefox().launch();
                break;
            case "webkit":
                browser = playwright.webkit().launch();
                break;
            default:
                browser = playwright.chromium().launch();
                break;
        }
        return browser;
    }
}