package com.expedia.automation.pages.homepage;

import com.expedia.automation.constants.Constants;
import com.expedia.automation.pages.BasePage;
import org.openqa.selenium.WebDriver;


public class HomePage extends BasePage{


    public HomePage(WebDriver driver){
        super(driver);
    }


    public void openExpedia (WebDriver driver) {
        driver.get(Constants.URL);

    }
}