package com.qa.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class ProductDetailsPage extends MenuPage {

    @AndroidFindBy (xpath = "//android.widget.TextView[@text=\"Sauce Labs Backpack\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"test-Description\"]/child::XCUIElementTypeStaticText[1]")
    private WebElement textProductBackpackTitle;
    @AndroidFindBy (xpath = "//android.widget.TextView[@text=\"carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"test-Description\"]/child::XCUIElementTypeStaticText[2]")
    private WebElement textProductBackpackDescription;

    @AndroidFindBy (accessibility = "test-Price")
    @iOSXCUITFindBy (id = "test-Price")
    private WebElement textProductBackpackPrice;

    @AndroidFindBy (accessibility = "test-BACK TO PRODUCTS")
    @iOSXCUITFindBy (id = "test-BACK TO PRODUCTS")
    private WebElement buttonReturnToProducts;

    public String getBackpackTitle() {
        return getText(textProductBackpackTitle);
    }

    public String getBackpackDescription() {
        return getText(textProductBackpackDescription);
    }

    public String getBackpackPrice() {
        return getText(textProductBackpackPrice);
    }

    public ProductDetailsPage scrollToBackpackPrice() {
        scrollToElement();
        return this;
    }


    public String scrollToBackpackPriceAndGet() {
        return getText(scrollToElement());
    }

    public ProductsPage pressBackToProductsBtn() {
        click(buttonReturnToProducts);
        return new ProductsPage();
    }
}
