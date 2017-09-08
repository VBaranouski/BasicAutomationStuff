package web.player.controls;

import org.openqa.selenium.WebDriver;

public class PlayerActions extends BaseWebPage {

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

    public void unmutePlayback() {
        Elements.volumeIcon.click();
    }

    public void openSettingsMenu(){ Elements.settingsIcon.click(); }

    public void hideSettingsMenu(){Elements.settingsIcon.click(); }

    public void showClosedCaptions(){Elements.closedCaptionsIcon.click();}

    public void hideClosedCaptions(){Elements.closedCaptionsIcon.click();}

    public void waitForAdBreakfinish(){ }

    public void showPlayersGui(){ Elements.playersFrame.submit(); }






}
