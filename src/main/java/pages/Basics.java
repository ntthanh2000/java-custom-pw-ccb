package pages;

import com.microsoft.playwright.Page;

public class Basics {
    Page page;

    public Basics(Page page) {
        this.page = page;
    }

    public void goToUrl(String url) {
        page.navigate(url);
    }

    public String getTextOfElement() {
        return page.locator("button").innerText();
    }

    public Boolean getElementVisibility() {
        return page.locator("button").isVisible();
    }
}