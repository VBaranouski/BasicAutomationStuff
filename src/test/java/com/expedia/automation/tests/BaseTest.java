package com.expedia.automation.tests;

import com.expedia.automation.driver.WebDriverFactory;
import com.expedia.automation.driver.WebDriverTypes;
import com.expedia.automation.pages.homepage.HomePage;
import com.expedia.automation.pages.navigation.account.HeaderMenuAccount;
import com.expedia.automation.pages.search.flights.FlightsTab;
import com.expedia.automation.pages.signin.MyAccountPage;
import com.expedia.automation.pages.signin.SignInPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.expedia.automation.driver.WebDriverFactory.getInstance;

public class BaseTest {

    protected WebDriver driver;
    protected HeaderMenuAccount headerMenuAccount;
    protected SignInPage signInPage;
    protected FlightsTab flightsTab;
    protected MyAccountPage myAccountPage;
    protected HomePage homePage;


    @BeforeMethod (groups = { "full","smoke"})
    public WebDriver createDriverForTests(){
        driver = getInstance(driver, WebDriverTypes.DriverType.CHROME);
        return driver;
    }

    @BeforeMethod (groups = { "full","smoke"})
    public WebDriver createObjects(){
        homePage = new HomePage(driver);
        headerMenuAccount = new HeaderMenuAccount(driver);
        signInPage = new SignInPage(driver);
        flightsTab = new FlightsTab(driver);
        myAccountPage = new MyAccountPage(driver);
        return driver;
    }

    @AfterMethod (groups = { "full","smoke"})
    public WebDriver closeBrowsers(){
        WebDriverFactory.getInstance(driver, WebDriverTypes.DriverType.CHROME).quit();
        driver = null;
        return driver;
    }

}
