package web.player.tests;

import com.expedia.automation.driver.BrowserMobProxy;
import org.testng.annotations.Test;

public class proxyTests extends WebPlayerBaseTest{

    @Test(enabled = false)
    public void mobProxy() {
        BrowserMobProxy.getRequestList();


    }
}
