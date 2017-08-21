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

static WebDriver driver;
private final By searchFieldLocator = By.id("lst-ib");



    @Test (enabled = false)
    public void testFirefoxRun() {
        System.setProperty("webdriver.gecko.driver", "/Users/Vlad/Documents/Automation/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.navigate().to("http://www.gmail.com");
        driver.close();

    }

    @Test (enabled = true)
    public void testChromeRun() {
            driver = createChromeDriver(driver);
            driver.get("http://www.google.com");
            driver.findElement(searchFieldLocator).sendKeys("Hello");
            WebElement searchButton = driver.findElement(By.name("btnK"));
            searchButton.click();
            closeWebBrowser();
    }




    @Test (enabled = false)
    public void testVideoPause() throws InterruptedException {
        driver = createChromeDriver(driver);
        driver.get("http://bit.ly/2sksqvJ");
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(By.className("edge-gui-progress-bar")));
        screenPointer(driver);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        fullScreenClick(driver);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        pausePlay(driver);
        closeWebBrowser();



    }


    public static WebDriver createChromeDriver(WebDriver driver){
        System.setProperty("webdriver.chrome.driver", "/Users/Vlad/Documents/Automation/chromedriver");
        if (driver==null) {
        driver = new ChromeDriver();
        }
        return driver;
    }

    public static void closeWebBrowser(){
        if (null != driver){
            driver.quit();
        }
        driver = null;
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


