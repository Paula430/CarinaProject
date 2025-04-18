package com.solvd.carina.demo.gui.pages.automation;

import com.solvd.carina.demo.gui.components.automation.HeaderComponent;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage extends AbstractPage {

    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));

    @FindBy(xpath="//div[contains(@class,'shop-menu')]")
    private HeaderComponent headerComponent;

    protected BasePage(WebDriver driver) {
        super(driver);
    }

    public HeaderComponent getHeaderComponent(){
        return headerComponent;
    }
}
