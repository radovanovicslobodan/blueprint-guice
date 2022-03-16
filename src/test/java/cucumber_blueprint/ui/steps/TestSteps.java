package cucumber_blueprint.ui.steps;

import com.google.inject.Inject;
import cucumber_blueprint.core.driver.support.DriverHelpers;
import cucumber_blueprint.ui.pages.GooglePage;
import cucumber_blueprint.ui.pages.SpotifyPage;
import cucumber_blueprint.ui.pages.WikipediaPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class TestSteps extends BaseUiSteps {

    @Inject
    DriverHelpers driverHelpers;

    @Inject
    GooglePage googlePage;

    @Inject
    SpotifyPage spotifyPage;

    @Inject
    WikipediaPage wikipediaPage;

    @When("Wikipedia page is opened")
    public void openWikipediaPage() {
        driver.get("https://www.wikipedia.org/");
    }

    @Then("Wikipedia logo is present")
    public void checkWikipediaLogo() {
        assertions.assertThat(wikipediaPage.checkLogo().isDisplayed());
        assertions.assertThat(wikipediaPage.checkLogo().isEnabled());
        assertions.assertAll();
    }

    @When("Google page is opened")
    public void openGooglePage() {
        driver.get("https://www.google.com/");
    }

    @Then("Google logo is present")
    public void checkGoogleLogo() {
        assertions.assertThat(googlePage.checkLogo().isDisplayed());
        assertions.assertThat(googlePage.checkLogo().isEnabled());
        assertions.assertAll();
    }

    @When("Spotify page is opened")
    public void openSpotifyPage() {
        driver.get("https://open.spotify.com/");
        driverHelpers.setItemToLocalStorage("testkey", "testvalue");
    }

    @Then("Spotify logo is present")
    public void checkSpotifyLogo() {
//        assertions.assertThat(spotifyPage.checkLogoFluent().isDisplayed());
//        assertions.assertThat(spotifyPage.checkLogoFluent().isEnabled());
//        assertions.assertAll();
        assertThat(false).isTrue();
    }
}
