package web.player.core;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.player.constants.ContentTypes;
import web.player.constants.WebPlayerConstants;

import static web.player.tests.WebPlayerBaseTest.*;

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

    @FindBy (className = "edge-gui-progress-bar-thumb")
    public static WebElement scrubber;

    @FindBy (xpath = ".//div[@class = 'edge-gui-progress-bar-cuepoint-container']/div[1]")
    public static  WebElement firstCuePoint;

    @FindBy (className = "edge-gui-progress-bar-cuepoint-container")
    public static WebElement cuePoints;

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

    @FindBy (xpath = ".//div[contains(@class, 'edge-gui-cc-settings-expanded')][3]/div[@class = 'edge-gui-settings-back']")
    public static WebElement settingsFontColorBackButton;

    @FindBy (xpath = ".//div[contains(@class, 'edge-gui-cc-settings-expanded')]/div[contains(@class, 'edge-gui-cc-expander-label')][text()='Medium']")
    public static WebElement ccFontSize;

    @FindBy (xpath = ".//div[contains(@class, 'edge-gui-font-selectors')]/div[@data-value=\"small\"]")
    public static WebElement ccSmallFontSize;

    @FindBy (xpath = "//div[contains(@class, 'edge-gui-cc-settings-expanded')][3]/div[contains(@class, 'edge-gui-cc-expander')]")
   public static WebElement ccFontColor;

    @FindBy (xpath = ".//div[contains(@class, edge-gui-cc-settings-option)][@data-value=\"red\"]")
    public static WebElement ccFontColorRed;



    // Player Actions GUI

    public void pausePlayback() {
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
        Log.info("Opening FS");
        elementWait.until(ExpectedConditions.visibilityOf(fullScreenIcon));
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
            elementWait.until(ExpectedConditions.visibilityOf(closedCaptionsIcon));
            closedCaptionsIcon.click();
        }
    }

    public void hideClosedCaptions(){closedCaptionsIcon.click();}

    public void selectSmallFontSize(){
        Log.info("Select Small Font Size");
        if (ccFontSize.isDisplayed()){
            ccFontSize.click();
        }
        else {elementWait.until(ExpectedConditions.visibilityOf(ccFontSize));
            ccFontSize.click();
        }
        if (ccSmallFontSize.isDisplayed()) {
            ccSmallFontSize.click();
        }
        else {elementWait.until(ExpectedConditions.visibilityOf(ccSmallFontSize));
            ccSmallFontSize.click();
        }
        if (settingsFontSizeBackButton.isDisplayed()) {
            settingsFontSizeBackButton.click();
        }
        else {elementWait.until(ExpectedConditions.visibilityOf(ccSmallFontSize));
            settingsIcon.click();
        }
    }

    public void selectRedColor(){
        Log.info("Click on Font default color");
        elementWait.until(ExpectedConditions.visibilityOf(ccFontColor));
        ccFontColor.click();
        Log.info("Select Font Red color");
        elementWait.until(ExpectedConditions.visibilityOf(ccFontColorRed));
        ccFontColorRed.click();
        settingsFontColorBackButton.click();
    }


    public int scrubbedTime;

    public int getScrubbedTime() { return scrubbedTime; }

    public void setScrubbedTime(int scrubbedTime) { this.scrubbedTime = scrubbedTime; }

    public void scrubToNextSegment() {
        if (!cuePoints.getCssValue("display").equals("none")){
            elementWait.until(ExpectedConditions.visibilityOf(firstCuePoint));
            Log.info("CuePoints are found. Scrubbing...");
            Double doubleValueOfCuePoint = new Double(Double.parseDouble(firstCuePoint.getCssValue("left").replaceAll("[^0-9.]", "")));
            int xScrubber = doubleValueOfCuePoint.intValue();
            int initialScrubberLocation = scrubber.getLocation().x;
            scrubAction.dragAndDropBy(scrubber, xScrubber+10, 0).release().perform();
            crossSegmentScrubWait.until(ExpectedConditions.visibilityOf(firstCuePoint));
            int afterscrubScrubberLocation = scrubber.getLocation().x;
            setScrubbedTime(getTimeOfElementInSeconds(playbackDuration)*(afterscrubScrubberLocation-initialScrubberLocation)/(progressBar.getSize().width));
            }
            else { Log.info("Cue points are not found. This is not a Full Episode or Seamless mode is enabled. Scrubbing into the middle");
                int initialScrubberLocation = scrubber.getLocation().x;
                scrubAction.dragAndDropBy(scrubber, (progressBar.getSize().width - scrubber.getLocation().x)/2, 0).release().perform();
                int afterscrubScrubberLocation = scrubber.getLocation().x;
                setScrubbedTime(getTimeOfElementInSeconds(playbackDuration)*(afterscrubScrubberLocation-initialScrubberLocation)/(progressBar.getSize().width));
                }
    }

    public static int getTimeOfElementInSeconds(WebElement elementName) {
        elementWait.until(ExpectedConditions.visibilityOf(elementName));
        String[] parts = elementName.getText().split(":");
        int playbackDurationInSeconds = Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
        return playbackDurationInSeconds;
    }

}
