package pages;

import commons.GlobalVariables;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleMapsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private String url = "https://www.google.com/maps";

    private By routePlannerButton = By.id("searchbox-directions");

    public void getGoogleMapsPage(){
        driver.get(url);
    }
}
