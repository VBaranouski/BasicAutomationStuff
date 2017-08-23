package com.expedia.automation.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {



    public static WebDriver createDriver(WebDriver driver){
        System.setProperty("webdriver.chrome.driver", "/Users/Vlad/Documents/Automation/chromedriver");
        if (driver==null){
            driver = new ChromeDriver();
        }
        return driver;
    }


    public void closeWebBrowser(WebDriver driver){
            driver.close();

    }



}
