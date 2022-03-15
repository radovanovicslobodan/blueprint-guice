package cucumber_blueprint.ui.steps;

import io.cucumber.java.en.Given;

public class CommonSteps extends BaseUiSteps {

    @Given("User is not logged in")
    public void userIsNotLoggedIn() {
        driver.manage().deleteAllCookies();
    }
}
