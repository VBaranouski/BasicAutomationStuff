package web.player.tests.content.types;

import org.testng.annotations.Test;
import web.player.constants.ContentTypes;
import web.player.tests.WebPlayerBaseTest;

public class ContentTypesTests extends WebPlayerBaseTest {

    @Test(enabled = false)
    public void openTestRigWithClip() {
        baseWebPage.openTestRigPage(ContentTypes.ContentType.CLIP);
    }

    @Test(enabled = false)
    public void openTestRigWithFullEpisode() { baseWebPage.openTestRigPage(ContentTypes.ContentType.FULL_EPISODE); }

    @Test(enabled = false)
    public void openTestRigWithLive() { baseWebPage.openTestRigPage(ContentTypes.ContentType.LIVE); }

}
