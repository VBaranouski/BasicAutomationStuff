package com.expedia.automation.tests.flights;

import com.expedia.automation.constants.Constants;
import com.expedia.automation.constants.DataProviderManager;
import com.expedia.automation.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class FlightsTests extends BaseTest {


    @Test (groups = { "smoke","full" }, dataProvider = "searchFlightInfoProvider", dataProviderClass = DataProviderManager.class)
    public void flightSearchViaDataProvider(String flightFrom, String flightDest, String dateDepart, String dateReturn, int adults, String cityDestination) {
        homePage.openExpedia(driver);
        flightsTab.searchFlighthWithCar(flightFrom, flightDest, dateDepart, dateReturn, adults, false);
        // add a assertion msg if test will fai
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