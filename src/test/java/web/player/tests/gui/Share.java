package web.player.tests.gui;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import web.player.constants.ContentTypes;
import web.player.tests.WebPlayerBaseTest;

import static web.player.core.BaseWebPage.progressBar;
import static web.player.core.BaseWebPage.shareIcon;

public class Share extends WebPlayerBaseTest {

    @Test(enabled = false)
    public void shareIconDisplayCheck() {

        baseWebPage.openTestRigPage(ContentTypes.ContentType.CLIP);
        elementWait.until(ExpectedConditions.visibilityOf(progressBar));
        playerAction.openFullScreen();
        elementWait.until(ExpectedConditions.visibilityOf(shareIcon));
        playerAction.exitFullScreen();
        Assert.assertFalse(shareIcon.isDisplayed());


    }

}
