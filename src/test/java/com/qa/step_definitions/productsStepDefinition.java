package com.qa.step_definitions;

import io.cucumber.java.en.*;

public class productsStepDefinition {
    @Given("User should be logged in")
    public void userShouldBeLoggedIn() {

    }
    @When("Click product title {string}")
    public void clickProductTitle(String title) {

    }

    @Then("Products Page opens with title {string} and price {string}")
    public void productsPageOpensWithTitleAndPrice(String title, String price) {

    }

    @Then("Product Details Page opens with title {string}, price {string} and description {string}")
    public void productDetailsPageOpensWithTitlePriceAndDescription(String title, String price, String description) {

    }
}
