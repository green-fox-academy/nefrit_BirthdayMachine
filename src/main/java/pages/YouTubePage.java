package pages;

import commons.GlobalVariables;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YouTubePage {

    private static final String URL = "https://www.youtube.com/";
    private static final By SEARCH_FIELD = By.xpath("//input[@id=\"search\"]");
    private static final By FILTER_BUTTON = By.id("filter-menu");
    private static final By FIRST_RESULT = By.xpath("//*[@id=\"video-title\"]");

    private WebDriver driver;
    private WebDriverWait wait;
    private String resultUrl;
    
    public YouTubePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, GlobalVariables.GENERAL_EXPLICIT_TIMEOUT);
    }

    public void getYouTubePage(){
        driver.get(URL);
    }

    public void searchForMusic(String keywords){
        wait.until(ExpectedConditions.elementToBeClickable(SEARCH_FIELD)).sendKeys(keywords + Keys.ENTER);
    }

    public void setResultUrl(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(FILTER_BUTTON));
        resultUrl = wait.until(ExpectedConditions. visibilityOfElementLocated(FIRST_RESULT)).getAttribute("href");
    }

    public String getResultUrl() {
        return resultUrl;
    }
}
