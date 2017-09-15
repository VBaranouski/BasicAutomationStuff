package com.expedia.automation.pages.signin;

import com.expedia.automation.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MyAccountPage extends BasePage {

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }


    @FindBy (id = "header-account-menu-signed-in")
    public WebElement userNameLink;

    @FindBy (id = "account-myaccount")
    public  WebElement myAccountLink;

    @FindBy (id = "my_travel_details_div")
    public WebElement myTravelDetails;


    @FindBy (id = "ff")
    public WebElement frequentFlyer;

    @FindBy (xpath = "//*[@id=\"ff\"]/article/div/span")
    public WebElement frequentFlyerTitle;

    @FindBy (name = "userMembershipName")
    public WebElement programName;

    @FindBy (name = "membershipProgramNumber")
    public WebElement programNumber;

    @FindBy (id = "membership_button_0")
    public WebElement programSave;


    @FindBy (id = "pi")
    public WebElement personalInfo;

    @FindBy (id = "radio-male")
    public WebElement maleRadioButton;

    @FindBy (id = "radio-female")
    public WebElement femaleRadioButton;

    @FindBy (id = "name_button")
    public WebElement savePersonalInfo;

    @FindBy (xpath = "//*[@id=\"pi\"]/article/div/span")
    public WebElement personalInfoTitle;


    @FindBy (id = "flightPref")
    public WebElement flightPreferences;

    @FindBy (id = "homeAirport")
    public WebElement homeAirportField;

    @FindBy (xpath = "//*[@id=\"aria-option-0\"]")
    public WebElement homeAirportPopup;

    @FindBy (xpath = "//*[@id=\"flightPref\"]/article/div/span")
    public WebElement flightPrefTitle;

    @FindBy (id = "seatingPreference")
    public WebElement seatingPrefDropdown;

    @FindBy (id = "specialRequest")
    public WebElement specialRequestDropdown;

    @FindBy (id = "flight_preferences_button")
    public WebElement saveFligthPrefButton;


    @FindBy (id = "passport")
    public WebElement passports;

    @FindBy (id = "tsa")
    public WebElement TSAinfo;


    WebDriverWait wait = new WebDriverWait(driver, 50);

    public void openMyAccountPage(){
        wait.until(ExpectedConditions.visibilityOf(userNameLink));
        userNameLink.click();
        myAccountLink.click();
    }

    public void frequentFlyerCheck(String prName, String prNumber){
        wait.until(ExpectedConditions.visibilityOf(frequentFlyer));
        frequentFlyer.click();
        programName.clear();
        programName.sendKeys(prName);
        programNumber.clear();
        programNumber.sendKeys(prNumber);
        programSave.click();
    }

    public void personalInfo(){
        wait.until(ExpectedConditions.visibilityOf(personalInfo));
        personalInfo.click();
        maleRadioButton.click();
        savePersonalInfo.click();
    }


    public void flightPreferences(String homeAirport){
        wait.until(ExpectedConditions.visibilityOf(flightPreferences));
        flightPreferences.click();
        homeAirportField.clear();
        homeAirportField.sendKeys(homeAirport);
        wait.until(ExpectedConditions.elementToBeClickable(homeAirportPopup));
        homeAirportPopup.click();
        Select seatingMenu = new Select(seatingPrefDropdown);
        seatingMenu.selectByValue("AISLE");
        Select specRequestMenu = new Select(specialRequestDropdown);
        specRequestMenu.selectByValue("HelpLang");
        saveFligthPrefButton.click();
    }
}
