package cucumber_blueprint.ui.pages;

import com.google.inject.Inject;
import cucumber_blueprint.core.custompagefactory.CustomPageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    protected final WebDriver driver;

    @Inject
    public BasePage(WebDriver driver){
        this.driver = driver;
        CustomPageFactory.initElements(driver,this);
    }

    public abstract void waitUntilPageIsLoaded();
}
