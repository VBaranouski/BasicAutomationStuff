package web.player.core.proxy;

import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.HarEntry;
import net.lightbody.bmp.proxy.CaptureType;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import web.player.core.driver.DriverFactory;

import java.util.List;

public class BrowserMobProxy extends DriverFactory {

    public BrowserMobProxy(WebDriver driver) {
        super(driver);
    }

    public static String getResponse() {
        return response;
    }

    public static void setResponse(String response) {
        BrowserMobProxy.response = response;
    }

    public static String response;

    private static final String CHROME_DRIVER = "webdriver.chrome.driver";
    private static final String CHROME_DRIVER_PATH = "/Users/Vlad/Documents/Automation/chromedriver";

    public static WebDriver createMobProxy() {

        proxyServer = new BrowserMobProxyServer();
        proxyServer.start(0);
        Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxyServer);
        DesiredCapabilities capability = new DesiredCapabilities();
        capability.setCapability(CapabilityType.PROXY, seleniumProxy);
        System.setProperty(CHROME_DRIVER, CHROME_DRIVER_PATH);
        driver = new ChromeDriver(capability);
        proxyServer.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);
        return driver;
    }

    public static void getPmtResponse() {
        List<HarEntry> harEntries = proxyServer.getHar().getLog().getEntries();
        for (HarEntry entry : harEntries) {
            if (entry
                    .getRequest()
                    .getUrl()
                    .toString()
                    .matches(".*media\\.mtvnservices\\.com\\/pmt\\/e1\\/access\\/index.*")) {
                String response = removeCharacters(entry.getResponse().getContent().getText());
                BrowserMobProxy.setResponse(response);
            }
        }

        driver.quit();
        proxyServer.stop();
    }

    private static String removeCharacters(String response) {
        String temp = response;

        if (response.contains("\n")) {
            temp = StringUtils.remove(temp, "\n");
        }
        if (response.contains("\t")) {
            temp = StringUtils.remove(temp, "\t");
        }
        if (response.contains("\r")) {
            temp = StringUtils.remove(temp, "\r");
        }

        temp = temp.trim();
        return temp;
    }
}
