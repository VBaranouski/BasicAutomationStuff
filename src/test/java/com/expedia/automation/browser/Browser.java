package com.expedia.automation.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {


    private static WebDriver driver;
    private static final String URL = "http://www.expedia.com";


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
        return driver;
    }

}
