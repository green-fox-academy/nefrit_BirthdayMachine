package pages;

import commons.GlobalVariables;
import org.openqa.selenium.*;
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
    private By closeBannerElement = By.id("branch-banner-close");
    private By firstResultCity = By.xpath("//*[@id=\"container\"]/div[1]/div[2]/div[3]/div[1]/div[2]/div[1]/div[2]/div[2]/div/span[1]");
    private By firstResultStreet = By.xpath("//*[@id=\"container\"]/div[1]/div[2]/div[3]/div[1]/div[2]/div[1]/div[2]/div[2]/div/span[2]");
    private By firstResultZipCode = By.xpath("//*[@id=\"container\"]/div[1]/div[2]/div[3]/div[1]/div[2]/div[1]/div[2]/div[2]/div/span[3]");

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

    public void getFirstResultPage(){
        wait.until(ExpectedConditions.elementToBeClickable(firstResultLink)).click();
    }

    public void closeBranchBanner(){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(closeBannerElement)).click();

        } catch (NoSuchElementException | TimeoutException e){

        }
    }

    public String getHighestRankedSearchResultAddress(){
        StringBuilder address = new StringBuilder();
        address.append(driver.findElement(firstResultCity).getText());

        /*address.append(wait.until(ExpectedConditions.presenceOfElementLocated(firstResultStreet)).getText());
        address.append(wait.until(ExpectedConditions.presenceOfElementLocated(firstResultZipCode)).getText());*/
        return address.toString();
    }

}
