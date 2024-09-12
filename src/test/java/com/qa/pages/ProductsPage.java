package com.qa.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class ProductsPage extends MenuPage {

    @AndroidFindBy (xpath = "//android.widget.TextView[@text='PRODUCTS']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@label=\"PRODUCTS\"]")
    private WebElement textProductsTitle;
    @AndroidFindBy (xpath = "//android.widget.TextView[@content-desc=\"test-Item title\" and @text=\"Sauce Labs Backpack\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"test-Item title\"])[1]")
    private WebElement textBackpackTitle;
    @AndroidFindBy (xpath = "//android.widget.TextView[@content-desc=\"test-Price\" and @text=\"$29.99\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"test-Price\"])[1]")
    private WebElement textBackpackPrice;

    public String getTitle() {
        return getText(textProductsTitle);
    }

    public String getBackpackTitle() {
        return getText(textBackpackTitle);
    }

    public String getBackpackPrice() {
        return getText(textBackpackPrice);
    }

    public ProductDetailsPage pressBackpackProduct() {
        click(textBackpackTitle);
        return new ProductDetailsPage();
    }
}
