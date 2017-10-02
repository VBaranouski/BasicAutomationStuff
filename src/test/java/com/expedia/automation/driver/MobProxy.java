package com.expedia.automation.driver;

import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.core.har.HarEntry;
import net.lightbody.bmp.proxy.CaptureType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import web.player.constants.WebPlayerConstants;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class MobProxy extends DriverFactory {

    private MobProxy(WebDriver driver) {
        super(driver);
    }

    private static final String CHROME_DRIVER = "webdriver.chrome.driver";
    private static final String CHROME_DRIVER_PATH = "/Users/Vlad/Documents/Automation/chromedriver";

    public static WebDriver createMobProxy() {

        proxyServer = new BrowserMobProxyServer();
        proxyServer.start(0);
        int port = proxyServer.getPort();
        System.out.println("Proxy has started at port: " + port);
        Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxyServer);
        DesiredCapabilities capability = new DesiredCapabilities();
        capability.setCapability(CapabilityType.PROXY, seleniumProxy);
        System.setProperty(CHROME_DRIVER, CHROME_DRIVER_PATH);
        driver = new ChromeDriver(capability);
        proxyServer.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);
        proxyServer.newHar(WebPlayerConstants.FULL_EPIDOSE_URL);
        driver.get(WebPlayerConstants.FULL_EPIDOSE_URL);
        return driver;
    }

    public static void createHarEntries() {
        try {

            Har har = proxyServer.getHar();
            File harFile = new File("tesRig.har");
            har.writeTo(harFile);

            List<HarEntry> logEntries = proxyServer.getHar().getLog().getEntries();
            for (HarEntry entry: logEntries)
            {
                System.out.println(entry.getRequest().getUrl());
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        driver.quit();
        proxyServer.stop();
    }
}

