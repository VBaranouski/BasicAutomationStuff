package web.player.tests.api;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import web.player.constants.ApiCommands;
import web.player.constants.ContentTypes;
import web.player.constants.WebPlayerConstants;
import web.player.tests.WebPlayerBaseTest;

import static web.player.core.BaseWebPage.currentPlaybackTime;
import static web.player.core.BaseWebPage.getTimeOfElementInSeconds;
import static web.player.core.BaseWebPage.progressBar;

public class Api extends WebPlayerBaseTest{

    @Test(enabled = true)
    public void seekAPI() {
        baseWebPage.openTestRigPage(ContentTypes.ContentType.FULL_EPISODE);
        pageLoadWait.until(ExpectedConditions.visibilityOf(progressBar));
        jse.executeScript(String.format(ApiCommands.Commands.SEEK_VIDEO_CMD_TEMPLATE.getCommandString(),0,100));
        playerAction.waitForSpinnerDisappear();
        Assert.assertEquals(currentPlaybackTime.getText(), "01:40", "Current playback time and seeked time doesn't match. No delta");
    }


    @Test(enabled = false)
    public void VolumeAPI() {
        baseWebPage.openTestRigPage(ContentTypes.ContentType.FULL_EPISODE);
        pageLoadWait.until(ExpectedConditions.visibilityOf(progressBar));
        playerAction.waitForSpinnerDisappear();
        jse.executeScript(String.format(ApiCommands.Commands.SET_VOLUME.getCommandString(), 0, WebPlayerConstants.VOLUME_LEVEL));
        Assert.assertEquals(jse.executeScript(String.format(ApiCommands.Commands.GET_CURRENT_VOLUME_CMD.getCommandString(),0)).toString(),
                String.valueOf(WebPlayerConstants.VOLUME_LEVEL), "Volume levels doesn't match");

    }

    @Test(enabled = true)
    public void crossSegmentScrubAPI() {
        baseWebPage.openTestRigPage(ContentTypes.ContentType.FULL_EPISODE);
        playerAction.waitForSpinnerDisappear();
        jse.executeScript(String.format(ApiCommands.Commands.PLAY_SEGMENT_CMD_TEMPLATE.getCommandString(),0,1));
        playerAction.waitForSpinnerDisappear();
        Assert.assertEquals(jse.executeScript(String.format(ApiCommands.Commands.GET_SEGMENT_DURATION.getCommandString(), 0, 0)).toString(),
                String.valueOf(getTimeOfElementInSeconds(currentPlaybackTime)), "Current Playback time and scrubbed time doesn't match. No delta");

    }

}
