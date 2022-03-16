package cucumber_blueprint.ui.steps;

import com.google.inject.Inject;
import cucumber_blueprint.core.driver.support.DriverHelpers;
import cucumber_blueprint.ui.pages.conduit.ConduitHomePage;
import cucumber_blueprint.ui.pages.conduit.ConduitLoginPage;
import cucumber_blueprint.utils.support.ConduitTokenHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;

import static org.assertj.core.api.Assertions.assertThat;

public class ConduitSteps extends BaseUiSteps {

    @Inject
    JavascriptExecutor js;

    @Inject
    DriverHelpers driverHelpers;

    @Inject
    ConduitHomePage homePage;

    @Inject
    ConduitLoginPage loginPage;

    @When("User navigates to Conduit home page")
    public void userNavigatesToConduitHomePage() {
        js.executeScript("document.body.style.backgroundColor='red';");
        driver.get("https://redux.productionready.io/");
    }

    @When("User is logged in")
    public void userIsLoggedIn() {
        String jwt = ConduitTokenHelper.postCreateConduitToken("test@test.me", "123456");
        driver.get("https://redux.productionready.io/");
        driverHelpers.setItemToLocalStorage("jwt", jwt);
        driver.navigate().refresh();
    }

    @And("User clicks on sign in button")
    public void userClickOnSignInButton() {
        homePage.goToLogin();
    }

    @And("User enters {string} and {string} in login form fields")
    public void userEnterUsernamePassword(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("Users avatar is displayed in header")
    public void usersAvatarIsDisplayed() {
        assertThat(homePage.checkUserAvatar()).isTrue();
    }

    @Then("User has no articles in feed")
    public void userHasNoArticlesInFeed() {
        System.out.println("User has no articles in feed step");
    }
}
