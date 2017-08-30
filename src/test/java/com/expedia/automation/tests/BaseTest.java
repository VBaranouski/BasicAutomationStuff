package com.expedia.automation.tests;

import com.expedia.automation.driver.Singleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static com.expedia.automation.driver.Singleton.getInstance;

public class BaseTest {

    WebDriver driver;
    String username = "Hello, QA";
    String signInpageTitle = "Sign in or select an option";

    @BeforeTest(groups = { "full","smoke"})
    public WebDriver createDriverForTests(){
        driver = getInstance(driver, Singleton.DriverType.CHROME);
        return driver;

    }

    @AfterTest(groups = { "full","smoke"})
    public void closeBrowsers(){
        Singleton.getInstance(driver, Singleton.DriverType.CHROME).close();
    }

}
