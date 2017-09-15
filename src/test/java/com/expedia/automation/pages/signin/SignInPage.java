package com.expedia.automation.pages.signin;

import com.expedia.automation.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.log4testng.Logger;

public class SignInPage extends BasePage{

    // static private constants are on the top
    private static final Logger LOGGER = Logger.getLogger(SignInPage.class);

    @FindBy (id = "signin-loginid")
    public WebElement emailAdd;

    @FindBy (id = "signin-password")
    public WebElement password;

    @FindBy (id = "submitButton")
    private WebElement subminButton;

    @FindBy (className = "modal-body")
    public WebElement modalPopUp;

    @FindBy (id = "gss-signin-email")
    public WebElement emailAddPopup;

    @FindBy (id = "gss-signin-password")
    public WebElement passwordPopup;

    @FindBy (id = "gss-signin-submit")
    public WebElement subminButtonPopup;

    public SignInPage(WebDriver driver){
        super(driver);
    }

    public void signIn(String email, String pass){
            emailAdd.sendKeys(email);
            password.sendKeys(pass);
            subminButton.click();
            LOGGER.info("Login form submitted");
    }
}
