package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.Basics;
import utils.Utils;

public class Steps1 {
    Logger log = LoggerFactory.getLogger(Steps1.class);
    Basics basics = new Basics(Utils.getPage());

    @When("open url {string}")
    public void open_url_string(String url) {
        log.info(url);
        basics.goToUrl(url);

    }

    @Then("see page title as {string}")
    public void see_page_title_as_string(String title) {
        log.info(title);
        basics.verifyPageTitle(title);
    }

    @When("click button {string}")
    public void click_button_string(String button) {
        basics.clickButton(button);
    }
}