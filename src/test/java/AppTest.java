import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AppTest {

WebDriver driver;



    @Test (enabled = false)
    public void testFirefoxRun() {
        System.setProperty("webdriver.gecko.driver", "/Users/Vlad/Documents/Automation/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.navigate().to("http://www.gmail.com");
        driver.close();

    }


    @Test (enabled = false)
    public void testChromeRun() {
        System.setProperty("webdriver.chrome.driver", "/Users/Vlad/Documents/Automation/chromedriver");
        ChromeDriver driver = new ChromeDriver();
            driver.get("http://www.google.com");
            WebElement searchField = driver.findElement(By.id("lst-ib"));
            searchField.sendKeys("Hello");
            WebElement searchButton = driver.findElement(By.name("btnK"));
            searchButton.click();


    }

    @Test (enabled = true)
    public void testVideoPause() throws InterruptedException {
        //System.setProperty("webdriver.chrome.driver", "/Users/Vlad/Documents/Automation/chromedriver");
        //ChromeDriver driver = new ChromeDriver();
        driver = createChromeDriver(driver);
        driver.get("http://bit.ly/2sksqvJ");
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(By.className("edge-gui-playback-button")));
        screenPointer(driver);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        fullScreenClick(driver);
        pausePlay(driver);
            driver.close();



    }


    public static WebDriver createChromeDriver(WebDriver driver){
        System.setProperty("webdriver.chrome.driver", "/Users/Vlad/Documents/Automation/chromedriver");
        if (driver==null){
        driver = new ChromeDriver();}
        return driver;
    }



    public static WebDriver pausePlay(WebDriver driver)  {
        WebElement pause = driver.findElement(By.className("edge-gui-playback-button"));

        pause.click();
        return driver;
    }

    public static WebDriver fullScreenClick(WebDriver driver)  {
        WebElement fullScreen = driver.findElement(By.className("edge-gui-fullscreen-button"));
        fullScreen.click();
        return driver;
    }

    public static WebDriver screenPointer(WebDriver driver)  {
        WebElement screenPoint = driver.findElement(By.className("edge-gui"));
        screenPoint.click();
        return driver;
    }

}
