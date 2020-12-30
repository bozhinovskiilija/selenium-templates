package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {


    public static WebElement waitForElementPresence(WebDriver driver, By selector, int waitInterval) {
        WebElement element = (new WebDriverWait(driver, waitInterval)).until(ExpectedConditions.presenceOfElementLocated(selector));
        return element;
    }

    public static WebElement waitToBeClickable(WebDriver driver, By selector, int waitInterval) {
        WebElement element = (new WebDriverWait(driver, waitInterval)).until(ExpectedConditions.elementToBeClickable(selector));
        return element;
    }

    public static boolean isPresent(WebDriver webdriver, By selector) {
        // try to find element by specified selector
        try {
            webdriver.findElement(selector);
        } catch (NoSuchElementException e) {
            // if element not exist return false
            return false;
        }
        return true;
    }


    /**
     * Metod koj ceka da naslovot na stranicata da stane ednakov so naslovot daden kako parametar
     * @param driver
     * @param title - naslovot koj go cekame
     * @param waitInterval - vremeto na cekanje
     */
    public static void waitForTitle(WebDriver driver, String title, int waitInterval){
        (new WebDriverWait(driver, waitInterval)).until(ExpectedConditions.titleIs(title));
    }
}