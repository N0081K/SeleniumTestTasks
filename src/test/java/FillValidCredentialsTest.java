import Pages.TMobileContactUsFormPage;
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


public class FillValidCredentialsTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void testFillWithValidCredentials(){
        Actions actions = new Actions();
        TMobileContactUsFormPage formPage = actions.goToFormByGoogle(driver,wait);
        actions.fillInForm(formPage,
                Config.CredentialsTMobile.Valid.subject,
                Config.CredentialsTMobile.Valid.text,
                Config.CredentialsTMobile.Valid.mail,
                Config.CredentialsTMobile.Valid.phoneNumber,
                Config.CredentialsTMobile.Valid.file,
                true);

        formPage.sumbit();
        driver.switchTo().alert().accept(); // this is must have here, cos they have bug there with error with fast submiting form, I was able to reproduce it even in blackbox
        WebElement message = driver.findElement(By.className("portlet-msg-success"));
        wait.until(ExpectedConditions.visibilityOf(message));
        assertEquals(message.getText(),Config.LabelsTMobile.successSend);
    }
}
