package pages;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import utils.Hooks;

public class Basics {
    Page page;
//    Hooks hooks;

    public Basics(Page page){
        this.page = page;
    }

    public void goToUrl(String url) {
//        page = hooks.getPage();
        this.page.navigate(url);
    }

    public String getTextOfElement(){
        return page.locator("button").innerText();
    }

    public Boolean getElementVisibility(){
        return page.locator("button").isVisible();
    }
}