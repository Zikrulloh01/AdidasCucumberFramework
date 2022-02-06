package com.demoblaze.step_definitions;

import com.demoblaze.adidasPages.CartPage;
import com.demoblaze.adidasPages.ProductPage;
import com.demoblaze.utilities.ConfigurationsReader;
import com.demoblaze.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.concurrent.TimeUnit;

public class PurchaseSteps {

    ProductPage productPage = new ProductPage();


    @Given("User is on the Home Page")
    public void user_is_on_the_home_page() {
        Driver.getDriver().get(ConfigurationsReader.get("url"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @When("User adds an {string} from {string}")
    public void user_adds_an_from(String item, String category) {
        productPage.navigateTo(category,item);
        productPage.addToCart();
        productPage.homeLink.click();
    }


    @When("User navigates to {string} page and Removes {string}")
    public void userNavigatesToPageAndRemoves(String page, String item) {
        productPage.navigateTo(page);
        productPage.deleteItem(item);
    }

    @When("User clicks on placeOrder Button")
    public void userClicksOnPlaceOrderButton() {
        new CartPage().placeOrderButton.click();
    }

    @And("User fills out the form and Clicks purchase button")
    public void userFillsOutTheFormAndClicksPurchaseButton() {
        new CartPage().fillForm();
        new CartPage().purchaseButton.click();
    }

    @Then("Verify expected amount equals actual amount")
    public void verifyExpectedAmountEqualsActualAmount() {
        productPage.verifyPrice(productPage.getExpectedBill(), productPage.getActualPrice());

    }

    @And("Click Ok button")
    public void clickOkButton() {
        new CartPage().okButton.click();
    }
}
