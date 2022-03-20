package cucumber_blueprint.ui.pages.saucedemo;

import com.google.inject.Inject;
import cucumber_blueprint.core.custompagefactory.annotations.FindByTestId;
import cucumber_blueprint.ui.pages.BasePage;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Objects;

public class SaucedemoLoginPage extends BasePage {

    @FindBy(id = "login-button")
    WebElement loginButton;

    @FindByTestId("username")
    WebElement userNameTextInput;

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(className = "error-message-container")
    WebElement errorMessageContainer;

    @Inject
    WebDriverWait wait;

    @Inject
    public SaucedemoLoginPage(WebDriver driver) {
        super(driver);
    }

    public void goTo() {
        driver.get("https://www.saucedemo.com/");
    }

    public void login(String userName, String password) {
        userNameTextInput.clear();
        userNameTextInput.sendKeys(userName);
        passwordInput.clear();
        passwordInput.sendKeys(password);

        loginButton.click();
    }

    public String getErrorMessage() {
        wait.until(ExpectedConditions.visibilityOf(errorMessageContainer));
        String text = errorMessageContainer.getText();
        if (Objects.nonNull(text)) {
            return text.trim();
        }
        return "";
    }

    public void waitUntilPageIsLoaded() {
        try {
            wait.until(ExpectedConditions.visibilityOf(loginButton));
        } catch (Exception e) {
            throw new TimeoutException("Timeout exceeded while waiting for login page to load.");
        }
    }
}
