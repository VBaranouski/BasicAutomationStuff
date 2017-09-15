package web.player.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Elements extends BaseWebPage {
    public Elements(WebDriver driver) {
        super(driver);
    }

    //Player Controls

    @FindBy (className = "edge-gui-playback-button")
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

    @FindBy (className = "edge-gui-background")
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

    @FindBy (css = "#video-player > div.edge-gui > div.edge-gui-settings.edge-gui-settings-no-tabs > div.edge-gui-settings-container > div > div.edge-gui-cc-options-container > div.edge-gui-cc-options-button-list > div:nth-child(2) > div.edge-gui-settings-back")
    public static WebElement settingsFontSizeBackButton;

    @FindBy (css = "#video-player > div.edge-gui > div.edge-gui-settings.edge-gui-settings-no-tabs > div.edge-gui-settings-container > div > div.edge-gui-cc-options-container > div.edge-gui-cc-options-button-list > div:nth-child(3) > div.edge-gui-settings-back")
    public static WebElement settingsFontColorBackButton;

    @FindBy (css = "#video-player > div.edge-gui > div.edge-gui-settings.edge-gui-settings-no-tabs > div.edge-gui-settings-container > div > div.edge-gui-cc-options-container > div.edge-gui-cc-options-button-list > div:nth-child(2) > div.edge-gui-cc-expander.edge-gui-cc-expander-label")
    public static WebElement ccFontSize;

    @FindBy (css = "#video-player > div.edge-gui > div.edge-gui-settings.edge-gui-settings-no-tabs > div.edge-gui-settings-container > div > div.edge-gui-cc-options-container > div.edge-gui-cc-options-button-list > div:nth-child(2) > div.edge-gui-font-selectors > div:nth-child(1)")
    public static WebElement ccSmallFontSize;

    @FindBy (css = "#video-player > div.edge-gui > div.edge-gui-settings.edge-gui-settings-no-tabs > div.edge-gui-settings-container > div > div.edge-gui-cc-options-container > div.edge-gui-cc-options-button-list > div:nth-child(3) > div.edge-gui-cc-expander.edge-gui-cc-expander-color")
    public static WebElement ccFontColor;

    @FindBy (css = "#video-player > div.edge-gui > div.edge-gui-settings.edge-gui-settings-no-tabs > div.edge-gui-settings-container > div > div.edge-gui-cc-options-container > div.edge-gui-cc-options-button-list > div:nth-child(3) > div.edge-gui-cc-settings-color-list > div:nth-child(3)")
    public static WebElement ccFontColorRed;


}
