import Pages.GoogleHomePage;
import Pages.GoogleSearchResults;
import Pages.TMobileContactUsFormPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * this is place where you can add more complex actions
 * I have here just 2 big actions, one that navigates our to https://www.t-mobile.cz/podpora/kontaktujte-nas
 * just using google and links on web pages
 * and filling form on this page
 */
public class Actions {


    /**
     * this method clicks through pages from google to form on t-mobile page
     * @param driver our desired webdriver chrome, gecko,...
     * @param wait our desired wait
     * @return form page from our POM
     */
    public TMobileContactUsFormPage goToFormByGoogle(WebDriver driver, WebDriverWait wait){
        driver.navigate().to(Config.googleURL);
        GoogleHomePage googleHP = new GoogleHomePage(driver,wait);
        GoogleSearchResults googleResult = googleHP.search(Config.searchQueryTmobile);
        return googleResult.
                goToTMobileHP().
                goToSupportPage().
                goToContactUs().
                GoToContactFormPage();
    }


    /**
     * fills the form on page
     * @param page page with form
     * @param subject desired subject
     * @param content desired content
     * @param mail our mail address
     * @param phone our phone
     * @param file  path to attachment
     * @param sendCopy send copy to our mail address
     */
    public void fillInForm(TMobileContactUsFormPage page,
                           String subject,
                           String content,
                           String mail,
                           String phone,
                           String file,
                           Boolean sendCopy){
        if(sendCopy){
            page.clickSendCopy();
        }
         page.enterSubject(subject);
         page.enterContent(content);
         page.enterMail(mail);
         page.enterPhoneNumber(phone);
         page.uploadFile(file);
    }


}
