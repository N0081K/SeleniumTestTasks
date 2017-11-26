package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TMobileHomePageTest {
    private WebDriver driver;
    private WebDriverWait wait;


    @BeforeMethod
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
        driver.navigate().to("https://www.t-mobile.cz/osobni");
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }
    @Test
    public void testGoToSupportPage() throws Exception {
        TMobileHomePage homePage = new TMobileHomePage(driver,wait);
        TMobileSupportPage supportPage = homePage.goToSupportPage();
        String exprectedURL = "https://www.t-mobile.cz/podpora";
        String actualURL = driver.getCurrentUrl();
        assertEquals(actualURL,exprectedURL);
    }

}