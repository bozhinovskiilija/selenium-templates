package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utils;

public class Cart {

    WebDriver driver;
    Actions action;

    public Cart(WebDriver driver) {

        this.driver = driver;
        action = new Actions(driver);
    }

    public WebElement getCartTab() {
        return Utils.waitForElementPresence(driver, By.xpath("//b[contains(text(), \"Cart\")]/.."), 30);
    }

    public WebElement getCartQuantity() {
        return Utils.waitForElementPresence(driver, By.className("ajax_cart_quantity"), 30);
    }

    public String CheckProductQuantity(){
        action.moveToElement(getCartTab()).perform();
        return getCartQuantity().getText();
    }

}
