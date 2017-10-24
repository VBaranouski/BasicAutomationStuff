package web.player.tests.ads;

import org.testng.annotations.Test;
import web.player.constants.ContentTypes;
import web.player.tests.WebPlayerBaseTest;

public class Ads extends WebPlayerBaseTest {

    @Test(enabled = false)
    public void adCheck() {
        baseWebPage.openTestRigPage(ContentTypes.ContentType.FULL_EPISODE);
        playerAction.checkAdPlayback();
        playerAction.waitForPlaybackStart();
    }
}
