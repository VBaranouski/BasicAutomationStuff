package web.player.core.driver;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class RemoteDriver extends DriverFactory {

    private RemoteDriver(WebDriver driver) {
        super(driver);
    }

    public static WebDriver createRemoteDriver() {

        Proxy proxy = new Proxy();
        proxy.setHttpProxy("http://localhost" + ":" + "8888");
        DesiredCapabilities capability = DesiredCapabilities.chrome();
        capability.setCapability(CapabilityType.PROXY, proxy);
        try {
            driver = new RemoteWebDriver(new URL("http://localhost:4443//wd/hub"), capability);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    return driver;
    }

}

