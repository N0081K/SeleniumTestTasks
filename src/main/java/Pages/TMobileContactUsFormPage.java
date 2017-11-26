package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * my POM implementation of https://www.t-mobile.cz/podpora/kontaktujte-nas page
 * it has tons of javascript
 */

public class TMobileContactUsFormPage extends PageObjectModelAbstract{
    public TMobileContactUsFormPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy(how = How.NAME, using = "subject")
    private WebElement subjectBox;
    @FindBy(how = How.NAME, using = "content")
    private WebElement contentBox;
    @FindBy(how = How.NAME, using = "phoneNumber")
    private WebElement phoneBox;
    @FindBy(how = How.NAME, using = "email")
    private WebElement emailBox;
    @FindBy(how = How.XPATH, using = "//*[contains(@class, 'checkbox')]/label")
    private WebElement sendCopyCheckBox;
    @FindBy(how = How.CSS, using = "#_ContactFormPortlet_WAR_ibaczfaqportletportlet_INSTANCE_KlFUaBS7XQQa_uploaderContent > input[type=\"file\"]")
    private WebElement uploadFileButton;
    @FindBy(how = How.NAME, using = "submit")
    private WebElement submitButton;
    @FindBy(how = How.XPATH, using = "//h1")
    private WebElement header;

    /**
     * enters text into subject Box
     * @param subject for the form
     */
    public void enterSubject(String subject){
        subjectBox.clear();
        subjectBox.sendKeys(subject);
    }

    /**
     * enters text into content Box
     * @param content of our question
     */
    public void enterContent(String content){
        contentBox.clear();
        contentBox.sendKeys(content);
    }

    /**
     * writes phone number into its box
     * @param number our phoneNumber
     */
    public void enterPhoneNumber(String number){
        phoneBox.clear();
        phoneBox.sendKeys(number);
    }

    /**
     * writes mail to its box
     * @param mail contact email
     */
    public void enterMail(String mail){
        emailBox.clear();
        emailBox.sendKeys(mail);
    }

    /**
     * clicks on send copy checkbox
     */
    public void clickSendCopy(){
        Actions actions = new Actions(driver);
        actions.moveToElement(sendCopyCheckBox).click().build().perform(); // the only way how to click it cos button is not clickable normal way
    }

    /**
     * uploads file to website
     * @param absolutePath to the file
     */
    public void uploadFile(String absolutePath) {
        uploadFileButton.sendKeys(absolutePath);
    }

    /**
     * submits the form
     */
    public void sumbit(){
            submitButton.submit();

    }

    /**
     * clicks the header
     * workaround to let validate page content of textboxes
     */
    public void clickHeader(){
        Actions actions = new Actions(driver);
        actions.moveToElement(header).click().build().perform();
    }
}
