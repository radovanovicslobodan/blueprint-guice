package cucumber_blueprint.utils;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.FIRST)
@Config.Sources({
        "classpath:config.properties",
        "system:properties"
})
public interface EnvConfig extends Config {

    @Config.Key("driverType")
    @DefaultValue("chrome")
    String driverType();

    @Config.Key("REST_URI")
    String baseRestUri();

    @Config.Key("baseWebUri")
    String baseWebUri();
}
