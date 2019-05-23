package pages;

import commons.GlobalVariables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Idokep {

    private WebDriverWait wait;
    private WebDriver driver;
    private String idokepUrl = "https://www.idokep.hu/";
    private String partOfTheDay = "ma este";
    private By detailsLink = By.linkText("részletek");
    private By partOfTheDayColumns = By.xpath("//*[@class='harminchat']//*[@class='napszak']");
    private By temperatureColumns = By.xpath("//*[@class='harminchat']//*[@class='homerseklet']");

    public Idokep(WebDriver driver) {
        this.wait = new WebDriverWait(driver, GlobalVariables.GENERAL_EXPLICIT_TIMEOUT);
        this.driver = driver;
    }

    public void openIdokep() {
        driver.get(idokepUrl);
    }

    public int getEveningTemperature() {
        driver.findElement(detailsLink).click();
        List<WebElement> columnPartOfTheDay = driver.findElements(partOfTheDayColumns);
        int numberOfColumn = 0;
        while (!columnPartOfTheDay.get(numberOfColumn).getText().equals(partOfTheDay)) {
            numberOfColumn++;
        }
        String eveningTemperature = driver.findElements(temperatureColumns).get(numberOfColumn).getText();
        int temperature = Integer.parseInt(eveningTemperature.split(" ")[0]);
        return temperature;
    }
}
