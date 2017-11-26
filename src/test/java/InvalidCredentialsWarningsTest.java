import Pages.TMobileContactUsFormPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class InvalidCredentialsWarningsTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private TMobileContactUsFormPage formPage;

    @BeforeMethod
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
        driver.navigate().to(Config.formPage);
        formPage = new TMobileContactUsFormPage(driver,wait);
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void testEmptySubject(){
        formPage.enterSubject(Config.CredentialsTMobile.Invalid.empty);
        formPage.clickHeader();
        WebElement alert = driver.findElement(By.xpath("//div[@role = 'alert']"));
        assertEquals(alert.getText(),Config.LabelsTMobile.emptyBox);
    }

    @Test
    public void testEmptyContent(){
        formPage.enterContent(Config.CredentialsTMobile.Invalid.empty);
        formPage.clickHeader();
        WebElement alert = driver.findElement(By.xpath("//div[@role = 'alert']"));
        assertEquals(alert.getText(),Config.LabelsTMobile.emptyBox);
    }

    @Test
    public void testEmptyPhone(){
        formPage.enterPhoneNumber(Config.CredentialsTMobile.Invalid.empty);
        formPage.clickHeader();
        WebElement alert = driver.findElement(By.xpath("//div[@role = 'alert']"));
        assertEquals(alert.getText(),Config.LabelsTMobile.emptyBox);
    }

    @Test
    public void testBadCharactersPhone(){
        formPage.enterPhoneNumber(Config.CredentialsTMobile.Invalid.phoneNumber.invalidCharacters);
        formPage.clickHeader();
        WebElement alert = driver.findElement(By.xpath("//div[@role = 'alert']"));
        assertEquals(alert.getText(),Config.LabelsTMobile.badPhoneFormat);
    }

    @Test
    public void testLettersPhone(){
        formPage.enterPhoneNumber(Config.CredentialsTMobile.Invalid.phoneNumber.letters);
        formPage.clickHeader();
        WebElement alert = driver.findElement(By.xpath("//div[@role = 'alert']"));
        assertEquals(alert.getText(),Config.LabelsTMobile.badPhoneFormat);
    }

    @Test
    public void testEmptyMail(){
        formPage.enterMail(Config.CredentialsTMobile.Invalid.empty);
        formPage.clickHeader();
        WebElement alert = driver.findElement(By.xpath("//div[@role = 'alert']"));
        assertEquals(alert.getText(),Config.LabelsTMobile.emptyBox);
    }
    @Test
    public void testNoAtMail(){
        formPage.enterMail(Config.CredentialsTMobile.Invalid.mail.noAtSign);
        formPage.clickHeader();
        WebElement alert = driver.findElement(By.xpath("//div[@role = 'alert']"));
        assertEquals(alert.getText(),Config.LabelsTMobile.badMailFormat);
    }
    @Test
    public void testNoDotMail(){
        formPage.enterMail(Config.CredentialsTMobile.Invalid.mail.noDotSign);
        formPage.clickHeader();
        WebElement alert = driver.findElement(By.xpath("//div[@role = 'alert']"));
        assertEquals(alert.getText(),Config.LabelsTMobile.badMailFormat);
    }

    @Test
    public void testBadAttachment(){
        formPage.uploadFile(Config.CredentialsTMobile.Invalid.file);
        formPage.clickHeader();
        WebElement alert = driver.findElement(By.xpath("//span[@class = 'text-orange error-message']"));
        assertEquals(alert.getText(),Config.LabelsTMobile.badFileFormat);
    }
}
