package com.expedia.automation.driver;

import org.openqa.selenium.WebDriver;

public class WebDriverFactory {

    protected static WebDriver driver;

    protected WebDriverFactory(WebDriver driver) {
        this.driver = driver;
    }

    public static WebDriver getInstance(WebDriver driver, WebDriverTypes.DriverType type){
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


