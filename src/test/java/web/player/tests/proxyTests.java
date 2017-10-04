package web.player.tests;

import web.player.core.proxy.BrowserMobProxy;
import com.google.gson.Gson;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import web.player.constants.ContentTypes;
import web.player.constants.WebPlayerConstants;
import web.player.bean.pmt.Pmt;

import static web.player.core.driver.DriverFactory.proxyServer;
import static web.player.core.BaseWebPage.progressBar;

public class proxyTests extends WebPlayerBaseTest{

    @Test(enabled = true)
    public void mobProxy() {
        proxyServer.newHar(WebPlayerConstants.FULL_EPIDOSE_URL);
        baseWebPage.openTestRigPage(ContentTypes.ContentType.FULL_EPISODE);
        pageLoadWait.until(ExpectedConditions.visibilityOf(progressBar));
        BrowserMobProxy.getPmtResponse();
        Gson gson = new Gson();
        Pmt pmt = gson.fromJson(BrowserMobProxy.getResponse(), Pmt.class);
        System.out.println(pmt.getOriginalFeed());
        System.out.println(pmt.getFeed().getTitle());

    }
}
