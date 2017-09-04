package com.expedia.automation.tests.myaccount;

import com.expedia.automation.constants.Constants;
import com.expedia.automation.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyAccountTests extends BaseTest {


    @BeforeMethod(groups = { "full","smoke"})
    public void loginAction(){
        homePage.openExpedia(driver);
        headerMenuAccount.openSignInScreen();
        signInPage.signIn(Constants.EMAIL, Constants.PASSWORD);
    }


    @Test(priority = 1, enabled = false, groups = { "full" })
    public void userNameCheck(){
        myAccountPage.openMyAccountPage();
        Assert.assertEquals(myAccountPage.userNameLink.getText(), Constants.USER_NAME);
    }

    @Test(priority = 2, enabled = false, groups = {"full"})
    public void travelDetailsFrequentFlyerCheck(){
        myAccountPage.openMyAccountPage();
        Assert.assertTrue(myAccountPage.frequentFlyerTitle.isDisplayed());
        myAccountPage.frequentFlyerCheck(Constants.PROGRAM_NAME, Constants.PROGRAM_NUMBER);
        Assert.assertEquals(myAccountPage.frequentFlyerTitle.getText(), Constants.FREQUENT_FLYER_TITLE);
    }

    @Test(priority = 3, enabled = false, groups = {"full"})
    public void travelDetailsPersonalInfoCheck(){
        myAccountPage.openMyAccountPage();
        Assert.assertTrue(myAccountPage.personalInfo.isDisplayed());
        Assert.assertEquals(myAccountPage.personalInfoTitle.getText(), Constants.PERSONAL_INFO_TITLE);
        myAccountPage.personalInfo();
    }

    @Test(priority = 3, enabled = true, groups = {"full"})
    public void travelDetailsFlightPrefCheck(){
        myAccountPage.openMyAccountPage();
        Assert.assertTrue(myAccountPage.flightPrefTitle.isDisplayed());
        Assert.assertEquals(myAccountPage.flightPrefTitle.getText(), Constants.FLIGHT_PREFERENCES_TITLE);
        myAccountPage.flightPreferences(Constants.HOME_AIRPORT);
    }
}
