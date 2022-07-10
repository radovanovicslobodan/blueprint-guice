package cucumber_blueprint.rest.steps;

import com.google.inject.Inject;
import cucumber_blueprint.core.api.RestScenarioContext;
import cucumber_blueprint.rest.pojos.SimpleObj;
import io.cucumber.java.en.Then;

import static org.assertj.core.api.Assertions.assertThat;

public class CommonSteps {
    @Inject
    RestScenarioContext restScenarioContext;
    @Inject
    SimpleObj simpleObj;

    @Then("Response status code is {int}")
    public void responseStatusIs(int statusCode) {
        System.out.println("CommonSteps " + simpleObj.text);
        assertThat(restScenarioContext.response.getStatusCode()).isEqualTo(statusCode);
    }
}
