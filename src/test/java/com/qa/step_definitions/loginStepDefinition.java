package com.qa.step_definitions;

import com.qa.pages.LoginPage;
import com.qa.pages.ProductsPage;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class loginStepDefinition {
    @When("Enter username as {string}")
    public void enterUsernameAs(String username) {
        new LoginPage().enterUsername(username);
    }
    @When("Enter password as {string}")
    public void enterPasswordAs(String password) {
        new LoginPage().enterPassword(password);
    }
    @When("Press login button")
    public void pressLoginButton() {
        new LoginPage().pressLogin();
    }
    @Then("Login fails with error {string}")
    public void loginFailsWithError(String err) {
        Assert.assertEquals(new LoginPage().getErrorText(), err);
    }

    @Then("Products Page opens with title {string}")
    public void productsPageOpensWithTitle(String title) {
        Assert.assertEquals(new ProductsPage().getTitle(), title);
    }
}
