package cucumber_blueprint.rest.support;

import cucumber_blueprint.constants.HttpMethod;
import cucumber_blueprint.constants.Paths;
import cucumber_blueprint.core.api.SpecBuilder;
import cucumber_blueprint.rest.pojos.AuthBody;
import cucumber_blueprint.utils.ApiUtils;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AuthHelpers {

    public static Response postCreateAuthToken(String username, String password) {

        AuthBody body = new AuthBody(username, password);

        RequestSpecification requestSpec = SpecBuilder
                .requestSpecBuilder()
                .setBasePath(Paths.AUTH)
                .setBody(body)
                .build();

        return ApiUtils.sendRequest(requestSpec, HttpMethod.POST);
    }
}
