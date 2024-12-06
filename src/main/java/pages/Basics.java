package pages;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import utils.Hooks;

public class Basics {
    Page page;

    public void goToUrl(String url) {
        page = Hooks.getPage();
        page.navigate(url);
    }

    public String getTextOfElement(){
        return page.locator("button").innerText();
    }

    public Boolean getElementVisibility(){
        return page.locator("button").isVisible();
    }
}