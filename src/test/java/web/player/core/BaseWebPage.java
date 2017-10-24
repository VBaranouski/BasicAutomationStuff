package web.player.core;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.player.constants.ApiCommands;
import web.player.constants.ContentTypes;
import web.player.constants.WebPlayerConstants;

import static web.player.tests.WebPlayerBaseTest.*;

public class BaseWebPage {

    public WebDriver driver;

    private static Logger log = Logger.getLogger(BaseWebPage.class);

    public BaseWebPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Elements
    // Player Controls

    @FindBy(className = "edge-gui-playback-button")
    public static WebElement playButton;

    @FindBy(className = "edge-gui-playback-button")
    public static WebElement pauseButton;

    @FindBy(className = "edge-gui-volume-slider-icon")
    public static WebElement volumeIcon;

    @FindBy(className = "edge-gui-current-time")
    public static WebElement currentPlaybackTime;

    @FindBy(className = "edge-gui-duration")
    public static WebElement playbackDuration;

    @FindBy(className = "edge-gui-cc-button")
    public static WebElement closedCaptionsIcon;

    @FindBy(className = "edge-gui-settings-button")
    public static WebElement settingsIcon;

    @FindBy(className = "edge-gui-fullscreen-button")
    public static WebElement fullScreenIcon;

    @FindBy(className = "edge-gui-share-button")
    public static WebElement shareIcon;

    @FindBy(className = "edge-gui-content-metadata-artist")
    public static WebElement artistMetadata;

    @FindBy(className = "edge-gui-content-metadata-media-title")
    public static WebElement titleMetadata;

    @FindBy(className = "edge-gui-progress-bar")
    public static WebElement progressBar;

    @FindBy(xpath = ".//div[contains(@class, 'edge-gui')]")
    public static WebElement toolBar;

    @FindBy(className = "edge-gui-progress-bar-thumb")
    public static WebElement scrubber;

    @FindBy(xpath = ".//div[@class = 'edge-gui-progress-bar-cuepoint-container']/div[1]")
    public static WebElement firstCuePoint;

    @FindBy(className = "edge-gui-progress-bar-cuepoint-container")
    public static WebElement cuePoints;

    // ads:

    @FindBy(className = "edge-player-ads-element")
    public static WebElement adGui;

    @FindBy(className = "edge-gui-ad-metadata-caption")
    public static WebElement adGuiMetadata;

    // Closed Captions:

    @FindBy(className = "edge-gui-cc-settings")
    public static WebElement settingsPopup;

    @FindBy(css = "#video-player > div.edge-cc-container.edge-cc-default")
    public static WebElement ccContainer;

    @FindBy(className = "edge-cc-track-cue")
    public static WebElement firstRowCC;

    // Closed Captions - Settings popup

    @FindBy(
            xpath =
                    ".//div[contains(@class, 'edge-gui-cc-settings-expanded')][2]/div[@class = 'edge-gui-settings-back']"
    )
    public static WebElement settingsFontSizeBackButton;

    @FindBy(
            xpath =
                    ".//div[contains(@class, 'edge-gui-cc-settings-expanded')][3]/div[@class = 'edge-gui-settings-back']"
    )
    public static WebElement settingsFontColorBackButton;

    @FindBy(
            xpath =
                    ".//div[contains(@class, 'edge-gui-cc-settings-expanded')]/div[contains(@class, 'edge-gui-cc-expander-label')][text()='Medium']"
    )
    public static WebElement ccFontSize;

    @FindBy(xpath = ".//div[contains(@class, 'edge-gui-font-selectors')]/div[@data-value=\"small\"]")
    public static WebElement ccSmallFontSize;

    @FindBy(
            xpath =
                    "//div[contains(@class, 'edge-gui-cc-settings-expanded')][3]/div[contains(@class, 'edge-gui-cc-expander')]"
    )
    public static WebElement ccFontColor;

    @FindBy(xpath = ".//div[contains(@class, edge-gui-cc-settings-option)][@data-value=\"red\"]")
    public static WebElement ccFontColorRed;

    @FindBy(className = "edge-spinner-icon")
    public static WebElement spinner;

    //

    public void openTestRigPage(ContentTypes.ContentType type) {
        switch (type) {
        case FULL_EPISODE:
            driver.get(WebPlayerConstants.FULL_EPIDOSE_URL);
            break;
        case CLIP:
            driver.get(WebPlayerConstants.CLIP_URL);
            break;
        case LIVE:
            driver.get(WebPlayerConstants.LIVE);
            break;
        case SEAMLESS:
            driver.get(WebPlayerConstants.SEAMLESS);
            break;
        }
    }

    // Player GUI

    public void pausePlayback() {
        if (playButton.isDisplayed()) {
            playButton.click();
        } else {
            log.error("Play button is not visible. May be GUI is not loaded");
        }
    }

    public void resumePlayback() {
        pauseButton.click();
    }

    public void openFullScreen() {
        log.info("Opening FS");
        elementWait.until(ExpectedConditions.visibilityOf(fullScreenIcon));
        fullScreenIcon.click();
    }

    public void exitFullScreen() {
        fullScreenIcon.click();
    }

    public void mutePlayback() {
        volumeIcon.click();
    }

    public void unmutePlayback() {
        volumeIcon.click();
    }

    public void openSettingsMenu() {
        if (settingsIcon.isDisplayed()) {
            settingsIcon.click();
        } else {
            log.info("no closed captions for this video");
        }
    }

    public void hideSettingsMenu() {
        settingsIcon.click();
    }

