package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

import static org.testng.Assert.*;

public class TMobileContactUsFormPageTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private TMobileContactUsFormPage formPage;

    @BeforeMethod
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
        driver.navigate().to("https://www.t-mobile.cz/podpora/kontaktujte-nas");
       formPage = new TMobileContactUsFormPage(driver,wait);
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }
    @Test
    public void testEnterSubject() throws Exception {
        String testText = "Testovaci Text";
        formPage.enterSubject(testText);
        String actualText = driver.findElement(By.name("subject")).getAttribute("value");
        assertEquals(actualText,testText);
    }

    @Test
    public void testEnterContent() throws Exception {
        String testText = "Testovaci Text";
        formPage.enterContent(testText);
        String actualText = driver.findElement(By.name("content")).getAttribute("value");
        assertEquals(actualText,testText);
    }

    @Test
    public void testEnterPhoneNumber() throws Exception {
        String phone = "723456789";
        formPage.enterPhoneNumber(phone);
        String actualPhone = driver.findElement(By.name("phoneNumber")).getAttribute("value");
        assertEquals(actualPhone,phone);
    }

    @Test
    public void testEnterMail() throws Exception {
        String mail = "example@address.com";
        formPage.enterMail(mail);
        String actualMail = driver.findElement(By.name("email")).getAttribute("value");
        assertEquals(actualMail,mail);
    }



    @Test
    public void testUploadFile() throws Exception {
        String path = new File(".idea/misc.xml").getCanonicalPath();
        formPage.uploadFile(path);
        String actualName = driver.
                findElement(By.cssSelector("#_ContactFormPortlet_WAR_ibaczfaqportletportlet_INSTANCE_KlFUaBS7XQQa_uploaderContent > input[type=\"file\"]")).
                getAttribute("value");
        assertTrue(path.contains(actualName));
    }

}