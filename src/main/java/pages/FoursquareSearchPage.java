package pages;

import commons.DriverUtility;
import commons.GlobalVariables;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FoursquareSearchPage {

    private static final String URL = "https://foursquare.com/city-guide";
    private static final By CITY_INPUT_FIELD = By.id("headerLocationInput");
    private static final By CATEGORY_INPUT_FIELD = By.id("headerBarSearch");
    private static final By SUBMIT_BUTTON = By.className("submitButton");
    private static final By FIRST_RESULT_LINK = By.xpath("//*[@id=\"results\"]/ul/li[2]//a");

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
        WebElement cityField;
        try {
            cityField = wait.until(ExpectedConditions.visibilityOfElementLocated(CITY_INPUT_FIELD));
        } catch (NoSuchElementException | TimeoutException e) {
            DriverUtility.refreshPage(driver);
        }
        cityField = wait.until(ExpectedConditions.visibilityOfElementLocated(CITY_INPUT_FIELD));
        cityField.clear();
        cityField.sendKeys(city);
        wait.until(ExpectedConditions.visibilityOfElementLocated(CATEGORY_INPUT_FIELD)).sendKeys(category);
        wait.until(ExpectedConditions.elementToBeClickable(SUBMIT_BUTTON)).click();
    }

    public void setRestaurantName(){
        restaurantName = wait.until(ExpectedConditions.visibilityOfElementLocated(FIRST_RESULT_LINK)).getText();
    }

    public String getRestaurantName() {
        return restaurantName;
    }
}
