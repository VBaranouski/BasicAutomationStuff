package web.player.tests.closed.captions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import web.player.constants.ContentTypes;
import web.player.constants.WebPlayerConstants;
import web.player.core.Elements;
import web.player.tests.WebPlayerBaseTest;

public class ClosedCaptioning extends WebPlayerBaseTest {

    @Test(enabled = false, priority = 1)
    public void ccIconDisplayCheck() {
        baseWebPage.openTestRigPage(driver, ContentTypes.ContentType.FULL_EPISODE);
        wait.until(ExpectedConditions.visibilityOf(Elements.progressBar));
        Assert.assertTrue(Elements.closedCaptionsIcon.isDisplayed());
        Assert.assertTrue(Elements.settingsIcon.isDisplayed());
    }


    @Test(enabled = false, priority = 2, dependsOnMethods = "ccIconCheck")
    public void ccOnOffCheck() {
        baseWebPage.openTestRigPage(driver, ContentTypes.ContentType.FULL_EPISODE);
        wait.until(ExpectedConditions.visibilityOf(Elements.closedCaptionsIcon));
        playerAction.showClosedCaptions();
        wait.until(ExpectedConditions.textToBePresentInElement(Elements.currentPlaybackTime, "00:01"));
        Assert.assertTrue(Elements.ccContainer.isDisplayed());
        playerAction.hideClosedCaptions();
        Assert.assertFalse(Elements.ccContainer.isDisplayed());
    }


    @Test(enabled = false, priority = 2)
    public void ccTextCheck() {
        baseWebPage.openTestRigPage(driver, ContentTypes.ContentType.FULL_EPISODE);
        wait.until(ExpectedConditions.visibilityOf(Elements.closedCaptionsIcon));
        playerAction.showClosedCaptions();
        wait.until(ExpectedConditions.textToBePresentInElement(Elements.currentPlaybackTime, "00:01"));
        Assert.assertEquals(Elements.firstRowCC.getText(), "- MARY JANE: Previously,");
    }


    @Test(enabled = true, priority = 2)
    public void ccDefaultSettingsCheck() {
        baseWebPage.openTestRigPage(driver, ContentTypes.ContentType.FULL_EPISODE);
        wait.until(ExpectedConditions.visibilityOf(Elements.closedCaptionsIcon));
        playerAction.showClosedCaptions();
        wait.until(ExpectedConditions.textToBePresentInElement(Elements.currentPlaybackTime, "00:01"));
        Assert.assertEquals(Elements.firstRowCC.getCssValue("color"), WebPlayerConstants.CC_DEFAULT_COLOR);
        Assert.assertEquals(Elements.firstRowCC.getCssValue("font-family"), WebPlayerConstants.CC_DEFAULT_FONT_FAMILY);
        Assert.assertEquals(Elements.firstRowCC.getCssValue("font-size"), WebPlayerConstants.CC_DEFAULT_FONT_SIZE);
        Assert.assertEquals(Elements.firstRowCC.getCssValue("background-color"), WebPlayerConstants.CC_DEFAULT_BACKGROUND_COLOR);
        playerAction.hideClosedCaptions();
    }


    @Test(enabled = false, priority = 2)
    public void ccSettingsMenuCheck() {
        baseWebPage.openTestRigPage(driver, ContentTypes.ContentType.FULL_EPISODE);
        wait.until(ExpectedConditions.visibilityOf(Elements.settingsIcon));
        playerAction.openSettingsMenu();
        Assert.assertTrue(Elements.settingsPopup.isDisplayed());
        playerAction.hideSettingsMenu();
        Assert.assertFalse(Elements.settingsPopup.isDisplayed());
    }


    @Test(enabled = true, priority = 2)
    public void ccSettingsChangeCheck() {
        baseWebPage.openTestRigPage(driver, ContentTypes.ContentType.FULL_EPISODE);
        wait.until(ExpectedConditions.visibilityOf(Elements.settingsIcon));
        playerAction.showClosedCaptions();
        playerAction.openSettingsMenu();
        playerAction.selectSmallFontSize();
        Assert.assertEquals(Elements.firstRowCC.getCssValue("font-size"), WebPlayerConstants.CC_SMALL_FONT_SIZE);
        playerAction.selectRedColor();
        Assert.assertEquals(Elements.firstRowCC.getCssValue("color"), WebPlayerConstants.CC_RED_COLOR);

    }
}