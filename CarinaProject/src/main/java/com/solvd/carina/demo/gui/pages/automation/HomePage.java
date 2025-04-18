package com.solvd.carina.demo.gui.pages.automation;

import com.solvd.carina.demo.gui.components.automation.AddedPopUpComponent;
import com.solvd.carina.demo.gui.components.automation.FilterProductComponent;
import com.solvd.carina.demo.gui.components.automation.ProductComponent;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.checkerframework.framework.qual.QualifierForLiterals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(xpath="//*[@class='product-image-wrapper']")
    private List<ProductComponent> productComponents;

    @FindBy(xpath="//div[@class='modal-content']")
    private AddedPopUpComponent addedPopUpComponent;

    @FindBy(xpath = "//button[contains(@class,'fc-cta-consent')]")
    private ExtendedWebElement acceptCookiesBtn;

    @FindBy(xpath="//div[@class='left-sidebar']")
    private FilterProductComponent filterProductComponent;

    @FindBy(xpath="//h2[contains(text(),'Features Items')]")
    private ExtendedWebElement featuresItemText;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL_AND_ELEMENT);
        setUiLoadedMarker(featuresItemText);
        setPageAbsoluteURL("https://www.automationexercise.com/");
    }

    public ProductComponent getProductComponent(int index){
        return productComponents.get(index);
    }

    public List<ProductComponent> getProductComponents(){
        return productComponents;
    }

    public AddedPopUpComponent getAddedPopUpComponent(){
        return addedPopUpComponent;
    }

    public void acceptCookies(){
        acceptCookiesBtn.clickIfPresent();
    }

    public FilterProductComponent getFilterProductComponent(){
        return filterProductComponent;
    }



}
