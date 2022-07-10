package cucumber_blueprint.utils;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config.properties"
})
public interface Configuration extends Config {
    @Config.Key("REST_URI")
    String baseRestUri();
}
