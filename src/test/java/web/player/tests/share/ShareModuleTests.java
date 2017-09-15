package web.player.tests.share;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import web.player.constants.ContentTypes;
import web.player.core.BaseWebPage;
import web.player.tests.WebPlayerBaseTest;

public class ShareModuleTests extends WebPlayerBaseTest {

    @Test(enabled = false)
    public void shareIconDisplayCheck() {


        baseWebPage.openTestRigPage(ContentTypes.ContentType.CLIP);
        wait.until(ExpectedConditions.visibilityOf(BaseWebPage.progressBar));
        playerAction.openFullScreen();
        wait.until(ExpectedConditions.visibilityOf(BaseWebPage.shareIcon));

        // usually we use FluentWait class for development all waiters,
        // please learn it
        // https://seleniumhq.github.io/selenium/docs/api/java/org/openqa/selenium/support/ui/FluentWait.html

        playerAction.exitFullScreen();
        Assert.assertFalse(BaseWebPage.shareIcon.isDisplayed());


    }

}
