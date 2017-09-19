package web.player.tests.closed.captions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import web.player.constants.ContentTypes;
import web.player.constants.WebPlayerConstants;
import web.player.tests.WebPlayerBaseTest;

import static web.player.core.BaseWebPage.*;

public class ClosedCaptioning extends WebPlayerBaseTest {

    @Test(enabled = false, priority = 1)
    public void ccIconDisplayCheck() {
        baseWebPage.openTestRigPage(ContentTypes.ContentType.FULL_EPISODE);
        pageLoadWait.until(ExpectedConditions.visibilityOf(progressBar));
        Assert.assertTrue(closedCaptionsIcon.isDisplayed());
        Assert.assertTrue(settingsIcon.isDisplayed());
    }


    @Test(enabled = false, priority = 2)
    public void ccOnOffCheck() {
        baseWebPage.openTestRigPage(ContentTypes.ContentType.FULL_EPISODE);
        playerAction.showClosedCaptions();
        pageLoadWait.until(ExpectedConditions.textToBePresentInElement(currentPlaybackTime, "00:01"));
        Assert.assertTrue(ccContainer.isDisplayed());
        playerAction.hideClosedCaptions();
        Assert.assertFalse(ccContainer.isDisplayed());
    }


    @Test(enabled = false, priority = 2)
    public void ccTextCheck() {
        baseWebPage.openTestRigPage(ContentTypes.ContentType.FULL_EPISODE);
        pageLoadWait.until(ExpectedConditions.textToBePresentInElement(currentPlaybackTime, "00:01"));
        playerAction.showClosedCaptions();
        Assert.assertEquals(firstRowCC.getText(), "- MARY JANE: Previously,", "First row of CC doesn't match");
    }


    @Test(enabled = false, priority = 2)
    public void ccDefaultSettingsCheck() {
        baseWebPage.openTestRigPage(ContentTypes.ContentType.FULL_EPISODE);
        playerAction.showClosedCaptions();
        pageLoadWait.until(ExpectedConditions.textToBePresentInElement(currentPlaybackTime, "00:01"));
        Assert.assertEquals(firstRowCC.getCssValue("color"), WebPlayerConstants.CC_DEFAULT_COLOR, "Wrong Default Color");
        Assert.assertEquals(firstRowCC.getCssValue("font-family"), WebPlayerConstants.CC_DEFAULT_FONT_FAMILY, "Wrong Default Font Family");
        Assert.assertEquals(firstRowCC.getCssValue("font-size"), WebPlayerConstants.CC_DEFAULT_FONT_SIZE, "Wrong Default Font Size");
        Assert.assertEquals(firstRowCC.getCssValue("background-color"), WebPlayerConstants.CC_DEFAULT_BACKGROUND_COLOR, "Wrong Background Color");

    }


    @Test(enabled = false, priority = 2)
    public void ccSettingsMenuCheck() {
        baseWebPage.openTestRigPage(ContentTypes.ContentType.FULL_EPISODE);
        pageLoadWait.until(ExpectedConditions.visibilityOf(settingsIcon));
        playerAction.openSettingsMenu();
        Assert.assertTrue(settingsPopup.isDisplayed());
        playerAction.hideSettingsMenu();
        Assert.assertFalse(settingsPopup.isDisplayed());
    }


    @Test(enabled = false, priority = 2)
    public void ccSettingsChangeCheck() {
        baseWebPage.openTestRigPage(ContentTypes.ContentType.FULL_EPISODE);
        pageLoadWait.until(ExpectedConditions.visibilityOf(settingsIcon));
        playerAction.showClosedCaptions();
        playerAction.openSettingsMenu();
        playerAction.selectSmallFontSize();
        elementWait.until(ExpectedConditions.visibilityOf(firstRowCC));
        Assert.assertEquals(firstRowCC.getCssValue("font-size"), WebPlayerConstants.CC_SMALL_FONT_SIZE, "Small size of CC is not applied");
        playerAction.selectRedColor();
        Assert.assertEquals(firstRowCC.getCssValue("color"), WebPlayerConstants.CC_RED_COLOR, "Red color is not applied");

    }
}