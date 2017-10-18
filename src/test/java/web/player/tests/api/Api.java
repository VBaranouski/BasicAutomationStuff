package web.player.tests.api;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import web.player.constants.ApiCommands;
import web.player.constants.ContentTypes;
import web.player.constants.WebPlayerConstants;
import web.player.tests.WebPlayerBaseTest;

import static web.player.core.BaseWebPage.*;

public class Api extends WebPlayerBaseTest {

    @Test(enabled = false)
    public void seekAPI() {
        baseWebPage.openTestRigPage(ContentTypes.ContentType.FULL_EPISODE);
        pageLoadWait.until(ExpectedConditions.visibilityOf(progressBar));
        playerAction.waitForSpinnerDisappear();
        playerAction.waitForPlaybackStart();
        jse.executeScript(
                String.format(
                        ApiCommands.Commands.SEEK_VIDEO_CMD_TEMPLATE.getCommandString(),
                        WebPlayerConstants.PLAYERS_ON_PAGE,
                        100));
        playerAction.waitForSpinnerDisappear();
        Assert.assertEquals(
                Double.valueOf(jse.executeScript(
                        String.format(
                                ApiCommands.Commands.GET_CURRENT_TIME_CMD.getCommandString(),
                                WebPlayerConstants.PLAYERS_ON_PAGE,
                                0))
                        .toString()),
                getTimeOfElementInSeconds(currentPlaybackTime), 3,
                "Current playback time and seeked time doesn't match. Delta 3 sec");
    }

    @Test(enabled = false)
    public void crossSegmentScrubAPI() {
        baseWebPage.openTestRigPage(ContentTypes.ContentType.FULL_EPISODE);
        pageLoadWait.until(ExpectedConditions.visibilityOf(progressBar));
        playerAction.waitForSpinnerDisappear();
        playerAction.waitForPlaybackStart();
        jse.executeScript(
                String.format(
                        ApiCommands.Commands.PLAY_SEGMENT_CMD_TEMPLATE.getCommandString(),
                        WebPlayerConstants.PLAYERS_ON_PAGE,
                        1));
        playerAction.waitForSpinnerDisappear();
        Assert.assertEquals(
                Integer.parseInt(jse.executeScript(
                        String.format(
                                ApiCommands.Commands.GET_SEGMENT_DURATION.getCommandString(),
                                WebPlayerConstants.PLAYERS_ON_PAGE,
                                0))
                        .toString()),
                getTimeOfElementInSeconds(currentPlaybackTime), 5,
                "Current Playback time and scrubbed time doesn't match. Delta 5 sec");
    }

    @Test(enabled = false)
    public void VolumeAPI() {
        baseWebPage.openTestRigPage(ContentTypes.ContentType.FULL_EPISODE);
        pageLoadWait.until(ExpectedConditions.visibilityOf(progressBar));
        playerAction.waitForPlaybackStart();
        playerAction.waitForSpinnerDisappear();
        jse.executeScript(
                String.format(
                        ApiCommands.Commands.SET_VOLUME.getCommandString(),
                        WebPlayerConstants.PLAYERS_ON_PAGE,
                        WebPlayerConstants.VOLUME_LEVEL));
        Assert.assertEquals(
                jse.executeScript(
                        String.format(
                                ApiCommands.Commands.GET_CURRENT_VOLUME_CMD.getCommandString(),
                                WebPlayerConstants.PLAYERS_ON_PAGE))
                        .toString(),
                String.valueOf(WebPlayerConstants.VOLUME_LEVEL),
                "Volume levels doesn't match");
    }

    @Test(enabled = false)
    public void adCheck() {
        baseWebPage.openTestRigPage(ContentTypes.ContentType.FULL_EPISODE);
        jse.executeScript(String.format(ApiCommands.Commands.PAUSE_VIDEO_CMD.getCommandString(), WebPlayerConstants.PLAYERS_ON_PAGE));
        //pageLoadWait.until(ExpectedConditions.visibilityOf(progressBar));
        //playerAction.waitForPlaybackStart();
        playerAction.checkAdGuiMetadata();

    }

    @Test (enabled = false)
    public void checkAdCount(){
        baseWebPage.openTestRigPage(ContentTypes.ContentType.FULL_EPISODE);
        System.out.println(
        jse.executeScript(String.format(ApiCommands.Commands.GET_AD_COUNT.getCommandString(),WebPlayerConstants.PLAYERS_ON_PAGE))
        );


    }

}
