package pages;

import constants.UserConstants;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import steps.BaseSteps;
import utilities.Utils;

import static drivers.WebDriverFactory.waitForLoad;

public class CreateAccountPage {

    WebDriver driver;

    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
    }


    public WebElement getInputEmail() {
        return Utils.waitForElementPresence(driver, By.id("email_create"), 5);
    }

    public WebElement getCreateAccountButton() {
        return Utils.waitForElementPresence(driver, By.id("SubmitCreate"), 5);
    }


    /*wait for the whole form to be present on the page*/
    public WebElement getAccountCreationForm() {
        return Utils.waitForElementPresence(driver, By.id("account-creation_form"), 10);
    }


    public WebElement getCustomerTitleMr() {
        return Utils.waitToBeClickable(driver, By.id("id_gender1"), 5);
    }

    public WebElement getCustomerTitleMrs() {
        return Utils.waitToBeClickable(driver, By.id("uid_gender2"), 5);
    }

    public WebElement getCustomerFirstNameField() {
        return Utils.waitForElementPresence(driver, By.id("customer_firstname"), 2);
    }

    public WebElement getCustomerLastNameField() {
        return Utils.waitForElementPresence(driver, By.id("customer_lastname"), 2);
    }

    public WebElement getCustomerEmailField() {
        return Utils.waitForElementPresence(driver, By.id("email"), 2);
    }

    public WebElement getCustomerPasswordField() {
        return Utils.waitForElementPresence(driver, By.id("passwd"), 2);
    }


    public Select selectCustomerDateOfBirthDay() {
        WebElement dayOfBirth = Utils.waitForElementPresence(driver, By.id("days"), 5);
        return new Select(dayOfBirth);
    }


    public Select selectCustomerDateOfBirthMonth() {
        WebElement monthOfBirth = Utils.waitForElementPresence(driver, By.id("months"), 30);
        return new Select(monthOfBirth);
    }

    public Select selectCustomerDateOfBirthYear() {
        WebElement yearOfBirth = Utils.waitForElementPresence(driver, By.id("years"), 30);
        return new Select(yearOfBirth);
    }

    public WebElement getNewsLetterCheckBox() {
        return Utils.waitForElementPresence(driver, By.id("newsletter"), 2);
    }


    public WebElement getCompanyField() {
        return Utils.waitForElementPresence(driver, By.id("company"), 30);
    }

    public WebElement getAddressField() {
        return Utils.waitForElementPresence(driver, By.id("address1"), 30);
    }

    public WebElement getAddressFieldTwo() {
        return Utils.waitForElementPresence(driver, By.name("address2"), 30);
    }

    public WebElement getCity() {
        return Utils.waitForElementPresence(driver, By.id("city"), 3);
    }

    public Select selectCountry() {
        WebElement country = Utils.waitForElementPresence(driver, By.id("id_country"), 30);
        return new Select(country);
    }

    public Select selectState() {
        WebElement state = Utils.waitForElementPresence(driver, By.id("id_state"), 30);
        return new Select(state);
    }

    public WebElement getPostalCodeField() {
        return Utils.waitForElementPresence(driver, By.id("postcode"), 30);
    }

    public WebElement getAdditionalInformationField() {
        return Utils.waitForElementPresence(driver, By.id("other"), 30);
    }

    public WebElement getHomePhoneField() {
        return Utils.waitForElementPresence(driver, By.id("phone"), 30);
    }

    public WebElement getMobilePhoneField() {
        return Utils.waitForElementPresence(driver, By.id("phone_mobile"), 30);
    }

    public WebElement getAddressAliasField() {
        return Utils.waitForElementPresence(driver, By.id("alias"), 30);
    }

    public WebElement getRegisterBtn() {
        return Utils.waitToBeClickable(driver, By.id("submitAccount"), 30);
    }

    public WebElement getRegisteredCustomerName() {
        return Utils.waitToBeClickable(driver, By.className("account"), 3);
    }

    public WebElement successfullyCreatedAccount() {
        return Utils.waitForElementPresence(driver, By.className("info-account"), 5);
    }

    public WebElement getLogoutBtn() {
        return Utils.waitToBeClickable(driver, By.className("logout"), 30);
    }




    /*Element interaction*/


    public void InsertRegistrationEmail() throws InterruptedException {

        waitForLoad(BaseSteps.driver);
        getInputEmail().clear();
        getInputEmail().sendKeys(UserConstants.Email);

    }

    public void ClickOnCreateAccountButton() {
        getCreateAccountButton().click();
    }

    public void SelectTitle() {

        getCustomerTitleMr().click();

    }

    public void InsertFirstName() {
        getCustomerFirstNameField().sendKeys(UserConstants.FirstName);
    }


    public void InsertLastName() {
        getCustomerLastNameField().sendKeys(UserConstants.LastName);
    }

    public void InsertPassword() {
        getCustomerPasswordField().sendKeys(UserConstants.AccountPassword);
    }

    public void SelectDayOfBirth(String day) {
        Select dayOfBirth = this.selectCustomerDateOfBirthDay();
        dayOfBirth.selectByValue(day);
    }

    public void SelectMonthOfBirth(String month) {
        Select monthOfBirth = this.selectCustomerDateOfBirthMonth();
        monthOfBirth.selectByValue(month);
    }

    public void SelectYearOfBirth(String year) {
        Select yearOfBirth = this.selectCustomerDateOfBirthYear();
        yearOfBirth.selectByValue(year);
    }

    public void ChooseNewsLetter() {
        getNewsLetterCheckBox().click();
    }

    public void InsertCompanyName() {
        getCompanyField().sendKeys(UserConstants.CompanyName);
    }

    public void InsertCompanyFirstAddress() {
        getAddressField().sendKeys(UserConstants.FirstAddress);
    }

    public void InsertCompanySecondAddress() {
        getAddressField().sendKeys(UserConstants.SecondAddress);
    }

    public void InsertCity() {
        getCity().sendKeys(UserConstants.CityName);
    }

    public void SelectState() {

        Select stateName = this.selectState();
        stateName.selectByValue("5");

    }

    public void InsertZipCode() {
        getPostalCodeField().sendKeys(UserConstants.PostalCode);
    }

    public void SelectCountry() {
        Select countryName = this.selectCountry();
        countryName.selectByValue("21");
    }

    public void InsertAdditionalInformation() {
        getAdditionalInformationField().sendKeys(UserConstants.AdditionalInformation);
    }

    public void InsertHomePhone() {
        getHomePhoneField().sendKeys(UserConstants.HomePhone);
    }

    public void InsertMobilePhone() {
        getMobilePhoneField().sendKeys(UserConstants.MobilePhone);
    }

    public void InsertAliasAddress() {
        getAddressAliasField().sendKeys(UserConstants.AliasAddress);
    }

    public void ClickOnRegisterButton() {
        getRegisterBtn().click();
    }

    public void WelcomeMessageIsDisplayed() {
        String message = successfullyCreatedAccount().getText();
        Assert.assertEquals(UserConstants.WelcomeMessage, message);
    }

    public void ClickOnLogoutButton() {
        getLogoutBtn().click();
    }
}