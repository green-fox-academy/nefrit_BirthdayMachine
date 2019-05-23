package pages;

import commons.GlobalVariables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FoursquareSearchPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private final String url = "https://foursquare.com/city-guide";
    private String city;
    private String searchCategory;

    private By cityInputField = By.id("headerLocationInput");
    private By categoryInputField = By.id("headerBarSearch");
    private By submitButton = By.className("submitButton");
    private By firstResultLink = By.xpath("//*[@id=\"results\"]/ul/li[2]//a");

    public FoursquareSearchPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, GlobalVariables.GENERAL_EXPLICIT_TIMEOUT);
    }

    public void getFoursquareSearchPage(){
        driver.get(url);
    }

    public void searchForCategoryAndCity(String category, String city){
        WebElement cityField = wait.until(ExpectedConditions.visibilityOfElementLocated(cityInputField));
        cityField.clear();
        cityField.sendKeys(city);
        wait.until(ExpectedConditions.visibilityOfElementLocated(categoryInputField)).sendKeys(category);
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
    }

    public String getHighestRankedSearchResultName(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(firstResultLink)).getText();
    }

}
