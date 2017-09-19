package web.player.tests.gui;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import web.player.constants.ContentTypes;
import web.player.tests.WebPlayerBaseTest;

import static web.player.core.BaseWebPage.*;

public class GuiTests extends WebPlayerBaseTest {


    @Test(enabled = false)
    public void pauseAndPlayCheck() {
        baseWebPage.openTestRigPage(ContentTypes.ContentType.CLIP);
        pageLoadWait.until(ExpectedConditions.visibilityOf(progressBar));
        elementWait.until(ExpectedConditions.textToBePresentInElement(currentPlaybackTime, "00:03"));
        playerAction.pausePlayback();
        Assert.assertEquals(currentPlaybackTime.getText(), "00:03");
        playerAction.resumePlayback();
        //playerAction.tapOnPlayer();
        elementWait.until(ExpectedConditions.textToBePresentInElement(currentPlaybackTime, "00:05"));
        Assert.assertEquals(currentPlaybackTime.getText(), "00:05");
    }


    @Test(enabled = false)
    public void volumeCheck() {
        baseWebPage.openTestRigPage(ContentTypes.ContentType.CLIP);
        pageLoadWait.until(ExpectedConditions.visibilityOf(progressBar));
        Assert.assertTrue(volumeIcon.isDisplayed(), "Volume icon is not visible. May be GUI is hidden or isn't loaded");
        playerAction.mutePlayback();
        playerAction.unmutePlayback();
    }


    @Test(enabled = false)
    public void fullScreenTest() {
        baseWebPage.openTestRigPage(ContentTypes.ContentType.CLIP);
        pageLoadWait.until(ExpectedConditions.visibilityOf(progressBar));
        elementWait.until(ExpectedConditions.textToBePresentInElement(currentPlaybackTime, "00:01"));
        playerAction.openFullScreen();
        elementWait.until(ExpectedConditions.visibilityOf(titleMetadata));
        Assert.assertTrue(titleMetadata.isDisplayed());
        playerAction.exitFullScreen();
        Assert.assertFalse(titleMetadata.isDisplayed());
    }


    @Test(enabled = false)
    public void fullScreenTestS() {
        baseWebPage.openTestRigPage(ContentTypes.ContentType.CLIP);
        pageLoadWait.until(ExpectedConditions.visibilityOf(progressBar));
        elementWait.until(ExpectedConditions.textToBePresentInElement(currentPlaybackTime, "00:01"));
        playerAction.openFullScreen();
        elementWait.until(ExpectedConditions.visibilityOf(titleMetadata));
        Assert.assertTrue(titleMetadata.isDisplayed());
        playerAction.exitFullScreen();
        Assert.assertFalse(titleMetadata.isDisplayed());
    }

    @Test(enabled = true)
    public void scrubbingTest(){
        baseWebPage.openTestRigPage(ContentTypes.ContentType.FULL_EPISODE);
        pageLoadWait.until(ExpectedConditions.visibilityOf(progressBar));
        elementWait.until(ExpectedConditions.textToBePresentInElement(currentPlaybackTime, "00:01"));
        //scrubAction.clickAndHold(scrubber);
        //scrubAction.moveToElement(scrubber, 500, 0).release().build().perform();
        scrubAction.dragAndDropBy(scrubber, 200, 0).release().perform();
        elementWait.until(ExpectedConditions.textToBePresentInElement(currentPlaybackTime, "00:10"));

    }


}
