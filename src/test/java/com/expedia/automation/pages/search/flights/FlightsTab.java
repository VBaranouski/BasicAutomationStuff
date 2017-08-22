package com.expedia.automation.pages.search.flights;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.log4testng.Logger;

public class FlightsTab {

    // navigation

    @FindBy (id = "tab-flight-tab-hp")
    private WebElement flight;

    @FindBy (id = "flight-type-roundtrip-label-hp-flight")
    private WebElement roundTripTab;

    @FindBy (id = "flight-origin-hp-flight")
    private WebElement flyingFrom;

    @FindBy (id = "flight-destination-hp-flight")
    private WebElement flyingTo;

    @FindBy (id = "flight-adults-hp-flight")
    private WebElement adultDropdown;

    @FindBy (id = "flight-add-car-checkbox-hp-flight")
    private WebElement addCarCheckBox;


    @FindBy (xpath = "//*[@id=\"gcw-flights-form-hp-flight\"]/div[8]/label/button")//(className = "btn-primary btn-action gcw-submit")
    private WebElement searchButton;



    //Calendar

    @FindBy (id = "flight-departing-hp-flight")
    private WebElement departingDate;

    @FindBy (id = "flight-returning-hp-flight")
    private WebElement returningDate;

    @FindBy (xpath = "//*[@id=\"flight-departing-wrapper-hp-flight\"]/div/div/div[1]")
    private WebElement closeCalendar;


    //search results page
    @FindBy (className = "title-city-text")
    private WebElement titleText;



    WebDriver driver;
    String searchResult;

    private static final Logger LOGGER = Logger.getLogger(FlightsTab.class);



    public FlightsTab (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void searchFligthWithCar(String fromCity, String toCity, String dateDepart, String dateReturn, int adults){
        flight.click();
        roundTripTab.click();
          LOGGER.info("Flight tab is opened");
        flyingFrom.sendKeys(fromCity);
        flyingTo.sendKeys(toCity);
        returningDate.sendKeys(dateReturn);
        departingDate.sendKeys(dateDepart);
        closeCalendar.click();
        adultDropdown.sendKeys(String.valueOf(adults));
        addCarCheckBox.click();
        searchButton.submit();
          LOGGER.info("Criteria are selected");
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(titleText));
        searchResult = titleText.getText();
        Assert.assertEquals(searchResult,"Select your departure to New York");
         LOGGER.info("Searching flights...");


    }


}