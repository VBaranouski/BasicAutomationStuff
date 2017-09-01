package com.expedia.automation.tests;

import com.expedia.automation.driver.DriverTypes;
import com.expedia.automation.driver.Singleton;
import com.expedia.automation.pages.homepage.HomePage;
import com.expedia.automation.pages.navigation.account.HeaderMenuAccount;
import com.expedia.automation.pages.search.flights.FlightsTab;
import com.expedia.automation.pages.signin.MyAccountPage;
import com.expedia.automation.pages.signin.SignInPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static com.expedia.automation.driver.Singleton.getInstance;

public class BaseTest {

    protected WebDriver driver;
    protected HeaderMenuAccount headerMenuAccount;
    protected SignInPage signInPage;
    protected FlightsTab flightsTab;
    protected MyAccountPage myAccountPage;
    protected HomePage homePage;


    @BeforeTest(groups = { "full","smoke"})
    public WebDriver createDriverForTests(){
        driver = getInstance(driver, DriverTypes.DriverType.REMOTE_DRIVER);
        return driver;
    }

    @BeforeTest(groups = { "full","smoke"})
    public WebDriver createObjects(){
        homePage = new HomePage(driver);
        headerMenuAccount = new HeaderMenuAccount(driver);
        signInPage = new SignInPage(driver);
        flightsTab = new FlightsTab(driver);
        myAccountPage = new MyAccountPage(driver);
        return driver;
    }

    @AfterTest(groups = { "full","smoke"})
    public void closeBrowsers(){
        Singleton.getInstance(driver, DriverTypes.DriverType.REMOTE_DRIVER).quit();
    }

}
