package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import static constants.PageConstants.baseUrl;

public class BasePage {

    public static WebDriver driver;


    protected BasePage(WebDriver driver)
    {
        this.driver = driver;
    }

    public static void GoTo()
    {
        driver.navigate().to(baseUrl);
    }

    public boolean IsLoaded(String expected)
    {
        try
        {
            return driver.getTitle().contains(expected);
        }
        catch (NoSuchElementException ex)
        {
            return false;
        }
    }
}
