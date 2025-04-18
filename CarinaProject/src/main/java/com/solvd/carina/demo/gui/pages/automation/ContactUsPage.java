package com.solvd.carina.demo.gui.pages.automation;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.io.File;

public class ContactUsPage extends BasePage{

    @FindBy(xpath="//h2[contains(text(), 'Get In Touch')]")
    private ExtendedWebElement getInTouchText;

    @FindBy(xpath = "//input[@name='name']")
    private ExtendedWebElement nameInput;

    @FindBy(xpath = "//input[@name='email']")
    private ExtendedWebElement emailInput;

    @FindBy(xpath = "//input[@name='subject']")
    private ExtendedWebElement subjectInput;

    @FindBy(xpath = "//textarea[@id='message']")
    private ExtendedWebElement messageTextArea;

    @FindBy(xpath="//input[@type='file']")
    private ExtendedWebElement fileInput;

    @FindBy(xpath="//input[@type='submit']")
    private ExtendedWebElement submitBtn;

    @FindBy(xpath="//div[contains(@class,'status')]")
    private ExtendedWebElement statusText;

    @FindBy(xpath="//span[contains(text(),'Home')]")
    private ExtendedWebElement backToHomeBtn;

    public ContactUsPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL_AND_ELEMENT);
        setUiLoadedMarker(getInTouchText);
        setPageAbsoluteURL("https://www.automationexercise.com/contact_us");
    }

    public boolean checkgetInTouchText(){
        return getInTouchText.isElementPresent();
    }

    public void fillForm(String name, String email, String filePath){
        nameInput.type(name);
        emailInput.type(email);
        subjectInput.type("TestSubject");
        messageTextArea.type("Test message");
        uploadFile(filePath);
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", submitBtn.getElement());

    }

    private void uploadFile(String filePath){
        fileInput.type(new File(filePath).getAbsolutePath());
    }

    public String getStatusSubmit(){
        return statusText.getText();
    }

    public HomePage backToHomeClick(){
        backToHomeBtn.clickIfPresent();
        return new HomePage(getDriver());
    }
}
