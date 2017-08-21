package com.expedia.automation.pages.signin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {


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


    private WebDriver driver;

    public SignInPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void signIn(WebDriver driver, String email, String pass){

            emailAdd.sendKeys(email);
            password.sendKeys(pass);
            subminButton.click();




    }

}
