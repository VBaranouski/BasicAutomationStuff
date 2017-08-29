package com.expedia.automation.pages.signin;

import com.expedia.automation.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;


public class MyAccount extends BasePage {

    public MyAccount(WebDriver driver) {
        super(driver);
    }

    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @FindBy (id = "header-account-menu-signed-in")
    private WebElement userNameLink;


    @FindBy (id = "my_travel_details_div")
    private WebElement myTravelDetails;

    @FindBy (id = "ff")
    private WebElement frequentFlyer;



    public void openMyAccountPage(){
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOf(userNameLink));
        userNameLink.click();
        setUserName(userNameLink.getText());
    }


    public void travelDetail(){
        WebDriverWait wait = new WebDriverWait(driver, 50);
        List<WebElement> listEl = new ArrayList<WebElement>();
        listEl.add(frequentFlyer);
        wait.until(ExpectedConditions.visibilityOfAllElements(listEl));

    }

}
