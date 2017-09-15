package web.player.tests.closed.captions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import web.player.constants.ContentTypes;
import web.player.constants.WebPlayerConstants;
import web.player.core.BaseWebPage;
import web.player.tests.WebPlayerBaseTest;

public class ClosedCaptioning extends WebPlayerBaseTest {

    @Test(enabled = false, priority = 1)
    public void ccIconDisplayCheck() {
        baseWebPage.openTestRigPage(ContentTypes.ContentType.FULL_EPISODE);
        wait.until(ExpectedConditions.visibilityOf(BaseWebPage.progressBar));
        Assert.assertTrue(BaseWebPage.closedCaptionsIcon.isDisplayed());
        Assert.assertTrue(BaseWebPage.settingsIcon.isDisplayed());
    }


    @Test(enabled = false, priority = 2, dependsOnMethods = "ccIconCheck")
    public void ccOnOffCheck() {
        baseWebPage.openTestRigPage(ContentTypes.ContentType.FULL_EPISODE);
        wait.until(ExpectedConditions.visibilityOf(BaseWebPage.closedCaptionsIcon));
        playerAction.showClosedCaptions();
        wait.until(ExpectedConditions.textToBePresentInElement(BaseWebPage.currentPlaybackTime, "00:01"));
        Assert.assertTrue(BaseWebPage.ccContainer.isDisplayed());
        playerAction.hideClosedCaptions();
        Assert.assertFalse(BaseWebPage.ccContainer.isDisplayed());
    }


    @Test(enabled = false, priority = 2)
    public void ccTextCheck() {
        baseWebPage.openTestRigPage(ContentTypes.ContentType.FULL_EPISODE);
        wait.until(ExpectedConditions.visibilityOf(BaseWebPage.closedCaptionsIcon));
        playerAction.showClosedCaptions();
        wait.until(ExpectedConditions.textToBePresentInElement(BaseWebPage.currentPlaybackTime, "00:01"));
        Assert.assertEquals(BaseWebPage.firstRowCC.getText(), "- MARY JANE: Previously,", "First row of CC doesn't match");
    }


    @Test(enabled = true, priority = 2)
    public void ccDefaultSettingsCheck() {
        baseWebPage.openTestRigPage(ContentTypes.ContentType.FULL_EPISODE);
        wait.until(ExpectedConditions.visibilityOf(BaseWebPage.closedCaptionsIcon));
        playerAction.showClosedCaptions();
        wait.until(ExpectedConditions.textToBePresentInElement(BaseWebPage.currentPlaybackTime, "00:01"));
        Assert.assertEquals(BaseWebPage.firstRowCC.getCssValue("color"), WebPlayerConstants.CC_DEFAULT_COLOR, "Wrong Default Color");
        Assert.assertEquals(BaseWebPage.firstRowCC.getCssValue("font-family"), WebPlayerConstants.CC_DEFAULT_FONT_FAMILY, "Wrong Default Font Family");
        Assert.assertEquals(BaseWebPage.firstRowCC.getCssValue("font-size"), WebPlayerConstants.CC_DEFAULT_FONT_SIZE, "Wrong Default Font Size");
        Assert.assertEquals(BaseWebPage.firstRowCC.getCssValue("background-color"), WebPlayerConstants.CC_DEFAULT_BACKGROUND_COLOR, "Wrong Background Color");

    }


    @Test(enabled = false, priority = 2)
    public void ccSettingsMenuCheck() {
        baseWebPage.openTestRigPage(ContentTypes.ContentType.FULL_EPISODE);
        wait.until(ExpectedConditions.visibilityOf(BaseWebPage.settingsIcon));
        playerAction.openSettingsMenu();
        Assert.assertTrue(BaseWebPage.settingsPopup.isDisplayed());
        playerAction.hideSettingsMenu();
        Assert.assertFalse(BaseWebPage.settingsPopup.isDisplayed());
    }


    @Test(enabled = false, priority = 2)
    public void ccSettingsChangeCheck() {
        baseWebPage.openTestRigPage(ContentTypes.ContentType.FULL_EPISODE);
        wait.until(ExpectedConditions.visibilityOf(BaseWebPage.settingsIcon));
        playerAction.showClosedCaptions();
        playerAction.openSettingsMenu();
        playerAction.selectSmallFontSize();
        Assert.assertEquals(BaseWebPage.firstRowCC.getCssValue("font-size"), WebPlayerConstants.CC_SMALL_FONT_SIZE, "Small size of CC is not selected");
        playerAction.selectRedColor();
        Assert.assertEquals(BaseWebPage.firstRowCC.getCssValue("color"), WebPlayerConstants.CC_RED_COLOR, "Red color is not selected");

    }
}