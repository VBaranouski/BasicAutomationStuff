package com.expedia.automation.tests;

import com.expedia.automation.browser.Browser;
import com.expedia.automation.pages.navigation.account.HeaderMenuAccount;
import com.expedia.automation.pages.search.flights.FlightsTab;
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

    private static final String FLYINGFROM = "Minsk, Belarus (MSQ-Minsk Intl.)";
    private static final String FLYINGTO = "New York, NY (NYC-All Airports)";
    private static final String DATEDEPART = "09/25/2017";
    private static final String DATERETURN = "09/30/2017";


    @BeforeTest
    public WebDriver createDriverForTests(){
        driver = createDriver(driver);
        return driver;
    }

    @Test (enabled = true, priority = 1)
    public void openSignInScreen(){
        Browser homePage = new Browser();
        homePage.openExpedia(driver);
        HeaderMenuAccount signIn = new HeaderMenuAccount(driver);
        signIn.openSignInScreen(driver);
    }

    @Test (enabled = true, priority = 2, dependsOnMethods = "openSignInScreen")
    public void loginTo(){
        SignInPage sign = new SignInPage(driver);
        sign.signIn(driver,EMAIL, PASSWORD);
    }


    @Test (priority = 3)
    public void searchFlightCheck(){
        Browser homePage = new Browser();
        homePage.openExpedia(driver);
        FlightsTab flights = new FlightsTab(driver);
        flights.searchFligthWithCar(FLYINGFROM, FLYINGTO, DATEDEPART, DATERETURN, 2);
    }

    @AfterTest
    public void closeAllBrowsers(){
        closeWebBrowser(driver);
    }

}