package com.expedia.automation.pages.navigation.account;

import com.expedia.automation.pages.signin.SignInPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderMenuAccount {

    @FindBy (id = "header-account-menu")
    private WebElement accountMenu;

    @FindBy (id = "account-signin")
    private WebElement singInLink;


    private WebDriver driver;

    public HeaderMenuAccount(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public SignInPage openSignInScreen(WebDriver driver) {
        accountMenu.click();
        singInLink.click();
        return new SignInPage(driver);
    }



}
