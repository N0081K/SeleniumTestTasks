package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * my representation https://www.t-mobile.cz/podpora/obratte-se-na-nas
 * just some elements located, but all I need
 */
public class TMobileContactUsHomePage extends PageObjectModelAbstract{
    public TMobileContactUsHomePage(WebDriver driver,WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy(how = How.LINK_TEXT, using = "Kontaktní formulář")
    private WebElement contactForm;
    @FindBy(how = How.LINK_TEXT, using = "Objednejte si hovor")
    private WebElement orderCall;

    /**
     * method that navigates us to Contact form
     * @return new page that represents Contact form in our POM
     */
    public TMobileContactUsFormPage GoToContactFormPage(){
        contactForm.click();
        return new TMobileContactUsFormPage(driver,wait);
    }
}
