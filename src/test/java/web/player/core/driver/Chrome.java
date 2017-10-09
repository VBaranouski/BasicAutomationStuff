package web.player.core.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static web.player.constants.WebPlayerConstants.CHROME_DRIVER;
import static web.player.constants.WebPlayerConstants.CHROME_DRIVER_PATH;

public class Chrome extends DriverFactory {

    private Chrome(WebDriver driver) {
        super(driver);
    }

    public static WebDriver createChromeDriver() {

        System.setProperty(CHROME_DRIVER, CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
        return driver;
    }
}
