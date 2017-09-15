package web.player.tests.gui;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import web.player.constants.ContentTypes;
import web.player.core.BaseWebPage;
import web.player.tests.WebPlayerBaseTest;

public class GuiTests extends WebPlayerBaseTest {


    @Test(enabled = false)
    public void pauseAndPlayCheck() {
        baseWebPage.openTestRigPage(ContentTypes.ContentType.CLIP);
        wait.until(ExpectedConditions.elementToBeClickable(BaseWebPage.progressBar));
        wait.until(ExpectedConditions.textToBePresentInElement(BaseWebPage.currentPlaybackTime, "00:03"));
        playerAction.pausePlayback();
        Assert.assertEquals(BaseWebPage.currentPlaybackTime.getText(), "00:03");
        playerAction.resumePlayback();
        wait.until(ExpectedConditions.textToBePresentInElement(BaseWebPage.currentPlaybackTime, "00:05"));
        Assert.assertEquals(BaseWebPage.currentPlaybackTime.getText(), "00:05");
    }


    @Test(enabled = false)
    public void volumeCheck() {
        baseWebPage.openTestRigPage(ContentTypes.ContentType.CLIP);
        wait.until(ExpectedConditions.visibilityOf(BaseWebPage.progressBar));
        Assert.assertTrue(BaseWebPage.volumeIcon.isDisplayed());
        playerAction.mutePlayback();
        playerAction.unmutePlayback();
        wait.until(ExpectedConditions.textToBePresentInElement(BaseWebPage.currentPlaybackTime, "00:03"));
    }


    @Test(enabled = false)
    public void fullScreenTest() {
        baseWebPage.openTestRigPage(ContentTypes.ContentType.CLIP);
        wait.until(ExpectedConditions.visibilityOf(BaseWebPage.progressBar));
        wait.until(ExpectedConditions.textToBePresentInElement(BaseWebPage.currentPlaybackTime, "00:01"));
        playerAction.openFullScreen();
        wait.until(ExpectedConditions.visibilityOf(BaseWebPage.titleMetadata));
        Assert.assertTrue(BaseWebPage.titleMetadata.isDisplayed());
        playerAction.exitFullScreen();
        Assert.assertFalse(BaseWebPage.titleMetadata.isDisplayed());
    }

    @Test(enabled = false)
    public void fullScreenTestS() {
        baseWebPage.openTestRigPage(ContentTypes.ContentType.CLIP);
        wait.until(ExpectedConditions.visibilityOf(BaseWebPage.progressBar));
        wait.until(ExpectedConditions.textToBePresentInElement(BaseWebPage.currentPlaybackTime, "00:01"));
        playerAction.openFullScreen();
        wait.until(ExpectedConditions.visibilityOf(BaseWebPage.titleMetadata));
        Assert.assertTrue(BaseWebPage.titleMetadata.isDisplayed());
        playerAction.exitFullScreen();
        Assert.assertFalse(BaseWebPage.titleMetadata.isDisplayed());
    }



}
