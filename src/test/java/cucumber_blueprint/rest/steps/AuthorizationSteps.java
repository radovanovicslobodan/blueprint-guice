package cucumber_blueprint.rest.steps;

import com.google.inject.Inject;
import cucumber_blueprint.core.api.RestScenarioContext;
import cucumber_blueprint.rest.support.AuthHelpers;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class AuthorizationSteps {

    @Inject
    private RestScenarioContext restScenarioContext;

    @When("Token request with username {string} and password {string} is sent")
    public void tokenRequestWithUsernameAndPasswordSent(String username, String password) {
        restScenarioContext.response = AuthHelpers.postCreateAuthToken(username, password);
    }

    @Then("Response status code is {int}")
    public void responseStatusIs(int statusCode) {
        assertThat(restScenarioContext.response.getStatusCode()).isEqualTo(statusCode);
    }

    @And("Response contains token")
    public void responseContainsToken() {
        restScenarioContext.authToken = restScenarioContext.response.path("token").toString();
        assertThat(restScenarioContext.authToken).isNotNull();
    }
}
