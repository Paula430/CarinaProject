package com.solvd.carina.demo.gui.components.automation;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductComponent extends AbstractUIObject {

    @FindBy(xpath=".//a[@class='btn btn-default add-to-cart']")
    private ExtendedWebElement addToCartButton;

    @FindBy(xpath=".//p")
    private ExtendedWebElement name;

    public ProductComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void clickAdd(){
        //addToCartButton.click();
        //addToCartButton.clickIfPresent();
        JavascriptExecutor executor=(JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", addToCartButton.getElement());
    }

    public String getName(){
        return name.getText();
    }

}
