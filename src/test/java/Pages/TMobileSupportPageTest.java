package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TMobileSupportPageTest {
    private WebDriver driver;
    private WebDriverWait wait;


    @BeforeMethod
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
        driver.navigate().to("https://www.t-mobile.cz/podpora");
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void testClickContactUs() throws Exception {
        TMobileSupportPage supportPage = new TMobileSupportPage(driver,wait);
        TMobileContactUsHomePage contactUsPage = supportPage.goToContactUs();
        String expectedURL = "https://www.t-mobile.cz/podpora/obratte-se-na-nas";
        String actualURL = driver.getCurrentUrl();
        assertEquals(actualURL,expectedURL);
    }

}