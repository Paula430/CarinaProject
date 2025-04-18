package com.solvd.carina.demo.gui.components.automation;

import com.solvd.carina.demo.gui.pages.automation.ContactUsPage;
import com.solvd.carina.demo.gui.pages.automation.LoginPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class HeaderComponent extends AbstractUIObject {


    @FindBy(xpath=".//a[@href='/login']")
    private ExtendedWebElement loginBtn;

    @FindBy(xpath=".//a[@href='/logout']")
    private ExtendedWebElement logoutBtn;

    @FindBy(xpath = ".//a[@href='/contact_us']")
    private ExtendedWebElement contactUsBtn;

    @FindBy(xpath=".//a[@href='/']")
    private ExtendedWebElement homeBtn;

    public HeaderComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public LoginPage clickLoginBtn(){
        loginBtn.clickIfPresent();
        return new LoginPage(getDriver());
    }

    public boolean checkLoginBtn(){
        return loginBtn.isElementPresent();
    }

    public boolean checkLogoutBtn(){
       return logoutBtn.isElementPresent();
    }

    public void clickLogoutBtn(){
        logoutBtn.clickIfPresent();
    }

    public ContactUsPage clickContactUsBtn(){
        contactUsBtn.clickIfPresent();
        return new ContactUsPage(getDriver());
    }

    public String getColorHomeBtn(){
        return homeBtn.getElement().getCssValue("color");
    }

}
