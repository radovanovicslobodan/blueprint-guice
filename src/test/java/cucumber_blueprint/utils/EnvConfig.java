package cucumber_blueprint.utils;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:config.properties"
})
public interface EnvConfig extends Config {

    @Config.Key("driverType")
    @DefaultValue("chrome")
    String driverType();

    @Config.Key("baseRestUri")
    String baseRestUri();

    @Config.Key("baseWebUri")
    String baseWebUri();
}
