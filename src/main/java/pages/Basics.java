package pages;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import utils.Hooks;

public class Basics {
//    Hooks hooks = new Hooks();
//    Playwright playwright = hooks.getPlaywright();
//    BrowserContext context = hooks.getBrowserContext();
    Page page = Hooks.getPage();

    public void goToUrl(String url) {
        page.navigate(url);
    }

    public String getTextOfElement(){
        return page.locator("button").innerText();
    }

    public Boolean getElementVisibility(){
        return page.locator("button").isVisible();
    }
}