package com.expedia.automation.tests;


public class DataProvider {


    @org.testng.annotations.DataProvider
    static public Object[][] adultDestCity() {
        return new Object[][]{
                {2, "New York, NY (NYC-All Airports)", "New York"},
                {1, "Amsterdam, Netherlands (AMS-All Airports)", "Amsterdam"},
                {3, "London, England, UK (LON-All Airports)", "London"}};
    }
}
