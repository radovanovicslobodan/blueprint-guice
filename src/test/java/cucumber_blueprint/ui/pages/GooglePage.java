package cucumber_blueprint.ui.pages;

import com.google.inject.Inject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GooglePage {
    WebDriver driver;
    @Inject
    WebDriverWait wait;

    @Inject
    public GooglePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "lnXdpd")
    public WebElement logo;

    public String logoLoc = "lnXdpd";

    public WebElement checkLogo() {
        return wait.until(ExpectedConditions.visibilityOf(logo));
    }

    public WebElement checkLambdaLogo() {
        return wait.until(
                driver -> {
                    return driver.findElement(By.className(logoLoc));
                }
        );
    }
}
