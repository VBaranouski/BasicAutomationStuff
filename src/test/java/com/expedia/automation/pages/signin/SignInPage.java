package com.expedia.automation.pages.signin;

import com.expedia.automation.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.log4testng.Logger;

public class SignInPage extends BasePage{


    @FindBy (id = "signin-loginid")
    private WebElement emailAdd;

    @FindBy (id = "signin-password")
    private WebElement password;

    @FindBy (id = "submitButton")
    private WebElement subminButton;

    @FindBy (className = "modal-body")
    private WebElement modalPopUp;

    @FindBy (id = "gss-signin-email")
    private WebElement emailAddPopup;

    @FindBy (id = "gss-signin-password")
    private WebElement passwordPopup;

    @FindBy (id = "gss-signin-submit")
    private WebElement subminButtonPopup;

    private static final Logger LOGGER = Logger.getLogger(SignInPage.class);


    public SignInPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }


    public void signIn(WebDriver driver, String email, String pass){

            emailAdd.sendKeys(email);
            password.sendKeys(pass);
            subminButton.click();
              LOGGER.info("User is signed in");

    }

}
