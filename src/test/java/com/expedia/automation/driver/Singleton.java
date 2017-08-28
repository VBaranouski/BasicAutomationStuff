package com.expedia.automation.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Singleton {


    protected WebDriver driver;

    private Singleton(WebDriver driver) {
        this.driver = driver;

    }

    public static WebDriver getInstance(WebDriver driver){
        System.setProperty("webdriver.chrome.driver", "/Users/Vlad/Documents/Automation/chromedriver");
        if (driver==null){
            driver = new ChromeDriver();
        }
        return driver;
    }

}
