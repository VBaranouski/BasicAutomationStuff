package web.player.tests.proxyTests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import web.player.constants.ContentTypes;
import web.player.constants.WebPlayerConstants;
import web.player.core.proxy.BrowserMobProxy;
import web.player.tests.WebPlayerBaseTest;

import static web.player.core.BaseWebPage.progressBar;
import static web.player.core.driver.DriverFactory.proxyServer;

public class MediaGenTests extends WebPlayerBaseTest {

    @Test(enabled = false)
    public void mediaGenTests() {
        proxyServer.newHar(WebPlayerConstants.FULL_EPIDOSE_URL);
        baseWebPage.openTestRigPage(ContentTypes.ContentType.FULL_EPISODE);
        pageLoadWait.until(ExpectedConditions.visibilityOf(progressBar));
        playerAction.waitForPlaybackStart();
        web.player.bean.mediagen.Package aPackage = BrowserMobProxy.parseMediaGenResponseBody();
        System.out.println(aPackage.getVideo().getItem().getOrigination_date());
    }
}
