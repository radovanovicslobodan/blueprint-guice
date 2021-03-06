package cucumber_blueprint.core.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GlobalHooks {

    @Before(order = 0)
    public void beforeScenario(Scenario scenario) {
        log.info("Scenario: " + scenario.getName() + " started");
    }

    @After(order = 0)
    public void afterScenario(Scenario scenario) {
        log.info("Scenario: " + scenario.getName() + " finished");
    }
}
