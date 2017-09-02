package com.expedia.automation.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class RemoteDriver extends DriverFactory {

    private RemoteDriver(WebDriver driver) {
        super(driver);
    }

    public static WebDriver createRemoteDriver() {

        DesiredCapabilities capability = DesiredCapabilities.chrome();
        try {
            driver = new RemoteWebDriver(new URL("http://10.6.183.81:4443//wd/hub"), capability);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    return driver;
    }

}

