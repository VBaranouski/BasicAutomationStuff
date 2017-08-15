import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AppTest {



    /*
    @Test
    public void testFirefoxRun() {
        System.setProperty("webdriver.gecko.driver", "/Users/Vlad/Documents/Automation/geckodriver");

        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette",true);
        capabilities.setBrowserName("firefox");
        capabilities.setCapability("platform", Platform.ANY);
        WebDriver driver = new FirefoxDriver(capabilities);
        driver.navigate().to("http://www.gmail.com");
        driver.close();

    }

    */
    @Test
    public void testChromeRun() {


        System.setProperty("webdriver.chrome.driver", "/Users/Vlad/Documents/Automation/chromedriver");
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://www.google.com");
        driver.close();
    }

}
