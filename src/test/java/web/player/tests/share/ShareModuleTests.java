package web.player.tests.share;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import web.player.constants.ContentTypes;
import web.player.controls.Elements;
import web.player.tests.WebPlayerBaseTest;

public class ShareModuleTests extends WebPlayerBaseTest {

    @Test(enabled = false)
    public void shareIconDisplayCheck() {
        baseWebPage.openTestRigPage(driver, ContentTypes.ContentType.CLIP);
        wait.until(ExpectedConditions.visibilityOf(Elements.progressBar));
        playerAction.openFullScreen();
        wait.until(ExpectedConditions.visibilityOf(Elements.shareIcon));
        playerAction.exitFullScreen();
        Assert.assertFalse(Elements.shareIcon.isDisplayed());
    }

}
