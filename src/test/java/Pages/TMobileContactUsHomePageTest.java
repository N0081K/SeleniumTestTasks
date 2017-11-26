package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TMobileContactUsHomePageTest {
    private WebDriver driver;
    private WebDriverWait wait;


    @BeforeMethod
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
        driver.navigate().to("https://www.t-mobile.cz/podpora/obratte-se-na-nas");
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }
    @Test
    public void testGoToContactFormPage() throws Exception {
        TMobileContactUsHomePage contactUsHomePage = new TMobileContactUsHomePage(driver,wait);
        TMobileContactUsFormPage formPage = contactUsHomePage.GoToContactFormPage();
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://www.t-mobile.cz/podpora/kontaktujte-nas";
        assertEquals(actualURL,expectedURL);
    }

}