package pages;

import commons.GlobalVariables;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YouTubePage {

    private WebDriver driver;
    private WebDriverWait wait;

    private String url = "https://www.youtube.com/";
    private String resultUrl;

    private By searchField = By.xpath("//input[@id=\"search\"]");
    private By firstResult = By.xpath("//*[@id=\"video-title\"]");

    public YouTubePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, GlobalVariables.GENERAL_EXPLICIT_TIMEOUT);
    }

    public void getYouTubePage(){
        driver.get(url);
    }

    public void searchForMusic(String keywords){
        wait.until(ExpectedConditions.elementToBeClickable(searchField)).sendKeys(keywords + Keys.ENTER);
    }

    public void setResultUrl(){
        resultUrl = wait.until(ExpectedConditions. visibilityOfElementLocated(firstResult)).getAttribute("href");
    }

    public String getResultUrl() {
        return resultUrl;
    }
}
