package web.player.tests;

import com.expedia.automation.driver.DriverTypes;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import web.player.core.BaseWebPage;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static com.expedia.automation.driver.DriverFactory.getInstance;

public class WebPlayerBaseTest {

    protected WebDriver driver;
    protected BaseWebPage baseWebPage;
    protected BaseWebPage playerAction;
    public static Wait wait;




    @BeforeMethod
    public WebDriver createDriver(){
        driver = getInstance(driver, DriverTypes.DriverType.CHROME);
        return driver;
    }

    @BeforeMethod
    public void createObjects(){
        wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS).pollingEvery(1, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
         //wait = new WebDriverWait(driver, 30);
        baseWebPage = new BaseWebPage(driver);
        playerAction = new BaseWebPage(driver);
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
        driver = null;
    }
}
