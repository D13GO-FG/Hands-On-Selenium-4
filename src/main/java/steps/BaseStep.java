package steps;

import org.openqa.selenium.WebDriver;

public class BaseStep {
    private WebDriver driver;

    public WebDriver getDriver(){
        return this.driver;
    }

    public BaseStep(WebDriver driver){
        this.driver = driver;
    }
}
