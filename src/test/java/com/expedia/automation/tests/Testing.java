package com.expedia.automation.tests;

import com.expedia.automation.constants.Constants;
import com.expedia.automation.pages.homepage.HomePage;
import com.expedia.automation.pages.navigation.account.HeaderMenuAccount;
import com.expedia.automation.pages.search.flights.FlightsTab;
import com.expedia.automation.pages.signin.SignInPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Testing extends BaseTest {


    @Test (groups = { "full" })
    public void openSignInScreen(){
        HomePage homePage = new HomePage(driver);
        homePage.openExpedia(driver);
        HeaderMenuAccount signIn = new HeaderMenuAccount(driver);
        signIn.openSignInScreen(driver);
    }


    @Test (priority = 1, dependsOnMethods = "openSignInScreen", groups = { "full" })
    public void loginTo(){
        SignInPage sign = new SignInPage(driver);
        sign.signIn(driver, Constants.EMAIL, Constants.PASSWORD);
    }



    @Test (groups = { "smoke","full" })
    public void searchFlightCheckViaDataProvider(int adults, String flightDest, String city) {
        HomePage homePage = new HomePage(driver);
        homePage.openExpedia(driver);
        FlightsTab flights = new FlightsTab(driver);
        flights.searchFligthWithCar(Constants.FLYINGFROM, flightDest, Constants.DATEDEPART, Constants.DATERETURN, adults);
        Assert.assertEquals(flights.getSearchResult(), Constants.RESULTPAGETITLE + " " + city);
    }


    @Parameters({"adults"})
    @Test (groups = { "full" })
    public void paramFlightCheck(int adults){
        HomePage homePage = new HomePage(driver);
        homePage.openExpedia(driver);
        FlightsTab flights = new FlightsTab(driver);
        flights.searchFligthWithCar(Constants.FLYINGFROM, Constants.FLYINGTO, Constants.DATEDEPART, Constants.DATERETURN, adults);
        Assert.assertEquals(flights.getSearchResult(), Constants.RESULTPAGETITLE + " New York" );
    }

}