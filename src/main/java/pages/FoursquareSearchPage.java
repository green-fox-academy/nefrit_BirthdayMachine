package pages;

import commons.GlobalVariables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FoursquareSearchPage {

    private static final String URL = "https://foursquare.com/city-guide";
    private static final By CITY_INPUT_FIELD = By.id("headerLocationInput");
    private static final By CATEGORY_INPUT_FIELD = By.id("headerBarSearch");
    private static final By SUBMIT_BUTTON = By.className("submitButton");
    private static final By firstResultLink = By.xpath("//*[@id=\"results\"]/ul/li[2]//a");

    private WebDriver driver;
    private WebDriverWait wait;
    private String restaurantName;

    public FoursquareSearchPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, GlobalVariables.GENERAL_EXPLICIT_TIMEOUT);
    }

    public void getFoursquareSearchPage(){
        driver.get(URL);
    }

    public void searchForCategoryAndCity(String category, String city){
        WebElement cityField = wait.until(ExpectedConditions.visibilityOfElementLocated(CITY_INPUT_FIELD));
        cityField.clear();
        cityField.sendKeys(city);
        wait.until(ExpectedConditions.visibilityOfElementLocated(CATEGORY_INPUT_FIELD)).sendKeys(category);
        wait.until(ExpectedConditions.elementToBeClickable(SUBMIT_BUTTON)).click();
    }

    public void setRestaurantName(){
        restaurantName = wait.until(ExpectedConditions.visibilityOfElementLocated(firstResultLink)).getText();
    }

    public String getRestaurantName() {
        return restaurantName;
    }
}
