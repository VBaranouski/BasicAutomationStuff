package com.expedia.automation.utils;

import com.expedia.automation.tests.flights.FlightsTests;
import org.testng.annotations.Factory;

public class TestFactory {
    @Factory
    public Object[] createInstances() {
        Object[] result = new Object[3];
        for (int i = 0; i < 3; i++) {
            result[i] = new FlightsTests();
        }
        return result;
    }
}


