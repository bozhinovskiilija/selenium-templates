package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.CreateAccountPage;

public class CreateAccountSteps {


    private WebDriver driver;
    CreateAccountPage createAccountPage;

    // static Logger logger = Logger.getLogger(LoginSteps.class);

    public CreateAccountSteps(BaseSteps baseSteps) {
        driver = baseSteps.GetDriver();
        createAccountPage = new CreateAccountPage(driver);
    }



    @And("Insert email address")
    public void insertEmailAddress() throws InterruptedException { createAccountPage.InsertRegistrationEmail(); }

    @And("Click on create an account button")
    public void clickOnCreateAnAccountButton() { createAccountPage.ClickOnCreateAccountButton(); }

    @And("Choose title")
    public void chooseTitle() {
        createAccountPage.SelectTitle();
    }

    @And("Insert first name")
    public void insertFirstName() {
        createAccountPage.InsertFirstName();
    }

    @And("Insert last name")
    public void insertLastName() { createAccountPage.InsertLastName(); }

    @And("Insert password")
    public void insertPassword() {
        createAccountPage.InsertPassword();
    }

    @And("^Choose \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" date of birth$")
    public void chooseDateOfBirth(String day, String month, String year) throws Throwable {

        createAccountPage.SelectDayOfBirth(day);
        createAccountPage.SelectMonthOfBirth(month);
        createAccountPage.SelectYearOfBirth(year);
    }

    @And("Sign up for a news paper")
    public void signUpForANewsPaper() throws InterruptedException {
        createAccountPage.ChooseNewsLetter();
    }


    @And("Insert company")
    public void insertCompany() {
        createAccountPage.InsertCompanyName();
    }

    @And("Insert address")
    public void insertCompanyAddress() {
        createAccountPage.InsertCompanyFirstAddress();
    }

    @And("Insert second address")
    public void insertSecondAddress() {
        createAccountPage.InsertCompanySecondAddress();
    }

    @And("Insert city")
    public void insertCity() {
        createAccountPage.InsertCity();
    }

    @And("Choose state")
    public void chooseState() {
        createAccountPage.SelectState();
    }

    @And("Insert zip code")
    public void insertZipCode() {
        createAccountPage.InsertZipCode();
    }

    @And("Choose country")
    public void chooseCountry() {
        createAccountPage.SelectCountry();
    }

    @And("Insert additional information")
    public void insertAdditionalInformation() { createAccountPage.InsertAdditionalInformation(); }

    @And("Insert home phone")
    public void insertHomePhone() {
        createAccountPage.InsertHomePhone();
    }

    @And("Insert mobile phone")
    public void insertMobilePhone() {
        createAccountPage.InsertMobilePhone();
    }

    @And("Insert alias address")
    public void insertAliasAddress() {
        createAccountPage.InsertAliasAddress();
    }

    @And("Click on register button")
    public void clickOnRegisterButton() { createAccountPage.ClickOnRegisterButton(); }

    @Then("Welcome message should be displayed")
    public void nameOfTheCustomerShouldBeDisplayed() { createAccountPage.WelcomeMessageIsDisplayed(); }


    @And("^Logout from your account$")
    public void logoutFromYourAccount() {
        createAccountPage.ClickOnLogoutButton();
    }
}

