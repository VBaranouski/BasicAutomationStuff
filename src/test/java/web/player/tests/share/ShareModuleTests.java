package web.player.tests.share;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import web.player.constants.ContentTypes;
import web.player.tests.WebPlayerBaseTest;

import static web.player.core.BaseWebPage.progressBar;
import static web.player.core.BaseWebPage.shareIcon;

public class ShareModuleTests extends WebPlayerBaseTest {

    @Test(enabled = false)
    public void shareIconDisplayCheck() {

        baseWebPage.openTestRigPage(ContentTypes.ContentType.CLIP);
        wait.until(ExpectedConditions.visibilityOf(progressBar));
        playerAction.openFullScreen();
        wait.until(ExpectedConditions.visibilityOf(shareIcon));
        playerAction.exitFullScreen();
        Assert.assertFalse(shareIcon.isDisplayed());


    }

}
