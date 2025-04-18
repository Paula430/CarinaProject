package com.solvd.carina.demo.gui.pages.automation;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WomenDressProductsPage extends BasePage {

    @FindBy(xpath="//h2[@class='title text-center']")
    private ExtendedWebElement dressProductsText;

    public WomenDressProductsPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL_AND_ELEMENT);
        setUiLoadedMarker(dressProductsText);
        setPageAbsoluteURL("https://www.automationexercise.com/category_products/1");

    }

    public String getTitle(){
        wait.until(ExpectedConditions.visibilityOf(dressProductsText.getElement()));
        return dressProductsText.getText();
    }

}
