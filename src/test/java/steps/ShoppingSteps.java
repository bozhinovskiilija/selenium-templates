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

        Assert.assertEquals(PageConstants.ProductSuccessfullyAddedLabel,clothes.getModalLabelText());
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

    @And("^The number of product added in the cart is equal to \"([^\"]*)\"$")
    public void checkNumberOfProductAddedInTheCartIsEqualTo(String prodNum) throws Throwable {
        Assert.assertTrue(cart.getCartTab().isDisplayed());
        Assert.assertEquals(prodNum,cart.CheckProductQuantity());
        Thread.sleep(2000);
    }

    @When("^I delete one product from the cart$")
    public void iDeleteOneProductFromTheCart() throws InterruptedException {
        cart.RemoveProductFromCart();
        Thread.sleep(3000);
    }

    @And("^Total price of the product is \"([^\"]*)\"$")
    public void totalPriceOfTheProductIs(String totalPrice) {

        Assert.assertEquals(totalPrice,cart.ChechTotalPrice());
    }

    @When("^The price of the product is \"([^\"]*)\"$")
    public void thePriceOfTheProductIs(String productPrice) {

        Assert.assertEquals(productPrice,cart.CheckProductPrice());
    }

    @And("^Shipping price is \"([^\"]*)\"$")
    public void shippingPriceIs(String expectedShipping) {
        Assert.assertEquals(expectedShipping,cart.CheckShippingPrice());
    }
}
