package com.expedia.automation.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Firefox extends WebDriverFactory{

    private static final String FIREFOX_DRIVER = "webdriver.gecko.driver";
    private static final String FIREFOX_DRIVER_PATH = "/Users/Vlad/Documents/Automation/geckodriver";

    private Firefox (WebDriver driver) {
        super(driver);
    }

    public static WebDriver createFirefoxDriver() {
        System.setProperty(FIREFOX_DRIVER, FIREFOX_DRIVER_PATH);
        driver = new FirefoxDriver();
        return driver;
    }
}
