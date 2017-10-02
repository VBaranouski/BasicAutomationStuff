package web.player.tests;

import com.expedia.automation.driver.DriverTypes;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import web.player.core.BaseWebPage;

import static com.expedia.automation.driver.DriverFactory.getInstance;

public class WebPlayerBaseTest {

    protected WebDriver driver;
    protected BaseWebPage baseWebPage;
    protected BaseWebPage playerAction;
    public static Actions scrubAction;
    public static Wait elementWait;
    public static Wait pageLoadWait;
    public static Wait crossSegmentScrubWait;
    public JavascriptExecutor jse;




    @BeforeMethod
    public WebDriver createDriver(){
        driver = getInstance(driver, DriverTypes.DriverType.MOB_PROXY);
        return driver;
    }

    @BeforeMethod
    public void createObjects(){
        //wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS).pollingEvery(1, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
        elementWait = new WebDriverWait(driver, 5);
        pageLoadWait = new WebDriverWait(driver, 30);
        crossSegmentScrubWait = new WebDriverWait(driver, 150);
        baseWebPage = new BaseWebPage(driver);
        playerAction = new BaseWebPage(driver);
        scrubAction = new Actions(driver);
        jse = (JavascriptExecutor)driver;
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
        driver = null;
    }
}
