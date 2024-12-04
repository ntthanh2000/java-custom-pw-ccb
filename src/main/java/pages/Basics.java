package pages;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import utils.Hooks;

public class Basics {
    Hooks hooks = new Hooks();
    Playwright playwright = hooks.getPlaywright();
    BrowserContext context = hooks.getBrowserContext();
    Page page = hooks.getPage();

    public void goToUrl(String url) {
        page.navigate(url);
    }

    public void getTextOfElement(){

    }
}