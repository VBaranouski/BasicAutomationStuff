package com.expedia.automation.tests;

import com.expedia.automation.constants.Constants;
import com.expedia.automation.constants.DataProviderManager;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


@Retention(RetentionPolicy.RUNTIME)
@interface ExpediaCheck{
    String str() default "Running Expedia tests";
}


public class Testing extends BaseTest {


    @ExpediaCheck (str = "test annotation")
    @Test (groups = { "full" })
    public void openSignInScreen(){
        homePage.openExpedia(driver);
        headerMenuAccount.openSignInScreen();
        Assert.assertEquals(headerMenuAccount.pageTitle.getText(), Constants.SIGNIN_PAGE_TITLE);
    }


    @Test (priority = 2, dependsOnMethods = "openSignInScreen", groups = { "full" })
    public void loginTo(){
        homePage.openExpedia(driver);
        headerMenuAccount.openSignInScreen();
        Assert.assertEquals(headerMenuAccount.pageTitle.getText(), Constants.SIGNIN_PAGE_TITLE);
        signInPage.signIn(Constants.EMAIL, Constants.PASSWORD);
        myAccountPage.openMyAccountPage();
        Assert.assertEquals(myAccountPage.userNameLink.getText(), Constants.USER_NAME);
    }

    @Test (groups = { "smoke","full" }, dataProvider = "searchFlightInfoProvider", dataProviderClass = DataProviderManager.class)
    public void flightSearchViaDataProvider(String flightFrom, String flightDest, String dateDepart, String dateReturn, int adults, String cityDestination) {
        //BaseTest.showCustomAnnotation();
        homePage.openExpedia(driver);
        flightsTab.searchFlighthWithCar(flightFrom, flightDest, dateDepart, dateReturn, adults, false);
        Assert.assertEquals(flightsTab.titleText.getText(), Constants.RESULT_PAGE_TITLE + " " + cityDestination);
    }


    @Parameters({"adults", "city"})
    @Test (groups = { "full" })
    public void flightSearchViaParameters(int adults, String cityDestination){
        homePage.openExpedia(driver);
        flightsTab.searchFlighthWithCar(Constants.FLYING_FROM, Constants.FLYING_TO, Constants.DATE_DEPART, Constants.DATE_RETURN, adults, true);
        Assert.assertEquals(flightsTab.titleText.getText(), Constants.RESULT_PAGE_TITLE + " " + cityDestination);
    }

}