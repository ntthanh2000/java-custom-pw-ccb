package pages;

import com.microsoft.playwright.Page;
import locators.PageLocators;

import java.util.Map;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Basics {
    Page page;
    private final Map<String,String> buttonLocators = PageLocators.getButtonLocators();

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

    public void verifyPageTitle(String title){
        assertThat(page).hasTitle(title);
    }

    public void clickButton(String button){
        page.click(buttonLocators.get(button));
    }
}