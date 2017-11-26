package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class GoogleSearchResultsTest {
    private WebDriver driver;
    private WebDriverWait wait;


    @BeforeMethod
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
        driver.navigate().to("https://www.google.cz/search?q=t-mobile&ie=utf-8");
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void testGoToTMobileHP() throws Exception {
        GoogleSearchResults gResultPage = new GoogleSearchResults(driver,wait);
        gResultPage.goToTMobileHP();
        String tMobileURL = "https://www.t-mobile.cz/osobni";
        String actualURL = driver.getCurrentUrl();
        assertEquals(actualURL,tMobileURL);
    }

}