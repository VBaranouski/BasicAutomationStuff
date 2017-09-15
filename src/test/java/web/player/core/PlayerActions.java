package web.player.core;

import org.openqa.selenium.WebDriver;

public class PlayerActions extends BaseWebPage {

    // GUI

    public PlayerActions(WebDriver driver) {
        super(driver);
    }

    public void pausePlayback() {
        Elements.playButton.click();
    }

    public void resumePlayback() {
        Elements.pauseButton.click();
    }

    public void openFullScreen(){
        Elements.fullScreenIcon.click();
    }

    public void exitFullScreen(){
        Elements.fullScreenIcon.click();
    }

    public void mutePlayback() { Elements.volumeIcon.click(); }


    // bad structure:
    // 1. all this staff need to move to BaseWebPage
    // 2. rarely we create method with only on line
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
        Elements.volumeIcon.click();
    }

    //AD break

    public void waitForAdBreakfinish(){ }

    // Closed Captions

    public void openSettingsMenu(){ Elements.settingsIcon.click(); }

    public void hideSettingsMenu(){Elements.settingsIcon.click(); }

    public void showClosedCaptions(){Elements.closedCaptionsIcon.click();}

    public void hideClosedCaptions(){Elements.closedCaptionsIcon.click();}

    public void selectSmallFontSize(){
        Elements.ccFontSize.click();
        Elements.ccSmallFontSize.click();
        Elements.settingsFontSizeBackButton.click();
    }

    public void selectRedColor(){
        Elements.ccFontColor.click();
        Elements.ccFontColorRed.click();
        Elements.settingsFontColorBackButton.click();
    }






}
