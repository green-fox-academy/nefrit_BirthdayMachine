package pages;

import commons.GlobalVariables;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleMapsPage {

    private static final String URL = "https://www.google.com/maps";
    private static final By TRIP_PLANNER_BUTTON = By.id("searchbox-directions");
    private static final By PUBLIC_TRANSPORT_BUTTON = By.xpath("//*[@id=\"omnibox-directions\"]//div[@data-travel_mode=\"3\"]/button");
    private static final By DEPARTURE_LOCATION = By.xpath("//*[@id=\"directions-searchbox-0\"]//input");
    private static final By ARRIVAL_LOCATION = By.xpath("//*[@id=\"directions-searchbox-1\"]//input");
    private static final By FIRST_RESULT = By.id("section-directions-trip-0");
    private static final By DETAILS_BUTTON = By.className("section-directions-trip-details-link");
    private static final By SHARE_LINK_BUTTON = By.className("maps-sprite-pane-action-ic-share-black");
    private static final By SHARE_LINK_FIELD = By.className("section-copy-link-input");

    private WebDriver driver;
    private WebDriverWait wait;
    private String resultUrl;

    public GoogleMapsPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, GlobalVariables.GENERAL_EXPLICIT_TIMEOUT);
    }

    public void getGoogleMapsPage(){
        driver.get(URL);
    }

    public void getRoutePlannerForm(){
        wait.until(ExpectedConditions.elementToBeClickable(TRIP_PLANNER_BUTTON)).click();
    }

    public void planTripWithPublicTransport(String departureLocation, String arrivalLocation){
        wait.until(ExpectedConditions.elementToBeClickable(PUBLIC_TRANSPORT_BUTTON)).click();
        WebElement departureField = wait.until(ExpectedConditions.visibilityOfElementLocated(this.DEPARTURE_LOCATION));
        WebElement arrivalField = wait.until(ExpectedConditions.visibilityOfElementLocated(this.ARRIVAL_LOCATION));
        departureField.clear();
        departureField.sendKeys(departureLocation);
        arrivalField.clear();
        arrivalField.sendKeys(arrivalLocation + Keys.ENTER);
    }

    public void setResultUrl(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(FIRST_RESULT));
        wait.until(ExpectedConditions.elementToBeClickable(DETAILS_BUTTON)).click();
        wait.until(ExpectedConditions.elementToBeClickable(SHARE_LINK_BUTTON)).click();
        resultUrl = wait.until(ExpectedConditions.visibilityOfElementLocated(SHARE_LINK_FIELD)).getAttribute("value");
    }

    public String getResultUrl(){
        return resultUrl;
    }
}
