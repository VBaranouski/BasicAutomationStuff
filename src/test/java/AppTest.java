import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class AppTest {




    @Test (enabled = false)
    public void testFirefoxRun() {
        System.setProperty("webdriver.gecko.driver", "/Users/Vlad/Documents/Automation/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.navigate().to("http://www.gmail.com");
        driver.close();

    }


    @Test (enabled = true)
    public void testChromeRun() {
        System.setProperty("webdriver.chrome.driver", "/Users/Vlad/Documents/Automation/chromedriver");
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://www.google.com");
        WebElement searchField = driver.findElement(By.id("lst-ib"));
        searchField.sendKeys("Hello");
        WebElement searchButton = driver.findElement(By.name("btnK"));
        searchButton.click();


        //driver.close();
    }

}
