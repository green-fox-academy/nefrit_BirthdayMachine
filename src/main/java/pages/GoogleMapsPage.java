package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleMapsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private String url = "https://www.google.com/maps";
    private String resultUrl;

    private By tripPlannerButton = By.id("searchbox-directions");
    private By publicTransportButton = By.xpath("//*[@id=\"omnibox-directions\"]//div[@data-travel_mode=\"3\"]/button");
    private By departureLocation = By.id("directions-searchbox-0");
    private By arrivalLocation = By.id("directions-searchbox-1");
    private By firstResult = By.id("section-directions-trip-0");

    public void getGoogleMapsPage(){
        driver.get(url);
    }

    public void getRoutePlannerForm(){
        wait.until(ExpectedConditions.elementToBeClickable(tripPlannerButton)).click();
    }

    public void planTripWithPublicTransport(String departureLocation, String arrivalLocation){
        wait.until(ExpectedConditions.elementToBeClickable(publicTransportButton)).click();
        WebElement departureField = wait.until(ExpectedConditions.visibilityOfElementLocated(this.departureLocation));
        WebElement arrivalField = wait.until(ExpectedConditions.visibilityOfElementLocated(this.arrivalLocation));
        departureField.clear();
        departureField.sendKeys(departureLocation);
        arrivalField.clear();
        arrivalField.sendKeys(arrivalLocation + Keys.ENTER);
    }

    public void setResultUrl(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstResult));
        resultUrl = driver.getCurrentUrl();
    }

    public String getResultUrl(){
        return resultUrl;
    }
}
