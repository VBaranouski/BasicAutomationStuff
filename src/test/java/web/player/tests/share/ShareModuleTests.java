package web.player.tests.share;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import web.player.constants.ContentTypes;
import web.player.core.Elements;
import web.player.tests.WebPlayerBaseTest;

public class ShareModuleTests extends WebPlayerBaseTest {

    @Test(enabled = false)
    public void shareIconDisplayCheck() {


        baseWebPage.openTestRigPage(driver, ContentTypes.ContentType.CLIP);
        // suppose it will work without parameter driver
        wait.until(ExpectedConditions.visibilityOf(Elements.progressBar));
        playerAction.openFullScreen();
        wait.until(ExpectedConditions.visibilityOf(Elements.shareIcon));

        // usually we use FluentWait class for development all waiters,
        // please learn it
        // https://seleniumhq.github.io/selenium/docs/api/java/org/openqa/selenium/support/ui/FluentWait.html

        playerAction.exitFullScreen();
        Assert.assertFalse(Elements.shareIcon.isDisplayed());


    }

}
