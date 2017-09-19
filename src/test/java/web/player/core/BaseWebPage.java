package web.player.core;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.player.constants.ContentTypes;
import web.player.constants.WebPlayerConstants;

import static web.player.tests.WebPlayerBaseTest.wait;

public class BaseWebPage {

    public WebDriver driver;
    private static Logger Log = Logger.getLogger(BaseWebPage.class);

    public BaseWebPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void openTestRigPage (ContentTypes.ContentType type){
        switch (type){
            case FULL_EPISODE: driver.get(WebPlayerConstants.FULL_EPIDOSE_URL);
                break;
            case CLIP: driver.get(WebPlayerConstants.CLIP_URL);
                break;
            case LIVE: driver.get(WebPlayerConstants.LIVE);
                break;
        }
    }


    //Elements
    //Player Controls

    @FindBy(className = "edge-gui-playback-button")
    public static WebElement playButton;

    @FindBy (className = "edge-gui-playback-button")
    public static WebElement pauseButton;

    @FindBy (className = "edge-gui-volume-slider-icon")
    public static WebElement volumeIcon;

    @FindBy (className = "edge-gui-current-time")
    public static WebElement currentPlaybackTime;

    @FindBy (className = "edge-gui-duration")
    public static WebElement playbackDuration;

    @FindBy (className = "edge-gui-cc-button")
    public static WebElement closedCaptionsIcon;

    @FindBy (className = "edge-gui-settings-button")
    public static WebElement settingsIcon;

    @FindBy (className = "edge-gui-fullscreen-button")
    public static WebElement fullScreenIcon;

    @FindBy (className = "edge-gui-share-button")
    public static WebElement shareIcon;

    @FindBy (className = "edge-gui-content-metadata-artist")
    public static WebElement artistMetadata;

    @FindBy (className = "edge-gui-content-metadata-media-title")
    public static WebElement titleMetadata;

    @FindBy (className = "edge-gui-progress-bar")
    public static WebElement progressBar;

    @FindBy (className = "edge-gui")
    public static WebElement playersFrame;

    //ads:

    @FindBy (className = " edge-gui-ad-metadata")
    public static WebElement adGuiMetadata;


    //Closed Captions:

    @FindBy (className = "edge-gui-cc-settings")
    public static WebElement settingsPopup;

    @FindBy (css = "#video-player > div.edge-cc-container.edge-cc-default")
    public static WebElement ccContainer;

    @FindBy (className = "edge-cc-track-cue")
    public static WebElement firstRowCC;


    //Closed Captions - Settings popup

    @FindBy (xpath = ".//div[contains(@class, 'edge-gui-cc-settings-expanded')][2]/div[@class = 'edge-gui-settings-back']")
    public static WebElement settingsFontSizeBackButton;

    // please read about the building xpaths
    // for above element it can be like this - "Locator": "XPath:://div[contains(@class, 'edge-gui-cc-settings-expanded')][2]/div[@class='edge-gui-settings-back']"

    //@FindBy (css = "#video-player > div.edge-gui > div.edge-gui-settings.edge-gui-settings-no-tabs > div.edge-gui-settings-container > div > div.edge-gui-cc-options-container > div.edge-gui-cc-options-button-list > div:nth-child(3) > div.edge-gui-settings-back")
    @FindBy (xpath = ".//div[contains(@class, 'edge-gui-cc-settings-expanded')][3]/div[@class = 'edge-gui-settings-back']")
    public static WebElement settingsFontColorBackButton;

    //@FindBy (css = "#video-player > div.edge-gui > div.edge-gui-settings.edge-gui-settings-no-tabs > div.edge-gui-settings-container > div > div.edge-gui-cc-options-container > div.edge-gui-cc-options-button-list > div:nth-child(2) > div.edge-gui-cc-expander.edge-gui-cc-expander-label")
    @FindBy (xpath = ".//div[contains(@class, 'edge-gui-cc-settings-expanded')]/div[contains(@class, 'edge-gui-cc-expander-label')][text()='Medium']")
    public static WebElement ccFontSize;

    @FindBy (xpath = ".//div[contains(@class, 'edge-gui-cc-settings-expanded')][2]/div[@class = 'edge-gui-font-selectors']/div[@data-value=\"small\"]")
    public static WebElement ccSmallFontSize;

    @FindBy (css = "#video-player > div.edge-gui > div.edge-gui-settings.edge-gui-settings-no-tabs > div.edge-gui-settings-container > div > div.edge-gui-cc-options-container > div.edge-gui-cc-options-button-list > div:nth-child(3) > div.edge-gui-cc-expander.edge-gui-cc-expander-color")
    public static WebElement ccFontColor;

    @FindBy (css = "#video-player > div.edge-gui > div.edge-gui-settings.edge-gui-settings-no-tabs > div.edge-gui-settings-container > div > div.edge-gui-cc-options-container > div.edge-gui-cc-options-button-list > div:nth-child(3) > div.edge-gui-cc-settings-color-list > div:nth-child(3)")
    public static WebElement ccFontColorRed;



    // Player Actions GUI

    public void pausePlayback() {
        Log.info("muting playback");
        if (playButton.isDisplayed()){
            playButton.click();
        }
        else {
            Log.error("Play button is not visible. May be GUI is not loaded");
        }

    }

    public void tapOnPlayer(){playersFrame.click();}

    public void resumePlayback() {
        pauseButton.click();
    }

    public void openFullScreen(){
        fullScreenIcon.click();
    }

    public void exitFullScreen(){
        fullScreenIcon.click();
    }

    public void mutePlayback() { volumeIcon.click(); }

    // 3. I hope that for example method mutePlayback in the near future will be like
    //    public void muteAd() {
    //        Logger.logMessage("Mute the Ad ...");
    //        openPlayerToolbar();
    //        if (adVolumeIcon().isPresent()) {
    //            adVolumeIcon().waitForPresent().click();
    //        } else {
    //            Logger.logMessage("Ad is already muted.");
    //        }
    //    }
    // =)


    public void unmutePlayback() {
        volumeIcon.click();
    }

    //AD break

    public void waitForAdBreakfinish(){ }

    // Closed Captions

    public void openSettingsMenu(){ settingsIcon.click(); }

    public void hideSettingsMenu(){settingsIcon.click(); }

    public void showClosedCaptions(){
        Log.info("Enabling Closed Captions");
        if (closedCaptionsIcon.isDisplayed()) {
            closedCaptionsIcon.click();
        }
        else {
            Log.info("Closed Captions is not displayed. Waiting for the icon to be clickable");
            wait.until(ExpectedConditions.visibilityOf(closedCaptionsIcon));
            closedCaptionsIcon.click();
        }
    }

    public void hideClosedCaptions(){closedCaptionsIcon.click();}

    public void selectSmallFontSize(){
        if (ccFontSize.isDisplayed()){
            ccFontSize.click();
        }
        else {wait.until(ExpectedConditions.visibilityOf(ccFontSize));
            ccFontSize.click();
        }
        if (ccSmallFontSize.isDisplayed()) {
            ccSmallFontSize.click();
        }
        else {wait.until(ExpectedConditions.visibilityOf(ccSmallFontSize));
            ccSmallFontSize.click();
        }
        if (settingsFontSizeBackButton.isDisplayed()) {
            settingsFontSizeBackButton.click();
        }
        else {wait.until(ExpectedConditions.visibilityOf(ccSmallFontSize));
            settingsIcon.click();
        }
    }

    public void selectRedColor(){
        ccFontColor.click();
        ccFontColorRed.click();
        settingsFontColorBackButton.click();
    }


}
