import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class AppTest {




    @Test (enabled = true)
    public void testFirefoxRun() {
        System.setProperty("webdriver.gecko.driver", "/Users/Vlad/Documents/Automation/geckodriver");

        //DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        //capabilities.setCapability("marionette",true);
        //capabilities.setCapability("browserName","firefox");
        //capabilities.setCapability("platform", Platform.ANY);

        WebDriver driver = new FirefoxDriver();
        driver.navigate().to("http://www.gmail.com");
        driver.close();

    }


    @Test (enabled = true)
    public void testChromeRun() {


        System.setProperty("webdriver.chrome.driver", "/Users/Vlad/Documents/Automation/chromedriver");
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://www.google.com");
        driver.close();
    }

}
