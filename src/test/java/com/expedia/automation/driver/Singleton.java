package com.expedia.automation.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Singleton {


    protected WebDriver driver;

    private static final String CHROME_DRIVER = "webdriver.chrome.driver";
    private static final String CHROME_DRIVER_PATH = "/Users/Vlad/Documents/Automation/chromedriver";
    private static final String FIREFOX_DRIVER = "webdriver.gecko.driver";
    private static final String FIREFOX_DRIVER_PATH = "/Users/Vlad/Documents/Automation/geckodriver";


    private Singleton(WebDriver driver) {
        this.driver = driver;
    }


    public static WebDriver getInstance(WebDriver driver, DriverTypes.DriverType type){
        if (driver==null){
            switch (type) {
                case CHROME:
                    System.setProperty(CHROME_DRIVER, CHROME_DRIVER_PATH);
                    driver = new ChromeDriver();
                    break;
                case FIREFOX:
                    System.setProperty(FIREFOX_DRIVER,FIREFOX_DRIVER_PATH);
                    driver = new FirefoxDriver();
                    break;
                case SAFARI:
                    driver = new SafariDriver();
                    break;
                case REMOTE_DRIVER:
                    DesiredCapabilities capability = DesiredCapabilities.chrome();
                    try {
                        driver = new RemoteWebDriver(new URL("http://10.6.183.81:4443//wd/hub"), capability);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
            }
        }
        return driver;
    }

}
