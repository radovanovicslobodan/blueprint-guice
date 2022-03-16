package cucumber_blueprint.core.driver.support;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.HashMap;

public class DriverOptions {

    public static ChromeOptions chromeOptions(boolean headless) {
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
//        chromePrefs.put("download.default_directory", System.getProperty("user.dir") + "\\src\\test\\resources\\downloaded_files");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(headless);
        chromeOptions.addArguments("start-maximized");
        chromeOptions.addArguments("--disable-extensions");
        chromeOptions.addArguments("--disable-infobars");
        chromeOptions.addArguments("--ignore-certificate-errors");
        chromeOptions.setExperimentalOption("prefs", chromePrefs);
//        chromeOptions.addArguments("window-size=1920,1080");
        return chromeOptions;
    }

    public static FirefoxOptions firefoxOptions(boolean headless) {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
//        firefoxOptions.addArguments("start-maximized");
        firefoxOptions.addArguments("--disable-extensions");
        firefoxOptions.addArguments("--ignore-certificate-errors");
        firefoxOptions.addArguments("--disable-infobars");
        firefoxOptions.addArguments("--disable-gpu");
        firefoxOptions.setHeadless(headless);
        // FIXME: headless???
        firefoxOptions.setAcceptInsecureCerts(headless);
        return firefoxOptions;
    }
}
