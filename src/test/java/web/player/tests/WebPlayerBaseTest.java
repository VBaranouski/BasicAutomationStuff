package web.player.tests;

import com.expedia.automation.driver.DriverTypes;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import web.player.controls.PlayerActions;
import web.player.controls.BaseWebPage;
import web.player.controls.Elements;

import static com.expedia.automation.driver.DriverFactory.getInstance;

public class WebPlayerBaseTest {

    protected WebDriver driver;
    protected BaseWebPage baseWebPage;
    protected Elements elements;
    protected WebDriverWait wait;
    protected PlayerActions playerAction;


    @BeforeMethod
    public WebDriver createDriver(){
        driver = getInstance(driver, DriverTypes.DriverType.CHROME);
        return driver;
    }

    @BeforeMethod
    public void createObjects(){
        wait = new WebDriverWait(driver, 50);
        baseWebPage = new BaseWebPage(driver);
        elements = new Elements(driver);
        playerAction = new PlayerActions(driver);
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
        driver = null;
    }
}
