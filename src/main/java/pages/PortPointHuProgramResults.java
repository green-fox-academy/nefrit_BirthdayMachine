package pages;

import commons.GlobalVariables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PortPointHuProgramResults {

    private WebDriverWait wait;
    private WebDriver driver;
    private By resultOrderPopular = By.xpath("//*[@id='s']//label[@title='Népszerű']/span");
    private By firstResult = By.xpath("//*[@id='results']/li[1]//a[@class='title']");
    private By address = By.className("address");
    private By eventTitle = By.className("title");
    private By eventStartTime = By.xpath("(//div[@class='showtime-box']//span)[2]");

    public PortPointHuProgramResults(WebDriver driver) {
        this.wait = new WebDriverWait(driver, GlobalVariables.GENERAL_EXPLICIT_TIMEOUT);
        this.driver = driver;
    }

    public void chooseMostPopularEvent() {
        wait.until(ExpectedConditions.titleIs("Keresés"));
        driver.findElement(resultOrderPopular).click();
        driver.findElement(firstResult).click();
    }

    public String getAddress() {
        return driver.findElement(address).getText();
    }

    public String getEventTitle() {
        return driver.findElement(eventTitle).getText();
    }

    public String getEventStartTime() {
        String startTime= driver.findElement(eventStartTime).getText();
        String[] startTimeArray = startTime.split(" ");
        return startTimeArray[startTimeArray.length-1];
    }
}

