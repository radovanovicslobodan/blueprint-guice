package cucumber_blueprint.core.custompagefactory;

import cucumber_blueprint.core.custompagefactory.annotations.FindByTestId;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.Annotations;
import org.openqa.selenium.support.pagefactory.ElementLocator;

import java.lang.reflect.Field;
import java.util.List;


public class CustomElementLocator implements ElementLocator {

    private final SearchContext searchContext;
    private final FindByTestId testId;
    private final Annotations annotations;

    public CustomElementLocator(final SearchContext searchContext, final Field field) {
        this.searchContext = searchContext;
        if (field.isAnnotationPresent(FindByTestId.class)) {
            this.testId = field.getAnnotation(FindByTestId.class);
            this.annotations = null;
        } else {
            this.testId = null;
            this.annotations = new Annotations(field);
        }
    }

    @Override
    public WebElement findElement() {
        WebElement element;
        if (testId != null) {
            element = searchContext.findElement(By.cssSelector(String.format("[data-test='%s']", testId.value())));
        } else {
            element = searchContext.findElement(annotations.buildBy());
        }
        if (element == null) {
            throw new NoSuchElementException("Unable to locate element with test-id: " + testId.value());
        }
        return element;
    }

    @Override
    public List<WebElement> findElements() {
        List<WebElement> elements;
        if (testId != null) {
            elements = searchContext.findElements(By.cssSelector(String.format("[data-test='%s']", testId.value())));
        } else {
            elements = searchContext.findElements(annotations.buildBy());
        }
        return elements;
    }

    @Override
    public String toString() {
        if (annotations != null) {
            return "Attempting to find element(s): " + annotations.buildBy();
        }
        return "Attempting to find element(s) with test-id: " + testId.value();
    }
}
