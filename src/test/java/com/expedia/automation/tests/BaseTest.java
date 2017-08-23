package com.expedia.automation.tests;

import com.expedia.automation.driver.Browser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static com.expedia.automation.driver.Browser.createDriver;

public class BaseTest {

    protected static final String EMAIL = "vladislav.baranovski1@gmail.com";
    protected static final String PASSWORD = "barvadya18";

    protected static final String FLYINGFROM = "Minsk, Belarus (MSQ-Minsk Intl.)";
    protected static final String FLYINGTO = "New York, NY (NYC-All Airports)";
    protected static final String DATEDEPART = "09/25/2017";
    protected static final String DATERETURN = "09/30/2017";

    protected static final String RESULTPAGETITLE = "Select your departure to New York";

    WebDriver driver;

    @BeforeTest(groups = { "full","smoke" })
    public WebDriver createDriverForTests(){
        driver = createDriver(driver);
        return driver;

    }

    @AfterTest(groups = { "full","smoke" })
    public void closeBrowsers(){
        Browser.createDriver(driver).close();
    }
}
