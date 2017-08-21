package com.expedia.automation.tests;

import com.expedia.automation.browser.Browser;
import com.expedia.automation.pages.navigation.account.HeaderMenuAccount;
import com.expedia.automation.pages.signin.SignInPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.expedia.automation.browser.Browser.closeWebBrowser;
import static com.expedia.automation.browser.Browser.createDriver;


public class Testing {
    WebDriver driver;

    private static final String EMAIL = "vladislav.baranovski1@gmail.com";
    private static final String PASSWORD = "barvadya18";




    @BeforeTest
    public WebDriver createDriverForTests(){
        driver = createDriver(driver);
        return driver;
    }

    @Test (priority = 1)
    public void openHomePage(){
       Browser homePage = new Browser();
       homePage.openExpedia(driver);
    }

    @Test (priority = 2)
    public void openSignInScreen(){
        HeaderMenuAccount signIn = new HeaderMenuAccount(driver);
        signIn.openSignInScreen(driver);
    }

    @Test (priority = 3)
    public void loginTo(){
        SignInPage sign = new SignInPage(driver);
        sign.signIn(driver,EMAIL, PASSWORD);
    }

    @AfterTest
    public void closeAllBrowsers(){
        closeWebBrowser(driver);
    }

}
