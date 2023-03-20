package testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import utilities.TestListener;

import java.time.Duration;

@Listeners(TestListener.class)
public class BaseTest {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    public WebDriver getDriver(){
        return driver.get();
    }

    @BeforeClass(alwaysRun = true, description = "Running setup driver")
    @Parameters("browser")
    public void setUp(String browser){
        switch (browser){
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
//                FirefoxOptions options = new FirefoxOptions();
//                options.addArguments("--headless");
//                driver.set(new FirefoxDriver(options));
                driver.set(new FirefoxDriver());
            }
            case "edge" -> {
                WebDriverManager.edgedriver().setup();
//                EdgeOptions options = new EdgeOptions();
//                options.addArguments("--headless");
//                driver.set(new EdgeDriver(options));
                driver.set(new EdgeDriver());
            }
            default -> System.out.println("Browser " + browser + " is not support");
        }
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterClass(alwaysRun = true, description = "Close driver")
    public void tearDown(){
        driver.get().quit();
        driver.remove();
    }
}
