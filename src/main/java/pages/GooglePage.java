package pages;

import commons.GlobalVariables;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GooglePage {


    private static final String URL = "https://www.google.com/";
    private static final By SEARCH_FIELD = By.xpath("//*[@name=\"q\"]");
    private static final By FIRST_RESULT_ADDRESS = By.xpath("//*[@id=\"rhs_block\"]//span[@class=\"LrzXr\"]");

    private WebDriver driver;
    private WebDriverWait wait;
    private String resultAddress;

    public GooglePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, GlobalVariables.GENERAL_EXPLICIT_TIMEOUT);
    }

    public void getGooglePage(){
        driver.get(URL);
    }

    public void searchText(String keywords){
        wait.until(ExpectedConditions.visibilityOfElementLocated(SEARCH_FIELD)).sendKeys(keywords + Keys.ENTER);
    }

    public void setResultAddress(){
        resultAddress = wait.until(ExpectedConditions.visibilityOfElementLocated(FIRST_RESULT_ADDRESS)).getText();
    }

    public String getResultAddress() {
        return resultAddress;
    }
}
