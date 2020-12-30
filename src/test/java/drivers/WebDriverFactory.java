package drivers;

import enums.BrowserType;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.URL;

public class WebDriverFactory implements IDriver {

    private static final String CHROMEDRIVER_EXE = "drivers/chromedriver.exe";
    private static final String FIREFOX_EXE = "drivers/geckodriver.exe";



    public WebDriver Initialize(BrowserType browserType){

        switch(browserType){
            case Chrome:
                return
                        getChromeDriver(CHROMEDRIVER_EXE);
            case Chrome_Headless:
                return
                        getChromeDriverHeadless(CHROMEDRIVER_EXE);
            case Firefox:
                getFirefoxDriver(FIREFOX_EXE);

            default:
                throw new IndexOutOfBoundsException("no such browser");
        }

    }

    private String findFile(String driverFile) {
        ClassLoader classLoader = getClass().getClassLoader();
        URL url = classLoader.getResource(driverFile);
        return url.getFile();
    }

    public WebDriver getChromeDriver(String driver) {

        String driverFile = findFile(driver);
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();

        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File(driverFile))
                .build();

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--no-sandbox"); // Bypass OS security model, MUST BE THE VERY FIRST OPTION
        //options.addArguments("--headless");
        options.setExperimentalOption("useAutomationExtension", false);
        options.addArguments("incognito");
        options.addArguments("start-maximized"); // open Browser in maximized mode
        options.addArguments("disable-infobars"); // disabling infobars
        options.addArguments("--disable-extensions"); // disabling extensions
        options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        options.merge(capabilities);

        return new ChromeDriver(service, options);
    }

    public WebDriver getChromeDriverHeadless(String driver) {

        String driverFile = findFile(driver);
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();

        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File(driverFile))
                .build();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("start-maximized"); // open Browser in maximized mode
        options.addArguments("disable-infobars"); // disabling infobars
        options.addArguments("--disable-extensions"); // disabling extensions
        options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        options.merge(capabilities);

        return new ChromeDriver(service, options);
    }

    public WebDriver getFirefoxDriver(String driver) {

        String driverFile = findFile(driver);
        System.setProperty("webdriver.gecko.driver", driverFile);
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();

        return new FirefoxDriver();
    }

    public static void waitForLoad(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(pageLoadCondition);
    }

}
