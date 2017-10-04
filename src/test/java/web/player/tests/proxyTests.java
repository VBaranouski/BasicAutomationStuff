package web.player.tests;

import com.expedia.automation.driver.BrowserMobProxy;
import org.testng.annotations.Test;
import web.player.constants.ContentTypes;
import web.player.constants.WebPlayerConstants;
import web.player.pmt.Feed;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import static com.expedia.automation.driver.DriverFactory.proxyServer;

public class proxyTests extends WebPlayerBaseTest{

    @Test(enabled = true)
    public void mobProxy() throws JAXBException {
        proxyServer.newHar(WebPlayerConstants.FULL_EPIDOSE_URL);
        baseWebPage.openTestRigPage(ContentTypes.ContentType.FULL_EPISODE);
        BrowserMobProxy.getPmtResponse();

        JAXBContext jc = JAXBContext.newInstance(Feed.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        BrowserMobProxy bM = new BrowserMobProxy(driver);
        StreamSource json = new StreamSource(bM.getResponse());
        Feed element = unmarshaller.unmarshal(json, Feed.class).getValue();
        System.out.println(element.getTitle().toString());

    }
}
