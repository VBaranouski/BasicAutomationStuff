package com.expedia.automation.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chrome extends WebDriverFactory{

    private static final String CHROME_DRIVER = "webdriver.chrome.driver";
    private static final String CHROME_DRIVER_PATH = "/Users/Vlad/Documents/Automation/chromedriver";

    private Chrome (WebDriver driver) {
        super(driver);
    }

    public static WebDriver createChromeDriver() {
        System.setProperty(CHROME_DRIVER, CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
        return driver;
    }
}
