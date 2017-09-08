package web.player.controls;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Elements extends BaseWebPage {
    public Elements(WebDriver driver) {
        super(driver);
    }

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

    //cc:

    @FindBy (className = "edge-gui-cc-settings")
    public static WebElement settingsPopup;

    @FindBy (className = "edge-cc-container edge-cc-default")
    public static WebElement ccContainer;
}
