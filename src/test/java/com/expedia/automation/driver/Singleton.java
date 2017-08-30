package com.expedia.automation.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;


public class Singleton {

    public enum DriverType {
        CHROME,
        FIREFOX,
        SAFARI
    }


    protected WebDriver driver;

    private static final String CHROMEDRIVER = "webdriver.chrome.driver";
    private static final String CHROMEDRIVERPATH = "/Users/Vlad/Documents/Automation/chromedriver";
    private static final String FIREFOXDRIVER = "webdriver.gecko.driver";
    private static final String FIREFOXDRIVERPATH = "/Users/Vlad/Documents/Automation/geckodriver";


    private Singleton(WebDriver driver) {
        this.driver = driver;

    }

    public static synchronized WebDriver getInstance(WebDriver driver, DriverType type){
        if (driver==null){
            switch (type) {
                case CHROME:
                    System.setProperty(CHROMEDRIVER, CHROMEDRIVERPATH);
                    driver = new ChromeDriver();
                    break;
                case FIREFOX:
                    System.setProperty(FIREFOXDRIVER,FIREFOXDRIVERPATH);
                    driver = new FirefoxDriver();
                    break;
                case SAFARI:
                    driver = new SafariDriver();
                    break;
            }
        }
        return driver;
    }

}
