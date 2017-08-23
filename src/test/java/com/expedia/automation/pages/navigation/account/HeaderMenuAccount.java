package com.expedia.automation.pages.navigation.account;

import com.expedia.automation.pages.BasePage;
import com.expedia.automation.pages.signin.SignInPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderMenuAccount extends BasePage {

    @FindBy (id = "header-account-menu")
    private WebElement accountMenu;

    @FindBy (id = "account-signin")
    private WebElement singInLink;



    public HeaderMenuAccount(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public SignInPage openSignInScreen(WebDriver driver) {
        accountMenu.click();
        singInLink.click();
        return new SignInPage(driver);
    }



}
