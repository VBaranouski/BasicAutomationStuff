package com.expedia.automation.tests.flights;

import com.expedia.automation.constants.Constants;
import com.expedia.automation.constants.DataProviderManager;
import com.expedia.automation.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


@Retention(RetentionPolicy.RUNTIME)
@interface ExpediaCheck{
    String str() default "Running Expedia tests";
}

public class FlightsTests extends BaseTest {

    public static void showCustomAnnotation(){
        BaseTest ob = new BaseTest();
        try {
            ExpediaCheck m = ob.getClass().getMethod("flightSearchViaParameters").getAnnotation(ExpediaCheck.class);
            System.out.println(m.str());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }


    @ExpediaCheck (str = "Desktop")
    @Test (groups = { "smoke","full" }, dataProvider = "searchFlightInfoProvider", dataProviderClass = DataProviderManager.class)
    public void flightSearchViaDataProvider(String flightFrom, String flightDest, String dateDepart, String dateReturn, int adults, String cityDestination) {
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