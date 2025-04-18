package com.solvd.carina.demo.gui.pages.automation;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath="//input[@data-qa='signup-name']")
    private ExtendedWebElement nameRegisterInput;

    @FindBy(xpath="//input[@data-qa='signup-email']")
    private ExtendedWebElement emailRegisterInput;

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    private ExtendedWebElement signupBtn;

    @FindBy(xpath="//input[@data-qa='login-email']")
    private ExtendedWebElement loginEmailInput;

    @FindBy(xpath="//input[@data-qa='login-password']")
    private ExtendedWebElement loginPasswordInput;

    @FindBy(xpath="//button[@data-qa='login-button']")
    private ExtendedWebElement loginBtn;

    @FindBy(xpath="//h2[text()='Login to your account']")
    private ExtendedWebElement loginText;

    @FindBy(xpath="//p[contains(text(), 'Your email or password is incorrect')]")
    private ExtendedWebElement incorrectDataText;

    @FindBy(xpath="//p[contains(text(),'Email Address already exist!')]")
    private ExtendedWebElement emailExistText;

    public LoginPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL_AND_ELEMENT);
        setUiLoadedMarker(loginText);
        setPageAbsoluteURL("https://www.automationexercise.com/login");
    }

    public void fillRegisterForm(String name, String email){
        nameRegisterInput.type(name);
        emailRegisterInput.type(email);
    }

    public AccountInfoPage clickSignupBtn(){
        signupBtn.clickIfPresent();
        return new AccountInfoPage(getDriver());
    }

    public void fillLoginForm(String email, String password){
        loginEmailInput.type(email);
        loginPasswordInput.type(password);
    }

    public void clickLoginBtn(){
        loginBtn.clickIfPresent();
    }

    public boolean checkVisibleIncorrectDataText(){
        return incorrectDataText.isElementPresent();
    }

    public boolean checkEmailExistText(){
        return emailExistText.isElementPresent();
    }

}
