package steps;

import constants.PageConstants;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.Cart;
import pages.Clothes;
import pages.CreateAccountPage;


public class ShoppingSteps {


    private WebDriver driver;
    Clothes clothes;
    Cart cart;



    public ShoppingSteps(BaseSteps baseSteps) {
        driver = baseSteps.GetDriver();
        clothes = new Clothes(driver);
        cart=new Cart(driver);
    }



    @When("^User click the dresses button$")
    public void userClickTheDressesButton() {
        clothes.ClickOnDressesButton();
    }

    @And("^From the sub-menu choose summer dresses$")
    public void fromTheSubMenuChooseSummerDresses() {
        clothes.ClickOnSummersDressesButton();
    }

    @And("^Choose one of the summer dresses and click add to cart$")
    public void chooseOneOfTheSummerDressesAndClickAddToCart() {
        clothes.moveToProduct(3);
        clothes.addToCardSelectedDress();
    }

    @And("^Modal form for successfully added product is displayed$")
    public void modalFormForSuccessfullyAddedProductIsDisplayed() throws InterruptedException {
        Assert.assertEquals("Product successfully added to your shopping cart",clothes.getModalLabelText());


    }

    @Then("^Click continue shopping button to continue shopping$")
    public void clickContinueShoppingButtonToContinueShopping() {
        clothes.ClickOnContinueShoppingButton();
    }



    @And("^From the sub-menu choose casual dresses$")
    public void fromTheSubMenuChooseCasualDresses() {
        clothes.ClickOnCasualDressesButton();
    }

    @And("^Choose one of the casual dresses and click add to cart$")
    public void chooseOneOfTheCasualDressesAndClickAddToCart() {
        clothes.moveToProduct(1);
        clothes.addToCardSelectedCasualDress();
    }

    @And("^Check number of product added in the cart is equal to \"([^\"]*)\"$")
    public void checkNumberOfProductAddedInTheCartIsEqualTo(String prodNum) throws Throwable {
        Assert.assertTrue(cart.getCartTab().isDisplayed());
        Assert.assertEquals(prodNum,cart.CheckProductQuantity());
        Thread.sleep(6000);
    }


}
