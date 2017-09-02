package com.expedia.automation.driver;

import org.openqa.selenium.WebDriver;

public class DriverFactory {

    protected static WebDriver driver;

    protected DriverFactory(WebDriver driver) {
        this.driver = driver;
    }

    public static synchronized WebDriver getInstance(WebDriver driver, DriverTypes.DriverType type){
        if (driver==null){
            switch (type) {
                case CHROME:
                    driver = Chrome.createChromeDriver();
                    break;
                case FIREFOX:
                    driver = Firefox.createFirefoxDriver();
                    break;
                case REMOTE_DRIVER:
                    driver = RemoteDriver.createRemoteDriver();
            }
        }
        return driver;
    }

}


