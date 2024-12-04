package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Steps1 {
    static Logger log = LoggerFactory.getLogger(Steps1.class);


    @When("open url {string}")
    public void open_url_string(String url) {
        log.info(url);

    }

    @Then("see page title as {string}")
    public void see_page_title_as(String title) {
        log.info(title);
    }
}