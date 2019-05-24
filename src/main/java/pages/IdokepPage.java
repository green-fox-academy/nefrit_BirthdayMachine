package pages;

import commons.GlobalVariables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class IdokepPage {

    private static final String idokepUrl = "https://www.idokep.hu/";
    private static final String partOfTheDay = "ma este";
    private static final By DETAILS_LINK = By.linkText("részletek");
    private static final By PART_OF_THE_DAY_COLUMNS = By.xpath("//*[@class='harminchat']//*[@class='napszak']");
    private static final By TEMPERATURE_COLUMNS = By.xpath("//*[@class='harminchat']//*[@class='homerseklet']");

    private WebDriverWait wait;
    private WebDriver driver;
    private int temperature;

    public IdokepPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, GlobalVariables.GENERAL_EXPLICIT_TIMEOUT);
    }

    public void openIdokep() {
        driver.get(idokepUrl);
    }

    public void setTemperature() {
        driver.findElement(DETAILS_LINK).click();
        List<WebElement> columnPartOfTheDay = driver.findElements(PART_OF_THE_DAY_COLUMNS);
        int numberOfColumn = 0;
        while (!columnPartOfTheDay.get(numberOfColumn).getText().equals(partOfTheDay)) {
            numberOfColumn++;
        }
        String eveningTemperature = driver.findElements(TEMPERATURE_COLUMNS).get(numberOfColumn).getText();
        temperature = Integer.parseInt(eveningTemperature.split(" ")[0]);
    }

    public int getTemperature() {
        return temperature;
    }
}
