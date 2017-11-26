package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * this class is basic POM of google search results, find right element can be used generally
 * go to T-Mobile Home page is implemented
 */
public class GoogleSearchResults extends PageObjectModelAbstract {



    public GoogleSearchResults(WebDriver driver,WebDriverWait wait) {
        super(driver, wait);
    }

    /**
     * naviagates to t-mobile.cz
     * @return t-mobile home page
     */
    public  TMobileHomePage goToTMobileHP(){
        String tMobileHeader = "t-mobile.cz";
        findRightElement(tMobileHeader).click();
        return new TMobileHomePage(driver,wait);
    }

    /**
     * TODO: add some recursion stop
     * finds element which contains in url linkPart
     * @param linkPart part of link of desired website
     * @return found link
     */
    private WebElement findRightElement(String linkPart){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("resultStats"))); //waiting to be sure that we got our results
        List<WebElement> results = driver.findElements(By.xpath("//*[@id='rso']//h3/a"));

        for(WebElement result : results){
            if(result.getAttribute("href").contains(linkPart)){
                return result;
            }
        }
        nextPage();
        return findRightElement(linkPart);
    }

    /**
     * just goes to next results page
     */
    private void nextPage(){
        driver.findElement(By.id("pnnext")).click();
    }
}
