package utils;

import com.microsoft.playwright.*;

public class Utils {
    //thread vars to run parallel
    public static ThreadLocal<Page> pageInstance = new ThreadLocal<>();
    public static ThreadLocal<BrowserContext> contextInstance = new ThreadLocal<>();

    //headless value is false by default
    String headless = System.getenv("headless");

    public BrowserType.LaunchOptions setChromeOptions() {
        BrowserType.LaunchOptions options = new BrowserType.LaunchOptions();
        options.setHeadless(Boolean.parseBoolean(headless));
        return options;
    }

    public Page initDriver(){
        Playwright playwright = Playwright.create();
        Browser browser = launchBrowser(playwright, "chrome");
        BrowserContext context = browser.newContext();
        Page page = context.newPage();
        pageInstance.set(page);
        contextInstance.set(context);
        return page;
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

    public void closeDriver(){
        contextInstance.get().close();
    }

    public static synchronized Page getPage(){
        return pageInstance.get();
    }

    public static synchronized BrowserContext getContext(){
        return contextInstance.get();
    }
}