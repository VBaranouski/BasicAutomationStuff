package web.player.tests.gui;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import web.player.constants.ContentTypes;
import web.player.controls.Elements;
import web.player.tests.WebPlayerBaseTest;

public class GuiTests extends WebPlayerBaseTest {


    @Test(enabled = false)
    public void pauseAndPlayCheck() {
        baseWebPage.openTestRigPage(driver, ContentTypes.ContentType.CLIP);
        wait.until(ExpectedConditions.elementToBeClickable(Elements.progressBar));
        wait.until(ExpectedConditions.textToBePresentInElement(Elements.currentPlaybackTime, "00:03"));
        playerAction.pausePlayback();
        Assert.assertEquals(Elements.currentPlaybackTime.getText(), "00:03");
        playerAction.resumePlayback();
        wait.until(ExpectedConditions.textToBePresentInElement(Elements.currentPlaybackTime, "00:05"));
        Assert.assertEquals(Elements.currentPlaybackTime.getText(), "00:05");
    }


    @Test(enabled = false)
    public void volumeCheck() {
        baseWebPage.openTestRigPage(driver, ContentTypes.ContentType.CLIP);
        wait.until(ExpectedConditions.visibilityOf(Elements.progressBar));
        Assert.assertTrue(Elements.volumeIcon.isDisplayed());
        playerAction.mutePlayback();
        playerAction.unmutePlayback();
        wait.until(ExpectedConditions.textToBePresentInElement(Elements.currentPlaybackTime, "00:03"));
    }


    @Test(enabled = false)
    public void fullScreenTest() {
        baseWebPage.openTestRigPage(driver, ContentTypes.ContentType.CLIP);
        wait.until(ExpectedConditions.visibilityOf(Elements.progressBar));
        wait.until(ExpectedConditions.textToBePresentInElement(Elements.currentPlaybackTime, "00:01"));
        playerAction.openFullScreen();
        wait.until(ExpectedConditions.visibilityOf(Elements.titleMetadata));
        Assert.assertTrue(Elements.titleMetadata.isDisplayed());
        playerAction.exitFullScreen();
        Assert.assertFalse(Elements.titleMetadata.isDisplayed());
    }

    @Test(enabled = false)
    public void fullScreenTestS() {
        baseWebPage.openTestRigPage(driver, ContentTypes.ContentType.CLIP);
        wait.until(ExpectedConditions.visibilityOf(Elements.progressBar));
        wait.until(ExpectedConditions.textToBePresentInElement(Elements.currentPlaybackTime, "00:01"));
        playerAction.openFullScreen();
        wait.until(ExpectedConditions.visibilityOf(Elements.titleMetadata));
        Assert.assertTrue(Elements.titleMetadata.isDisplayed());
        playerAction.exitFullScreen();
        Assert.assertFalse(Elements.titleMetadata.isDisplayed());
    }



}
