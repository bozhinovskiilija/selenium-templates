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

    //find the second dt tag
    public WebElement getCartProductDelete(int numOfElement) {
        return Utils.waitToBeClickable(driver, By.xpath("//dt[" + numOfElement + "]//a[@class=\"ajax_cart_block_remove_link\"]"), 30);
    }

    public WebElement getCartTabTotalPrice() {
        return Utils.waitForElementPresence(driver, By.xpath("//span[@class='price cart_block_total ajax_block_cart_total']"), 30);
    }
    public WebElement getCartTabProductPrice() {
        return Utils.waitForElementPresence(driver, By.xpath("//*[@id='header']//dt[1]/div/span"), 30);
    }

    public WebElement getCartTabShippingPrice() {
        return Utils.waitForElementPresence(driver, By.cssSelector(".price.cart_block_shipping_cost"), 30);
    }

    public String CheckProductQuantity(){
        action.moveToElement(getCartTab()).perform();
        return getCartQuantity().getText();
    }

    public void RemoveProductFromCart(){
        getCartProductDelete(2).click();
    }

    public String ChechTotalPrice(){
        return getCartTabTotalPrice().getText();
    }

    public String CheckProductPrice(){
        return getCartTabProductPrice().getText();
    }

    public String CheckShippingPrice(){
        return getCartTabShippingPrice().getText();
    }



}
