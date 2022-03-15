package cucumber_blueprint.utils.helpers;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import cucumber_blueprint.constants.HttpMethod;
import cucumber_blueprint.core.api.SpecBuilder;
import cucumber_blueprint.utils.ApiUtils;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ConduitTokenHelper {

    public static String postCreateConduitToken(String email, String password) {

        JsonObject user = new JsonObject();
        JsonObject credentials = new JsonObject();

        credentials.addProperty("email", email);
        credentials.addProperty("password", password);

        user.add("user", credentials);

        String payload = new Gson().toJson(user);

        RequestSpecification requestSpec = SpecBuilder
                .requestSpecBuilder()
                .setBaseUri("https://api.realworld.io")
                .setBasePath("api/users/login")
                .setBody(payload)
                .build();

        Response response = ApiUtils.sendRequest(requestSpec, HttpMethod.POST);

        JsonPath js = new JsonPath(response.body().asString());

        return js.get("user.token").toString();
    }
}
