
package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * class that interprets google homepage
 * feel free to add i am feeling lucky or other buttons you need, I need just this
 */
public class GoogleHomePage extends PageObjectModelAbstract {

    public GoogleHomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy(how = How.ID, using ="lst-ib")
    private WebElement inputSearchBox;


    /**
     * search with google
     * @param text Search query
     */
    public GoogleSearchResults search(String text) {
        inputSearchBox.clear();
        inputSearchBox.sendKeys(text);
        inputSearchBox.sendKeys(Keys.RETURN);
        return new GoogleSearchResults(driver,wait);
    }



}
