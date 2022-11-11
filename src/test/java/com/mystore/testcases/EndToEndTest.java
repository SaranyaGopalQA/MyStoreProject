package com.mystore.testcases;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.*;

import com.mystore.utility.Log;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Properties;

public class EndToEndTest extends BaseClass {
    private IndexPage index;
    private SearchResultPage searchResultPage;
    private AddToCartPage addToCartPage;
    private OrderPage orderPage;
    private LoginPage loginPage;
    private AddressPage addressPage;
    private ShippingPage shippingPage;
    private PaymentPage paymentPage;
    private OrderSummary orderSummary;
    private OrderConfirmationPage orderConfirmationPage;
    public Properties prop;

    @Parameters("browser")
    @BeforeMethod(groups = {"Smoke","Sanity","Regression"})
    public void setup(String browser) {
        launchApp(browser);
    }

    @AfterMethod(groups = {"Smoke","Sanity","Regression"})
    public void tearDown() {
        getDriver().quit();
    }

    @Test(groups = "Regression",dataProvider = "getProduct", dataProviderClass = DataProviders.class)
    public void endToEndTest(String productName, String qty, String size) throws Throwable {
        Log.startTestCase("endToEndTest");
        index= new IndexPage();
        searchResultPage=index.searchProduct(productName);
        addToCartPage=searchResultPage.clickOnProduct();
        addToCartPage.enterQuantity(qty);
        addToCartPage.selectSize(size);
        addToCartPage.clickOnAddToCart();
        orderPage=addToCartPage.clickOnCheckOut();
        loginPage=orderPage.clickOnCheckOut();
        addressPage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"),addressPage);
        shippingPage=addressPage.clickOnCheckOut();
        shippingPage.checkTheTerms();
        paymentPage=shippingPage.clickOnProceedToCheckOut();
        orderSummary=paymentPage.clickOnPaymentMethod();
        orderConfirmationPage=orderSummary.clickOnconfirmOrderBtn();
        String actualMessage=orderConfirmationPage.validateConfirmMessage();
        String expectedMsg="Your order on My Store is complete.";
        Assert.assertEquals(actualMessage, expectedMsg);
        Log.endTestCase("endToEndTest");
    }
}
