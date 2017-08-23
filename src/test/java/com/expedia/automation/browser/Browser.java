package com.expedia.automation.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.log4testng.Logger;

public class Browser {


    private static WebDriver driver;
    private static final String URL = "http://www.expedia.com";
    private static final Logger LOGGER = Logger.getLogger(Browser.class);

    public static WebDriver createDriver(WebDriver driver){
        System.setProperty("webdriver.chrome.driver", "/Users/Vlad/Documents/Automation/chromedriver");
        if (driver==null){
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static void closeWebBrowser(WebDriver driver){
        if (null != driver){
            driver.quit();
        }
        driver = null;
    }

    public WebDriver openExpedia(WebDriver driver){
        driver.get(URL);
           LOGGER.info("Homepage is loaded");
        return driver;
    }

}
