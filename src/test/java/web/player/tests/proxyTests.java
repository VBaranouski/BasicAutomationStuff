package web.player.tests;

import com.expedia.automation.driver.MobProxy;
import org.testng.annotations.Test;

public class proxyTests extends WebPlayerBaseTest{

    @Test(enabled = true)
    public void mobProxy() {
        MobProxy.createHarEntries();

    }
}
