package com.solvd.carina.demo.gui.components.automation;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AddedPopUpComponent extends AbstractUIObject {

    @FindBy(xpath=".//p[text()='Your product has been added to cart.']")
    private ExtendedWebElement successAddToCartMessage;

    public AddedPopUpComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String isSuccessAddToCartMessage(){
        return successAddToCartMessage.getText();
    }
}