    public void showClosedCaptions() {
        log.info("Enabling Closed Captions");
        if (closedCaptionsIcon.isDisplayed()) {
            closedCaptionsIcon.click();
        } else {
            log.info("Closed Captions is not displayed. Waiting for the icon to be clickable");
            elementWait.until(ExpectedConditions.visibilityOf(closedCaptionsIcon));
            closedCaptionsIcon.click();
        }
    }

    public void hideClosedCaptions() {
        closedCaptionsIcon.click();
    }

    public void selectSmallFontSize() {
        log.info("Select Small Font Size");
        if (ccFontSize.isDisplayed()) {
            ccFontSize.click();
        } else {
            elementWait.until(ExpectedConditions.visibilityOf(ccFontSize));
            ccFontSize.click();
        }
        if (ccSmallFontSize.isDisplayed()) {
            ccSmallFontSize.click();
        } else {
            elementWait.until(ExpectedConditions.visibilityOf(ccSmallFontSize));
            ccSmallFontSize.click();
        }
        if (settingsFontSizeBackButton.isDisplayed()) {
            settingsFontSizeBackButton.click();
        } else {
            elementWait.until(ExpectedConditions.visibilityOf(ccSmallFontSize));
            settingsIcon.click();
        }
    }

    public void selectRedColor() {
        log.info("Click on Font default color");
        elementWait.until(ExpectedConditions.visibilityOf(ccFontColor));
        ccFontColor.click();
        log.info("Select Font Red color");
        elementWait.until(ExpectedConditions.visibilityOf(ccFontColorRed));
        ccFontColorRed.click();
        settingsFontColorBackButton.click();
    }

    public int scrubbedTime;

    public int getScrubbedTime() {
        return scrubbedTime;
    }

    public void setScrubbedTime(int scrubbedTime) {
        this.scrubbedTime = scrubbedTime;
    }

    public void scrubToNextSegment() {

        if (!cuePoints.getCssValue("display").equals("none")) {
            elementWait.until(ExpectedConditions.visibilityOf(firstCuePoint));
            log.info("CuePoints are found. Scrubbing to the second segment...");

            Double doubleValueOfCuePoint =
                    new Double(
                            Double.parseDouble(firstCuePoint.getCssValue("left").replaceAll("[^0-9.]", "")));
            int xScrubber = doubleValueOfCuePoint.intValue();
            int initialScrubberLocation = scrubber.getLocation().x;

            action.dragAndDropBy(scrubber, xScrubber + 10, 0).release().perform();
            crossSegmentScrubWait.until(ExpectedConditions.visibilityOf(firstCuePoint));

            int afterScrubScrubberLocation = scrubber.getLocation().x;

            setScrubbedTime(
                    getTimeOfElementInSeconds(playbackDuration)
                            * (afterScrubScrubberLocation - initialScrubberLocation)
                            / (progressBar.getSize().width));
        } else {
            log.info(
                    "Cue points are not found. This is not a Full Episode or Seamless mode is enabled. Scrubbing into the middle");
            int initialScrubberLocation = scrubber.getLocation().x;
            action
                    .dragAndDropBy(scrubber, (progressBar.getSize().width - scrubber.getLocation().x) / 2, 0)
                    .release()
                    .perform();
            int afterScrubScrubberLocation = scrubber.getLocation().x;

            setScrubbedTime(
                    getTimeOfElementInSeconds(playbackDuration)
                            * (afterScrubScrubberLocation - initialScrubberLocation)
                            / (progressBar.getSize().width));
        }
    }

    public static int getTimeOfElementInSeconds(WebElement elementName) {
        elementWait.until(ExpectedConditions.visibilityOf(elementName));
        String[] parts = elementName.getText().split(":");
        int playbackDurationInSeconds = Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
        return playbackDurationInSeconds;
    }

    public void waitForSpinnerDisappear() {
        if (spinner.isDisplayed()) {
            log.info("Waiting for spinner disappearing...");
            pageLoadWait.until(ExpectedConditions.not(ExpectedConditions.visibilityOf(spinner)));
        } else {
            log.info("spinner is gone");
        }
    }

    public void waitForPlaybackStart() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        String currentTime = jse.executeScript(
                String.format(
                        ApiCommands.Commands.GET_CURRENT_TIME_CMD.getCommandString(),
                        WebPlayerConstants.PLAYERS_ON_PAGE)).toString();
        Double startTime = Double.valueOf(currentTime);
        Thread tread = new Thread();
        try {
            tread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        currentTime = jse.executeScript(
                String.format(
                        ApiCommands.Commands.GET_CURRENT_TIME_CMD.getCommandString(),
                        WebPlayerConstants.PLAYERS_ON_PAGE)).toString();
        Double timeAfterWait = Double.valueOf(currentTime);
        if (timeAfterWait <= startTime) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            log.info("Playback has started");
        }
    }

    public static void checkAdPlayback() {
        if (adGui.isDisplayed()) {
            if (adGuiMetadata.getText().isEmpty() || !adGuiMetadata.getText()
                    .contains("YOUR CONTENT WILL RESUME SHORTLY")) {
                log.info("No pre-roll or mid-roll ads");

            } else {
                //adPlaybackWait.until(ExpectedConditions.textToBePresentInElement(adGuiMetadata, "AD 1 OF 2 - YOUR"));
                log.info("Ad has started, waiting for ad to finish");
                adPlaybackWait.until(ExpectedConditions.not(ExpectedConditions.visibilityOf(adGui)));
                log.info("Ad is finished");
            }
        } else {
            log.info("No pre-roll or mid-roll ads");
        }
    }

    public static void pointMouseOverAdGui() {
        action.clickAndHold(adGui).build().perform();
    }

}


