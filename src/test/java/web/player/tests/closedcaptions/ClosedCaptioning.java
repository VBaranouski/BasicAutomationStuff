package web.player.tests.closedcaptions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import web.player.constants.ContentTypes;
import web.player.controls.Elements;
import web.player.tests.WebPlayerBaseTest;

public class ClosedCaptioning extends WebPlayerBaseTest{

    @Test(enabled = false)
    public void ccIconCheck() {
        baseWebPage.openTestRigPage(driver, ContentTypes.ContentType.FULL_EPISODE);
        wait.until(ExpectedConditions.visibilityOf(Elements.progressBar));
        Assert.assertTrue(Elements.closedCaptionsIcon.isDisplayed());
        Assert.assertTrue(Elements.settingsIcon.isDisplayed());
    }

    @Test(enabled = true)
    public void settingsMenuCheck() {
        baseWebPage.openTestRigPage(driver, ContentTypes.ContentType.FULL_EPISODE);
        wait.until(ExpectedConditions.visibilityOf(Elements.closedCaptionsIcon));
        playerAction.openSettingsMenu();
        Assert.assertTrue(Elements.settingsPopup.isDisplayed());
        playerAction.hideSettingsMenu();
    }

    @Test(enabled = true)
    public void ccCheck() {
        baseWebPage.openTestRigPage(driver, ContentTypes.ContentType.FULL_EPISODE);
        wait.until(ExpectedConditions.visibilityOf(Elements.closedCaptionsIcon));
        playerAction.showClosedCaptions();
        Assert.assertTrue(Elements.ccContainer.isDisplayed());
    }
}
