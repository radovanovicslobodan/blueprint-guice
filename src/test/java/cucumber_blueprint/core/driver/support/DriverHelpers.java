package cucumber_blueprint.core.driver.support;

import com.google.inject.Inject;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DriverHelpers {

    @Inject
    TakesScreenshot takesScreenshot;

    @Inject
    WebStorage webStorage;

    private String screenshotPath = "build/allure-results/";

    public void takeScreenshot(String scenarioName) {
        File scrFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(screenshotPath + scenarioName + ".png"));
        } catch (Exception e) {
        }
    }

    public void addScreenshotAllure(String scenarioName) {
        Path content = Paths.get(screenshotPath + scenarioName + ".png");
        try (InputStream is = Files.newInputStream(content)) {
            Allure.addAttachment(scenarioName, is);
        } catch (Exception e) {
        }
    }

    public String getItemFromLocalStorage(String key) {
        LocalStorage localStorage = webStorage.getLocalStorage();
        return localStorage.getItem(key);
    }

    public void setItemToLocalStorage(String key, String value) {
        LocalStorage localStorage = webStorage.getLocalStorage();
        localStorage.setItem(key, value);
    }

    public void clearLocalStorage() {
        LocalStorage localStorage = webStorage.getLocalStorage();
        localStorage.clear();
    }
}
