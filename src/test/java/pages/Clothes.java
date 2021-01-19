package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utils;


public class Clothes {

    WebDriver driver;
    Actions action;

    public Clothes(WebDriver driver) {

        this.driver = driver;
        action = new Actions(driver);
    }

    /* ELEMENT LOCATORS */
    public WebElement getDressesButton(){ return Utils.waitToBeClickable(driver, By.xpath("//*[@id='block_top_menu']/ul/li[2]"),20); }

    public WebElement getSummerDressesButton(){ return Utils.waitToBeClickable(driver, By.xpath("//*[@id='categories_block_left']/div/ul/li[3]"),20); }

    public WebElement getSummerDressesProduct(int dressNumber){ return Utils.waitForElementPresence(driver, By.xpath("//*[@id='center_column']/ul/li["+dressNumber+"]"),20); }

    public WebElement getAddToCardButton(){ return Utils.waitToBeClickable(driver, By.xpath("//*[@id=\"center_column\"]/ul/li[3]/div/div[2]/div[2]/a[1]"),20); }
    public WebElement getAddToCardButtonCasual(){ return Utils.waitToBeClickable(driver, By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[1]"),20); }

    public WebElement getContinueShoppingButton(){ return Utils.waitToBeClickable(driver, By.className("continue"),20); }

    public WebElement getCasualDressesButton(){ return Utils.waitToBeClickable(driver, By.xpath("//*[@id='categories_block_left']/div/ul/li[1]"),20); }

    /* ELEMENT MANIPULATION */

    public void ClickOnDressesButton() { getDressesButton().click(); }
    public void ClickOnSummersDressesButton() { getSummerDressesButton().click(); }
    //you must first hover the product in order add to card button to be displayed
    public void moveToProduct(int number){ action.moveToElement(getSummerDressesProduct(number)).perform(); }
    public void addToCardSelectedDress(){ getAddToCardButton().click(); }
    public void ClickOnContinueShoppingButton(){ getContinueShoppingButton().click(); }

    //label text can not be located before executing add to card
    public String getModalLabelText() throws InterruptedException {
        Thread.sleep(2000);
        WebElement getProductAddedLabel = Utils.waitForElementPresence(driver, By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[1]/h2"),30);
         return getProductAddedLabel.getText();
    }

    public void ClickOnCasualDressesButton() { getCasualDressesButton().click(); }


    public void addToCardSelectedCasualDress(){ getAddToCardButtonCasual().click(); }


}
