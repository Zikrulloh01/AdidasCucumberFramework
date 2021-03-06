package com.demoblaze.step_definitions;

import com.demoblaze.adidasPages.CartPage;
import com.demoblaze.adidasPages.ProductPage;
import com.demoblaze.utilities.BrowserUtils;
import com.demoblaze.utilities.ConfigurationsReader;
import com.demoblaze.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.List;
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
        BrowserUtils.waitFor(2);
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

        String cheque = Driver.getDriver().findElement(By.xpath("//p[@style='display: block;']")).getText();
        String id = cheque.substring(cheque.indexOf("d:") + 2, cheque.indexOf("Amount"));
        System.out.println(id.trim());
        new CartPage().okButton.click();
    }

    @Then("Under {string} category user should be able to see following products")
    public void underCategoryUserShouldBeAbleToSeeFollowingProducts(String category, List<String> items) {
        productPage.navigateTo(category);
        BrowserUtils.waitFor(1);
        List<String> elementsText = BrowserUtils.getElementsText(productPage.allElements);
        Assert.assertEquals("Elements not Match", items, elementsText);
    }
}
