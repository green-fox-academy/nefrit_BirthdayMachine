package pages;

import commons.GlobalVariables;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GooglePage {

    private WebDriver driver;
    private WebDriverWait wait;

    private String url = "https://www.google.com/";

    private By searchField = By.xpath("//*[@id=\"tsf\"]//form//input[@type=\"text\"]");
    private By resultAddress = By.xpath("//*[@id=\"rhs_block\"]//span[@class=\"LrzXr\"]");

    public GooglePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, GlobalVariables.GENERAL_EXPLICIT_TIMEOUT);
    }

    public void searchText(String keywords){
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchField)).sendKeys(keywords + Keys.ENTER);
    }

    public String getResultAddress(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(resultAddress)).getText();
    }
}
