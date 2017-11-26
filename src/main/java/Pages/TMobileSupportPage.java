package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * my implementation of https://www.t-mobile.cz/podpora page
 * just one element located, but enough for my usage
 */
public class TMobileSupportPage extends PageObjectModelAbstract{

    public TMobileSupportPage(WebDriver driver,WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "Obraťte se na")
    private WebElement contactUs;

    /**
     * redirects to https://www.t-mobile.cz/podpora/obratte-se-na-nas implemented in TMobileContactUsHomePage
     * @return t mobile contact us home page from our POM
     */
    public TMobileContactUsHomePage goToContactUs(){
        contactUs.click();
        return new TMobileContactUsHomePage(driver, wait);
    }

}
