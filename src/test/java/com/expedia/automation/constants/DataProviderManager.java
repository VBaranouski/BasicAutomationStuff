package com.expedia.automation.constants;


public class DataProviderManager {


    @org.testng.annotations.DataProvider //(parallel = true)
    static public Object[][] searchFlightInfoProvider() {
        return new Object[][]{
                {"Minsk, Belarus (MSQ-Minsk Intl.)", "New York, NY (NYC-All Airports)", "09/25/2017", "10/10/2017", 2, "New York"},
                {"Miami, FL (MIA-All Airports)", "Amsterdam, Netherlands (AMS-All Airports)", "09/27/2017", "10/12/2017", 1, "Amsterdam"},
                {"New York, NY (NYC-All Airports)", "London, England, UK (LON-All Airports)",  "11/27/2017", "12/12/2017", 3, "London"}};
    }
}
