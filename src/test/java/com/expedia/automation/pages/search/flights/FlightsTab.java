package com.expedia.automation.pages.search.flights;

import com.expedia.automation.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.log4testng.Logger;

public class FlightsTab extends BasePage {

    private static final Logger LOGGER = Logger.getLogger(FlightsTab.class);

    // Navigation

    @FindBy (id = "tab-flight-tab-hp")
    public WebElement flight;

    @FindBy (id = "flight-type-roundtrip-label-hp-flight")
    public WebElement roundTripTab;

    //Search flight

    @FindBy (id = "flight-origin-hp-flight")
    public WebElement flyingFrom;

    @FindBy (id = "flight-destination-hp-flight")
    public WebElement flyingTo;

    @FindBy (id = "flight-adults-hp-flight")
    public WebElement adultDropdown;

    @FindBy (id = "flight-add-car-checkbox-hp-flight")
    public WebElement addCarCheckBox;

    @FindBy (xpath = "//*[@id=\"gcw-flights-form-hp-flight\"]/div[8]/label/button")//(className = "btn-primary btn-action gcw-submit")
    public WebElement searchButton;

    //Calendar

    @FindBy (id = "flight-departing-hp-flight")
    public WebElement departingDate;

    @FindBy (id = "flight-returning-hp-flight")
    public WebElement returningDate;

    @FindBy (xpath = "//*[@id=\"flight-departing-wrapper-hp-flight\"]/div/div/div[1]")
    public WebElement closeCalendar;

    //Search-results page

    @FindBy (className = "title-city-text")
    public WebElement titleText;


    public FlightsTab (WebDriver driver){
        super(driver);
    }

    public void searchFlighthWithCar(String fromCity, String toCity, String dateDepart, String dateReturn, int adults, Boolean withCar){
        flight.click();
        flyingFrom.sendKeys(fromCity);
        flyingTo.sendKeys(toCity);
        returningDate.clear();
        returningDate.sendKeys(dateReturn);
        departingDate.clear();
        departingDate.sendKeys(dateDepart);
        closeCalendar.click();
        adultDropdown.sendKeys(String.valueOf(adults));
        if (withCar) {
            addCarCheckBox.click();
        }
        LOGGER.info("Criteria are selected");
        searchButton.submit();
        
    }


}
