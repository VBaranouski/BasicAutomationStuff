package com.expedia.automation.pages.homepage;

import com.expedia.automation.pages.BasePage;
import org.openqa.selenium.WebDriver;


public class HomePage extends BasePage{


    private static final String URL = "http://www.expedia.com";

    public HomePage(WebDriver driver){
        super(driver);
    }


    public WebDriver openExpedia(WebDriver driver) {
        driver.get(URL);
        return driver;
    }
}