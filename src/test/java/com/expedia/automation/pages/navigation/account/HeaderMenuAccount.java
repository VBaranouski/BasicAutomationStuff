package com.expedia.automation.pages.navigation.account;

import com.expedia.automation.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderMenuAccount extends BasePage {

    @FindBy (id = "header-account-menu")
    private WebElement accountMenu;

    @FindBy (id = "account-signin")
    private WebElement singInLink;

    @FindBy (id = "signInheader")
    public WebElement pageTitle;


    public HeaderMenuAccount(WebDriver driver){
        super(driver);
    }


    public void  openSignInScreen() {
        accountMenu.click();
        singInLink.click();

    }

}
