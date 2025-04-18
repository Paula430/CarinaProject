package com.solvd.carina.demo.gui.pages.automation;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AccountInfoPage extends BasePage {

    @FindBy(xpath="//b[contains(text(),'Enter Account Information')]")
    private ExtendedWebElement accountInfoText;

    @FindBy(xpath = "//input[@name='title']")
    private ExtendedWebElement titleCheck;

    @FindBy(xpath="//input[@data-qa='password']")
    private ExtendedWebElement passwordInput;

    @FindBy(xpath="//select[@id='days']")
    private ExtendedWebElement daySelect;

    @FindBy(xpath="//select[@id='months']")
    private ExtendedWebElement monthSelect;

    @FindBy(xpath="//select[@id='years']")
    private ExtendedWebElement yearSelect;

    @FindBy(xpath="//input[@data-qa='first_name']")
    private ExtendedWebElement firstNameInput;

    @FindBy(xpath="//input[@data-qa='last_name']")
    private ExtendedWebElement lastNameInput;

    @FindBy(xpath="//input[@data-qa='address']")
    private ExtendedWebElement addressInput;

    @FindBy(xpath="//select[@id='country']")
    private ExtendedWebElement countrySelect;

    @FindBy(xpath="//input[@data-qa='state']")
    private ExtendedWebElement stateInput;

    @FindBy(xpath="//input[@data-qa='city']")
    private ExtendedWebElement cityInput;

    @FindBy(xpath="//input[@data-qa='zipcode']")
    private ExtendedWebElement zipCodeInput;

    @FindBy(xpath="//input[@data-qa='mobile_number']")
    private ExtendedWebElement mobileNumberInput;

    @FindBy(xpath="//button[@data-qa='create-account']")
    private ExtendedWebElement createAccountBtn;

    @FindBy(xpath = "//b[contains(text(),'Account Created!')]")
    private ExtendedWebElement createdText;

    @FindBy(xpath="")
    private ExtendedWebElement infoText;
    public AccountInfoPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL_AND_ELEMENT);
        setUiLoadedMarker(accountInfoText);
        setPageAbsoluteURL("https://www.automationexercise.com/signup");
    }

    public void fillAccountForm(String password, String day, String month, String year){
        titleCheck.click();
        passwordInput.type(password);
        //Select select= new Select(daySelect.getElement());
        daySelect.select(day);
        monthSelect.select(month);
        yearSelect.select(year);
    }

    public void fillAddressForm( String firstName, String lastName, String address, String country,
                                 String state,String city, String zipCode, String mobileNumber){
        firstNameInput.type(firstName);
        lastNameInput.type(lastName);
        addressInput.type(address);
        countrySelect.select(country);
        stateInput.type(state);
        cityInput.type(city);
        zipCodeInput.type(zipCode);
        mobileNumberInput.type(mobileNumber);
    }

    public void clickSubmit(){
        createAccountBtn.clickIfPresent();
    }

    public boolean checkCreatedAccountMessage(){
        return createdText.isElementPresent();
    }

}
