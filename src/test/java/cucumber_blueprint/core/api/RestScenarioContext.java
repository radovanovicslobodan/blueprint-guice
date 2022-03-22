package cucumber_blueprint.core.api;

import io.cucumber.guice.ScenarioScoped;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

@ScenarioScoped
public class RestScenarioContext {

    public Response response;
    public RequestSpecification requestSpec;
    public Map<String,Object> requestBody;
    public String authToken;
}
