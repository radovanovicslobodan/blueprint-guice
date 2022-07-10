package cucumber_blueprint.core.api;

import cucumber_blueprint.utils.ConfigurationManager;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;

import static cucumber_blueprint.utils.ConfigUtils.envConfig;

public class SpecBuilder {

    public static RequestSpecBuilder requestSpecBuilder() {
        var configuration = ConfigurationManager.getConfiguration();

//        System.out.println("BASE_REST_URI " + configuration.baseRestUri());
        System.out.println(envConfig.baseRestUri());
        
        RequestSpecBuilder builder = new RequestSpecBuilder();

        builder.setBaseUri(envConfig.baseRestUri());
        builder.setContentType(ContentType.JSON);
        return builder;
    }
}
