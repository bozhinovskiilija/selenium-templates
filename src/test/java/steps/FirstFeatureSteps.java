package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.LoginPage;

import java.util.logging.Logger;

public class FirstFeatureSteps {
    private WebDriver driver;
    LoginPage loginPage;



    public FirstFeatureSteps(BaseSteps baseSteps) {

        driver = baseSteps.GetDriver();
        loginPage = new LoginPage(driver);
    }


    @Given("Navigate to the Demo site")
    public void navigateToTheDemoSite() {
        BasePage.GoTo();

    }

    @When("User click the login button")
    public void userClickTheLoginButton() {

        loginPage.ClickLoginButton();
    }

    @When("Insert wrong username and password")
    public void userInsertCorrectUsernameAndPassword() {

        loginPage.InsertCredential();

    }

    @And("Click submit button")
    public void clickSubmitButton() throws InterruptedException {

        loginPage.clickSubmitButton();

    }

    @Then("Error message should be displayed on the screen")
    public void errorMessageShouldBeDisplayedOnTheScreen() {
        loginPage.ErrorMessageIsDisplayed();
    }

}
