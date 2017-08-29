package com.expedia.automation.tests;
import com.expedia.automation.constants.Constants;
import com.expedia.automation.pages.homepage.HomePage;
import com.expedia.automation.pages.navigation.account.HeaderMenuAccount;
import com.expedia.automation.pages.search.flights.FlightsTab;
import com.expedia.automation.pages.signin.SignInPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Testing extends BaseTest {


    @Test (enabled = true, priority = 1, groups = { "full" })
    public void openSignInScreen(){
        HomePage homePage = new HomePage(driver);
        homePage.openExpedia(driver);
        HeaderMenuAccount signIn = new HeaderMenuAccount(driver);
        signIn.openSignInScreen(driver);
        FlightsTab flights = new FlightsTab(driver);

    }


    @Test (enabled = true, priority = 1, dependsOnMethods = "openSignInScreen", groups = { "full" })
    public void loginTo(){
        SignInPage sign = new SignInPage(driver);
        sign.signIn(driver, Constants.EMAIL, Constants.PASSWORD);
    }

    @Test (enabled = true, priority = 4, groups = { "full" })
    public void searchFlightCheck(){
        HomePage homePage = new HomePage(driver);
        homePage.openExpedia(driver);
        FlightsTab flights = new FlightsTab(driver);
        flights.searchFligthWithCar(Constants.FLYINGFROM, Constants.FLYINGTO, Constants.DATEDEPART, Constants.DATERETURN, 2);
        Assert.assertEquals(flights.getSearchResult(), Constants.RESULTPAGETITLE);
    }




    @Factory (dataProvider = "adultsAndDestProvider")
    public Testing(int adults, String flt) {
        this.adultsCount = adults;
        this.flightDestination = flt;

    }

    @DataProvider
    static public Object[][] adultsAndDestProvider(){
        return new Object[][] {{3, "New York, NY (NYC-All Airports)"}};
    }

    @Test (enabled = true, priority = 3, groups = { "smoke","full" })
    public void searchFlightCheckViaProvider() {
        HomePage homePage = new HomePage(driver);
        homePage.openExpedia(driver);
        FlightsTab flights = new FlightsTab(driver);
        flights.searchFligthWithCar(Constants.FLYINGFROM, flightDestination, Constants.DATEDEPART, Constants.DATERETURN, adultsCount);
        Assert.assertEquals(flights.getSearchResult(), Constants.RESULTPAGETITLE);
    }


    @Parameters ({"AdultsCount"})
    @Test (enabled = false, priority = 4, groups = { "full" })
    public void paramFlightCheckk(int AdultsCount){
        HomePage homePage = new HomePage(driver);
        homePage.openExpedia(driver);
        FlightsTab flights = new FlightsTab(driver);
        flights.searchFligthWithCar(Constants.FLYINGFROM, Constants.FLYINGTO, Constants.DATEDEPART, Constants.DATERETURN, AdultsCount);
        Assert.assertEquals(flights.getSearchResult(), Constants.RESULTPAGETITLE);
    }
}