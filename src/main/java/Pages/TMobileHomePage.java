package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * my implementation of https://www.t-mobile.cz/osobni page
 * just some of elements added
 */
public class TMobileHomePage extends PageObjectModelAbstract{

    public TMobileHomePage(WebDriver driver,WebDriverWait wait) {
        super(driver, wait);
    }

    /**
     * Feel free to add elements you need, but for my scenarios and cases are these enough
     */
    @FindBy(how = How.XPATH, using ="//*[@id=\"navsecondlel\"]/li[5]/a")
    private WebElement supportButton;
    @FindBy(how = How.XPATH, using = "//*[@id=\"navsecondlel\"]/li[6]/a")
    private WebElement myTMobileButton;

    /**
     * clicks support page button
     * @return t mobile support page from our POM
     */
    public TMobileSupportPage goToSupportPage(){
        supportButton.click();
        return new TMobileSupportPage(driver, wait);
    }

}
