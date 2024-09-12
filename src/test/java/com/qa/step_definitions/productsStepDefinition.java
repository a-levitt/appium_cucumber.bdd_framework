package com.qa.step_definitions;

import com.qa.pages.LoginPage;
import com.qa.pages.ProductDetailsPage;
import com.qa.pages.ProductsPage;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class productsStepDefinition {
    @Given("User should be logged in")
    public void userShouldBeLoggedIn() {
        new LoginPage().logIn("standard_user", "secret_sauce");
    }
    @When("Click product title {string}")
    public void clickProductTitle(String title) {
        new ProductsPage().pressBackpackProduct();
    }

    @Then("Products Page opens with title {string} and price {string}")
    public void productsPageOpensWithTitleAndPrice(String title, String price) {
        Boolean checkTitle = new ProductsPage().getBackpackTitle().equalsIgnoreCase(title);
        Boolean checkPrice = new ProductsPage().getBackpackPrice().equalsIgnoreCase(price);
        Assert.assertTrue("title check = " + checkTitle + ", price check = " + checkPrice, checkTitle & checkPrice);
    }

    @Then("Product Details Page opens with title {string}, price {string} and description {string}")
    public void productDetailsPageOpensWithTitlePriceAndDescription(String title, String price, String description) {
        ProductDetailsPage productDetailsPage = new ProductDetailsPage();
        boolean titleCheck = productDetailsPage.getBackpackTitle().equalsIgnoreCase(title);
        boolean priceCheck = productDetailsPage.getBackpackPrice().equalsIgnoreCase(price);
        boolean descriptionCheck = productDetailsPage.getBackpackDescription().equalsIgnoreCase(description);
        Assert.assertTrue("title check = " + titleCheck + ", price check = " + priceCheck + ", description check = " + descriptionCheck,
                titleCheck & priceCheck & descriptionCheck);
    }
}
