package web.player.tests.api;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import web.player.constants.ApiCommands;
import web.player.constants.ContentTypes;
import web.player.tests.WebPlayerBaseTest;

import static web.player.core.BaseWebPage.currentPlaybackTime;
import static web.player.core.BaseWebPage.getTimeOfElementInSeconds;
import static web.player.core.BaseWebPage.progressBar;

public class Api extends WebPlayerBaseTest{

    @Test(enabled = false)
    public void seekAPI() {
        baseWebPage.openTestRigPage(ContentTypes.ContentType.FULL_EPISODE);
        pageLoadWait.until(ExpectedConditions.visibilityOf(progressBar));
        jse.executeScript("return EdgePlayer.getPlayer().seek(100)");
        pageLoadWait.until(ExpectedConditions.visibilityOf(currentPlaybackTime));
        Assert.assertEquals(currentPlaybackTime.getText(), "01:30");
    }

    @Test(enabled = false)
    public void playindexAPI() {
        baseWebPage.openTestRigPage(ContentTypes.ContentType.FULL_EPISODE);
        pageLoadWait.until(ExpectedConditions.visibilityOf(progressBar));
        jse.executeScript(String.format("return MTVNPlayer.getPlayers()[%d].volume(%f);", 0, 0.5));

        String embedCode1 = jse.executeScript(String.format("return EdgePlayer.getPlayer().getEmbedCode();")).toString();
        System.out.println(embedCode1);
        elementWait.until(ExpectedConditions.textToBePresentInElement(currentPlaybackTime, "00:10"));

    }

    @Test(enabled = false)
    public void VolumeAPI() {
        baseWebPage.openTestRigPage(ContentTypes.ContentType.FULL_EPISODE);
        pageLoadWait.until(ExpectedConditions.visibilityOf(progressBar));
        playerAction.waitForSpinnerDisappear();
        jse.executeScript(String.format(ApiCommands.Commands.SET_VOLUME.getCommandString(), 0, 1));
        Assert.assertEquals(jse.executeScript(String.format(ApiCommands.Commands.GET_CURRENT_VOLUME_CMD.getCommandString(),0)).toString(), "1");

    }

    @Test(enabled = true)
    public void crossSegmentScrubAPI() {
        baseWebPage.openTestRigPage(ContentTypes.ContentType.FULL_EPISODE);
        playerAction.waitForSpinnerDisappear();
        jse.executeScript(String.format(ApiCommands.Commands.PLAY_SEGMENT_CMD_TEMPLATE.getCommandString(),0,1));
        playerAction.waitForSpinnerDisappear();
        Assert.assertEquals(jse.executeScript(String.format(ApiCommands.Commands.GET_SEGMENT_DURATION.getCommandString(), 0, 0)).toString(),
                String.valueOf(getTimeOfElementInSeconds(currentPlaybackTime)));

    }

}
