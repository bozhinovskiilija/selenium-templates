package pages;

import constants.ErrorConstants;
import constants.UserConstants;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import steps.BaseSteps;
import utilities.Utils;

import static drivers.WebDriverFactory.waitForLoad;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {

        this.driver = driver;
    }


    public WebElement getInputEmail() {
        return driver.findElement(By.id("email"));
    }

    public WebElement getInputPassword() {
        return driver.findElement(By.id("passwd"));
    }

    public WebElement getLoginButton() {
        return driver.findElement(By.className("login"));
    }

    public WebElement getErrorMessage() {
        return Utils.waitForElementPresence(driver, By.cssSelector(".alert.alert-danger > ol > li"), 5);
    }


    public void ClickLoginButton() {

        waitForLoad(driver);
        getLoginButton().click();
    }

    public void InsertCredential() {

        waitForLoad(BaseSteps.driver);

        getInputEmail().clear();
        getInputEmail().sendKeys(UserConstants.Email);

        getInputPassword().clear();
        getInputPassword().sendKeys(UserConstants.Password);
    }

    public void clickSubmitButton() throws InterruptedException {

        WebElement submitButton = driver.findElement(By.id("SubmitLogin"));
        submitButton.click();
    }

    public void ErrorMessageIsDisplayed() {

        String actualError = getErrorMessage().getText();
        Assert.assertEquals(ErrorConstants.LogInPageError, actualError);

    }
}