package com.expedia.automation.driver;

import net.lightbody.bmp.BrowserMobProxyServer;
import org.openqa.selenium.WebDriver;

public class DriverFactory {

    public static WebDriver driver;
    public static BrowserMobProxyServer proxyServer;

    protected DriverFactory(WebDriver driver) {
        this.driver = driver;
    }

    public static synchronized WebDriver getInstance(WebDriver driver, DriverTypes.DriverType type){
        if (driver==null){
            switch (type) {
                case CHROME:
                    driver = Chrome.createChromeDriver();
                    break;
                case FIREFOX:
                    driver = Firefox.createFirefoxDriver();
                    break;
                case REMOTE_DRIVER:
                    driver = RemoteDriver.createRemoteDriver();
                    break;
                case MOB_PROXY:
                    driver = MobProxy.createMobProxy();
                    break;

            }
        }
        return driver;
    }

}


