package com.solvd.carina.demo;

import com.solvd.carina.demo.gui.components.automation.AddedPopUpComponent;
import com.solvd.carina.demo.gui.components.automation.FilterProductComponent;
import com.solvd.carina.demo.gui.components.automation.HeaderComponent;
import com.solvd.carina.demo.gui.components.automation.ProductComponent;
import com.solvd.carina.demo.gui.pages.automation.*;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.R;
import io.cucumber.core.gherkin.Feature;
import org.openqa.selenium.Alert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * UI testing for webpage "https://www.automationexercise.com/"
 *
 * @author Paula Kawalec
 */


public class AutomationWebTest implements IAbstractTest {
    private HomePage homePage;

    @BeforeMethod
    public void setUp(){
        homePage=new HomePage(getDriver());
        homePage.open();
        homePage.assertPageOpened();//navigate to the page
        homePage.acceptCookies();
    }

    @Test
    public void addToCartTest(){
        List<ProductComponent> productComponents=homePage.getProductComponents();
        for(ProductComponent component: productComponents){
            if(component.getName().equals("Blue Top")){
                component.clickAdd();
            }
        }

        AddedPopUpComponent addedPopUpComponent= homePage.getAddedPopUpComponent();
        assertEquals(addedPopUpComponent.isSuccessAddToCartMessage(),"Your product has been added to cart.");
    }

    @Test
    public void registerPositiveTest(){
        HeaderComponent headerComponent= homePage.getHeaderComponent();
        LoginPage loginPage=headerComponent.clickLoginBtn();
        loginPage.assertPageOpened();
        loginPage.fillRegisterForm(R.TESTDATA.get("userNameRegister"), R.TESTDATA.get("userEmail"));
        AccountInfoPage accountInfoPage=loginPage.clickSignupBtn();
        accountInfoPage.assertPageOpened();
        accountInfoPage.fillAccountForm(R.TESTDATA.get("userPassword"),"1","January","2021");
        accountInfoPage.fillAddressForm("TestFirstName","TestLastName","AddressTest",
                "Canada","StateTest", "CityTest","12-345","123456789");
        accountInfoPage.clickSubmit();
        assertTrue(accountInfoPage.checkCreatedAccountMessage(),"Message created account is not present");
    }

    @Test
    public void registerNegativeTest(){
        HeaderComponent headerComponent= homePage.getHeaderComponent();
        LoginPage loginPage=headerComponent.clickLoginBtn();
        loginPage.assertPageOpened();
        loginPage.fillRegisterForm(R.TESTDATA.get("userNameRegister"), R.TESTDATA.get("userEmail"));
        AccountInfoPage accountInfoPage=loginPage.clickSignupBtn();
        assertTrue(loginPage.checkEmailExistText());

    }

    @Test
    public void loginPositiveTest(){
        HeaderComponent headerComponent= homePage.getHeaderComponent();
        LoginPage loginPage=headerComponent.clickLoginBtn();
        loginPage.assertPageOpened();
        loginPage.fillLoginForm(R.TESTDATA.get("userEmail"), R.TESTDATA.get("userPassword"));
        loginPage.clickLoginBtn();
        assertTrue(headerComponent.checkLogoutBtn(),"Logout button is not present");
    }

    @Test
    public void loginNegativeTest(){
        HeaderComponent headerComponent= homePage.getHeaderComponent();
        LoginPage loginPage=headerComponent.clickLoginBtn();
        loginPage.assertPageOpened();
        loginPage.fillLoginForm(R.TESTDATA.get("userEmailIncorrect"), R.TESTDATA.get("userPassword"));
        loginPage.clickLoginBtn();
        assertTrue(loginPage.checkVisibleIncorrectDataText());
    }

    @Test
    public void logoutTest(){
        HeaderComponent headerComponent= homePage.getHeaderComponent();
        LoginPage loginPage=headerComponent.clickLoginBtn();
        loginPage.assertPageOpened();
        loginPage.fillLoginForm(R.TESTDATA.get("userEmail"), R.TESTDATA.get("userPassword"));
        loginPage.clickLoginBtn();
        assertTrue(headerComponent.checkLogoutBtn(),"Logout button is not present");
        headerComponent.clickLogoutBtn();
        assertTrue(headerComponent.checkLoginBtn());

    }

    @Test
    public void filterProductTest() {
        FilterProductComponent filterProductComponent= homePage.getFilterProductComponent();
        filterProductComponent.clickWomenBtn();
        WomenDressProductsPage womenDressProducts=filterProductComponent.clickDressCategory();
        womenDressProducts.assertPageOpened();
        assertEquals(womenDressProducts.getTitle(),"WOMEN - DRESS PRODUCTS");
        //assertTrue(womenDressProducts.getTitle().contains("WOMEN - DRESS PRODUCTS"));
        System.out.println();
    }

    @Test
    public void contactUsFormTest(){
        HeaderComponent headerComponent= homePage.getHeaderComponent();
        ContactUsPage contactUsPage=headerComponent.clickContactUsBtn();
        assertTrue(contactUsPage.checkgetInTouchText());
        contactUsPage.fillForm(R.TESTDATA.get("userNameRegister"), R.TESTDATA.get("userEmail"), "src/test/resources/images/image.jpg");
        Alert alert = getDriver().switchTo().alert();
        alert.accept();
        assertEquals(contactUsPage.getStatusSubmit(),"Success! Your details have been submitted successfully.");
        HomePage homePage= contactUsPage.backToHomeClick();
        assertEquals(homePage.getHeaderComponent().getColorHomeBtn(),"rgba(255, 165, 0, 1)");

    }

}
