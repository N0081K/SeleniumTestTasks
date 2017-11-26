import Pages.GoogleHomePage;
import Pages.GoogleSearchResults;
import Pages.TMobileContactUsFormPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Actions {

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



    public void fillInForm(TMobileContactUsFormPage page,
                           String subject,
                           String content,
                           String mail,
                           String phone,
                           String file,
                           Boolean sendCopy){
         page.enterSubject(subject);
         page.enterContent(content);
         page.enterMail(mail);
         page.enterPhoneNumber(phone);
         page.uploadFile(file);
         if(sendCopy){
             sendCopy(page);
         }
    }

    private void sendCopy(TMobileContactUsFormPage page){
        page.clickSendCopy();
    }
}
