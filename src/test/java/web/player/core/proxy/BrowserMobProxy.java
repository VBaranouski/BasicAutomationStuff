package web.player.core.proxy;

import com.google.gson.Gson;
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
import web.player.bean.pmt.Pmt;
import web.player.core.driver.DriverFactory;

import java.util.List;

import static web.player.constants.WebPlayerConstants.CHROME_DRIVER;
import static web.player.constants.WebPlayerConstants.CHROME_DRIVER_PATH;

public class BrowserMobProxy extends DriverFactory {

    public BrowserMobProxy(WebDriver driver) {
        super(driver);
    }

    private static String pmtResponse;

    private static String mediaGenResponse;

    public static String getMediaGenResponse() {
        return mediaGenResponse;
    }

    public static void setMediaGenResponse(String mediaGenResponse) {
        BrowserMobProxy.mediaGenResponse = mediaGenResponse;
    }

    public static String getPmtResponse() {
        return pmtResponse;
    }

    public static void setPmtResponse(String response) {
        BrowserMobProxy.pmtResponse = response;
    }

    private static String videoStartTimeRequest;

    public static void setVideoStartTimeRequest(String videoStartTimeRequest) {
        BrowserMobProxy.videoStartTimeRequest = videoStartTimeRequest;
    }

    public static String getVideoStartTimeRequest() {
        return videoStartTimeRequest;
    }

    public static WebDriver createMobProxy() {

        proxyServer = new BrowserMobProxyServer();
        proxyServer.setTrustAllServers(true);

        proxyServer.start(0);
        Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxyServer);
        DesiredCapabilities capability = new DesiredCapabilities();
        capability.setCapability(CapabilityType.PROXY, seleniumProxy);
        System.setProperty(CHROME_DRIVER, CHROME_DRIVER_PATH);
        driver = new ChromeDriver(capability);
        proxyServer.enableHarCaptureTypes(CaptureType.getAllContentCaptureTypes());
        return driver;
    }

    public static void getPmtResponseJson() {
        List<HarEntry> harEntries = proxyServer.getHar().getLog().getEntries();

        for (HarEntry entry : harEntries) {
            if (entry
                    .getRequest()
                    .getUrl()
                    .toString()
                    .matches(".*media\\.mtvnservices\\.com\\/pmt\\/e1\\/access\\/index.*")) {
                pmtResponse = removeCharacters(entry.getResponse().getContent().getText());
                BrowserMobProxy.setPmtResponse(pmtResponse);
            }
        }

        driver.quit();
        proxyServer.stop();
    }

    public static void getVideoStartTimeBeacon() {

        List<HarEntry> harEntries = proxyServer.getHar().getLog().getEntries();

        for (HarEntry entry : harEntries) {
            if (entry
                    .getRequest()
                    .getUrl()
                    .toString()
                    .matches(".*mb.mtvnservices.com\\/data\\/collect\\/v1\\/*.__t=vidperf-dev.__mb_addHeader=true")
            && entry.getRequest().getPostData().getText().contains("videoError")
            )  {
                videoStartTimeRequest = entry.getRequest().getPostData().getText();
                System.out.println(videoStartTimeRequest);

            }
        }

        driver.quit();
        proxyServer.stop();
    }

    public static void getMediaGenResponseJson() {
        List<HarEntry> harEntries = proxyServer.getHar().getLog().getEntries();

        for (HarEntry entry : harEntries) {
            if (entry
                    .getRequest()
                    .getUrl()
                    .toString()
                    .matches(".*media-utils\\.mtvnservices\\.com\\/services\\/MediaGenerator\\/mgid.*")) {

                mediaGenResponse = removeCharacters(entry.getResponse().getContent().getText());
                BrowserMobProxy.setMediaGenResponse(mediaGenResponse);

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

    public static Pmt parsePmtResponseBody() {
        BrowserMobProxy.getPmtResponseJson();
        Gson gson = new Gson();
        Pmt pmt = gson.fromJson(BrowserMobProxy.getPmtResponse(), Pmt.class);
        return pmt;
    }

    public static web.player.bean.mediagen.Package parseMediaGenResponseBody() {
        BrowserMobProxy.getMediaGenResponseJson();
        Gson gson = new Gson();
        web.player.bean.mediagen.Package aPackage = gson
                .fromJson(BrowserMobProxy.getMediaGenResponse(), web.player.bean.mediagen.Package.class);
        return aPackage;
    }


}
