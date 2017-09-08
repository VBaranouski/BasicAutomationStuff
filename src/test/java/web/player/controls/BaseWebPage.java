package web.player.controls;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import web.player.constants.ContentTypes;
import web.player.constants.WebPlayerConstants;

public class BaseWebPage {

    public WebDriver driver;

    public BaseWebPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void openTestRigPage (WebDriver driver, ContentTypes.ContentType type){
        switch (type){
            case FULL_EPISODE: driver.get(WebPlayerConstants.FULL_EPIDOSE_URL);
                break;
            case CLIP: driver.get(WebPlayerConstants.CLIP_URL);
                break;
            case LIVE: driver.get(WebPlayerConstants.LIVE);
                break;
        }
    }

}
