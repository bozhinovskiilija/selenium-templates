package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import drivers.WebDriverFactory;
import enums.BrowserType;
import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;

import static constants.PageConstants.baseUrl;

public class BaseSteps {

    public static WebDriver driver;

    public static WebDriver getDriver() { return driver; }

    WebDriverFactory driverFactory = new WebDriverFactory();


    /*Before hooks run before the first step of each scenario.*/
    @Before
    public void SetUpBeforeEachTest() {
        GetDriver();
        driver.get(baseUrl);
    }

    //After hooks run after the last step of each scenario.
//    @After
//    public void SetUpAfterEachScenario() {
//        GetDriver().quit();
//    }

    public WebDriver GetDriver() {

        if (driver == null) {
            driver = driverFactory.Initialize(BrowserType.Chrome);
        }
        return driver;
    }
}