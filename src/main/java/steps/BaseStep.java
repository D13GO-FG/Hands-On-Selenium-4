package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseStep {
    private WebDriver driver;
    public static final int SMALL_WAIT = 10;
    public static final int MED_WAIT = 30;

    public WebDriver getDriver(){
        return this.driver;
    }

    public BaseStep(WebDriver driver){
        this.driver = driver;
    }

    protected WebDriverWait waitOn(WebDriver driver, int second){
        return new WebDriverWait(driver, Duration.ofSeconds(second));
    }

    protected WebElement waitForDisplayed(WebElement element, int second){
        return waitOn(driver, second).until(ExpectedConditions.visibilityOf(element));
    }

    public void type(WebElement element, String text){
        waitForDisplayed(element, SMALL_WAIT);
        element.clear();
        element.sendKeys(text);
    }

    public void click(WebElement element){
        waitForDisplayed(element, SMALL_WAIT).click();
    }
}
