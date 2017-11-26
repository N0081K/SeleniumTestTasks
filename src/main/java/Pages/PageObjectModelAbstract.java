package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * just parent of all of ours pages
 */
public class PageObjectModelAbstract {
    public WebDriver driver;
    public WebDriverWait wait;

    public PageObjectModelAbstract(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }


}
