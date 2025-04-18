package com.solvd.carina.demo.gui.components.automation;

import com.solvd.carina.demo.gui.pages.automation.WomenDressProductsPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class FilterProductComponent extends AbstractUIObject {

    @FindBy(xpath = ".//a[@href='#Women']")
    private ExtendedWebElement womenLink;

    @FindBy(xpath = ".//a[@href='/category_products/1']")
    private ExtendedWebElement dressLink;

    public FilterProductComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void clickWomenBtn(){
        //wait.until(ExpectedConditions.visibilityOf(womenLink.getElement()));
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", womenLink.getElement());
        womenLink.click();
    }

    public WomenDressProductsPage clickDressCategory(){
        //wait.until(ExpectedConditions.visibilityOf(dressLink.getElement()));
         JavascriptExecutor js= (JavascriptExecutor) driver;
         js.executeScript("arguments[0].click();", dressLink.getElement());
        //dressLink.clickIfPresent();
        return new WomenDressProductsPage(getDriver());
    }


}
