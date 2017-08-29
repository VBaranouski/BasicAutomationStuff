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
    private WebElement pageTitle;


    public HeaderMenuAccount(WebDriver driver){
        super(driver);
    }

    private String signinPageTitle;

    public String getSigninPageTitle() {
        return signinPageTitle;
    }

    public void setSigninPageTitle(String signinPageTitle) {
        this.signinPageTitle = signinPageTitle;
    }


    public void  openSignInScreen(WebDriver driver) {
        accountMenu.click();
        singInLink.click();
        setSigninPageTitle(pageTitle.getText());
    }

}
