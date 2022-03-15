package cucumber_blueprint.core.hooks;

import com.google.inject.Inject;
import cucumber_blueprint.core.driver.helpers.DriverHelpers;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class DriverHooks {

    @Inject
    WebDriver driver;

    @Inject
    DriverHelpers driverHelpers;

    @After(value = "@ui")
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed() && driver != null) {
            driverHelpers.takeScreenshot(scenario.getName());
            driverHelpers.addScreenshotAllure(scenario.getName());
        }

        if (driver != null) {
            driver.manage().deleteAllCookies();
            driver.quit();
        }
    }
}
