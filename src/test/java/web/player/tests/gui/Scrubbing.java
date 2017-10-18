package web.player.tests.gui;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import web.player.constants.ContentTypes;
import web.player.tests.WebPlayerBaseTest;

import static web.player.core.BaseWebPage.*;
import static web.player.core.BaseWebPage.currentPlaybackTime;
import static web.player.core.BaseWebPage.progressBar;

public class Scrubbing extends WebPlayerBaseTest {

    @Test(enabled = false)
    public void scrubInFE() {
        baseWebPage.openTestRigPage(ContentTypes.ContentType.FULL_EPISODE);
        pageLoadWait.until(ExpectedConditions.visibilityOf(progressBar));
        playerAction.scrubToNextSegment();
        playerAction.waitForSpinnerDisappear();
        Assert.assertEquals(playerAction.getScrubbedTime(), getTimeOfElementInSeconds(currentPlaybackTime), 20,
                "Scrubbed and actual playback time doesn't match. Difference is more than 10 seconds:");
    }

    @Test(enabled = false)
    public void scrubInClip() {
        baseWebPage.openTestRigPage(ContentTypes.ContentType.CLIP);
        pageLoadWait.until(ExpectedConditions.visibilityOf(progressBar));
        playerAction.scrubToNextSegment();
        playerAction.waitForSpinnerDisappear();
        Assert.assertEquals(playerAction.getScrubbedTime(), getTimeOfElementInSeconds(currentPlaybackTime), 10,
                "Scrubbed and actual playback time doesn't match. Difference is more than 20 seconds:");
    }

    @Test(enabled = false)
    public void scrubbingInFullScreenFE() {
        baseWebPage.openTestRigPage(ContentTypes.ContentType.FULL_EPISODE);
        pageLoadWait.until(ExpectedConditions.visibilityOf(progressBar));
        playerAction.openFullScreen();
        playerAction.scrubToNextSegment();
        playerAction.waitForSpinnerDisappear();
        Assert.assertEquals(playerAction.getScrubbedTime(), getTimeOfElementInSeconds(currentPlaybackTime), 20,
                "Scrubbed and actual playback time doesn't match. Difference is more than 20 seconds:");
    }

    @Test(enabled = false)
    public void scrubbingInFullScreenClip() {
        baseWebPage.openTestRigPage(ContentTypes.ContentType.FULL_EPISODE);
        pageLoadWait.until(ExpectedConditions.visibilityOf(progressBar));
        playerAction.waitForSpinnerDisappear();
        playerAction.openFullScreen();
        playerAction.scrubToNextSegment();
        Assert.assertEquals(playerAction.getScrubbedTime(), getTimeOfElementInSeconds(currentPlaybackTime), 10,
                "Scrubbed and actual playback time doesn't match. Difference is more than 10 seconds:");
    }

}
