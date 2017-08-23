package com.expedia.automation.tests;
import com.expedia.automation.Listener.SuiteListener;
import com.expedia.automation.Listener.TestListener;
import com.expedia.automation.pages.homepage.HomePage;
import com.expedia.automation.pages.navigation.account.HeaderMenuAccount;
import com.expedia.automation.pages.search.flights.FlightsTab;
import com.expedia.automation.pages.signin.SignInPage;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({TestListener.class, SuiteListener.class})

public class Testing extends BaseTest {


    @Test (priority = 1, groups = { "full" })
    public void openSignInScreen(){
        HomePage homePage = new HomePage(driver);
        homePage.openExpedia(driver);
        HeaderMenuAccount signIn = new HeaderMenuAccount(driver);
        signIn.openSignInScreen(driver);
    }


    @Test (dependsOnMethods = "openSignInScreen", groups = { "full" })
    public void loginTo(){
        SignInPage sign = new SignInPage(driver);
        sign.signIn(driver,EMAIL, PASSWORD);
    }


    @Test (priority = 3, groups = { "smoke","full" })
    public void searchFlightCheck(){
        HomePage homePage = new HomePage(driver);
        homePage.openExpedia(driver);
        FlightsTab flights = new FlightsTab(driver);
        flights.searchFligthWithCar(FLYINGFROM, FLYINGTO, DATEDEPART, DATERETURN, 2);
        Assert.assertEquals(flights.getSearchResult(), RESULTPAGETITLE);
    }


}