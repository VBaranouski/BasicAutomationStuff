package web.player.tests.proxyTests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import web.player.constants.ContentTypes;
import web.player.constants.WebPlayerConstants;
import web.player.tests.WebPlayerBaseTest;

import static web.player.core.BaseWebPage.progressBar;
import static web.player.core.driver.DriverFactory.proxyServer;

public class PmtTests extends WebPlayerBaseTest {

    @Test(enabled = false)
    public void PMTtests() {
        proxyServer.newHar(WebPlayerConstants.FULL_EPIDOSE_URL);
        baseWebPage.openTestRigPage(ContentTypes.ContentType.FULL_EPISODE);
        pageLoadWait.until(ExpectedConditions.visibilityOf(progressBar));
        playerAction.waitForPlaybackStart();
        web.player.bean.pmt.Pmt pmt = playerAction.parsePmtResponseBody();
        System.out.println(pmt.getOriginalFeed());
        System.out.println(pmt.getFeed().getTitle());
        System.out.println(pmt.getFeed().getItems().get(0).getDuration());
        System.out.println(pmt.getFeed().getItems().get(0).getIsMature());
        System.out.println(pmt.getFeed().getItems().get(0).getGroup().getCategory().getArtist());
        System.out.println(pmt.getFeed().getItems().get(0).getGroup().getCategory().getContentType());

    }


}
