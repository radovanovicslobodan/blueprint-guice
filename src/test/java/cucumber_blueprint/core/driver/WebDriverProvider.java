package cucumber_blueprint.core.driver;

import com.google.inject.Provider;
import cucumber_blueprint.constants.Props;
import io.cucumber.guice.ScenarioScoped;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

import static cucumber_blueprint.core.driver.support.DriverOptions.chromeOptions;
import static cucumber_blueprint.core.driver.support.DriverOptions.firefoxOptions;
import static cucumber_blueprint.utils.ConfigUtils.getProp;

@ScenarioScoped
public class WebDriverProvider implements Provider<WebDriver> {

    public WebDriver driver;

    @Override
    public WebDriver get() {
        switch (getProp(Props.DRIVER_TYPE)) {
            case "headlessChrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(chromeOptions(true));
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                break;

            case "headlessFirefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver(firefoxOptions(true));
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                break;

            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(chromeOptions(false));
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver(firefoxOptions(false));
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + getProp(Props.DRIVER_TYPE));
        }

        return driver;
    }

//    public void takeScreenshot(String scenarioName) {
//        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        try {
//            FileUtils.copyFile(scrFile, new File(screenshotPath + scenarioName + ".png"));
//        } catch (Exception e) {
//        }
//    }
//
//    public void addScreenshotAllure(String scenarioName) {
//        Path content = Paths.get(screenshotPath + scenarioName + ".png");
//        try (InputStream is = Files.newInputStream(content)) {
//            Allure.addAttachment(scenarioName, is);
//        } catch (Exception e) {
//        }
//    }
}
