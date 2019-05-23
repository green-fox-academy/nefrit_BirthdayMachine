package pages;

import commons.GlobalVariables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PortHuProgramResults {

    private WebDriverWait wait;
    private WebDriver driver;

    private String searchPageName = "Keresés";
    private String eventAddress;
    private String eventTitle;
    private String evenStartTime;

    private By resultOrderPopular = By.xpath("//*[@id='s']//label[@title='Népszerű']/span");
    private By firstResult = By.xpath("//*[@id='results']/li[1]//a[@class='title']");
    private By address = By.className("address");
    private By eventTitleBy = By.className("title");
    private By eventStartTime = By.xpath("(//div[@class='showtime-box']//span)[2]");

    public PortHuProgramResults(WebDriver driver) {
        this.wait = new WebDriverWait(driver, GlobalVariables.GENERAL_EXPLICIT_TIMEOUT);
        this.driver = driver;
    }

    public void chooseMostPopularEvent() {
        wait.until(ExpectedConditions.titleIs(searchPageName));
        driver.findElement(resultOrderPopular).click();
        driver.findElement(firstResult).click();
    }

    public void setFields() {
        setEventAddress();
        setEventTitle();
        setEventStartTime();
    }


    public void setEventAddress() {
        eventAddress = driver.findElement(address).getText();
    }

    public void setEventTitle() {
        eventTitle = driver.findElement(eventTitleBy).getText();
    }

    public void setEventStartTime() {
        String startTime = driver.findElement(eventStartTime).getText();
        String[] startTimeArray = startTime.split(" ");
        evenStartTime = startTimeArray[startTimeArray.length - 1];
    }

    public String getEventAddress() {
        return eventAddress;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public String getEvenStartTime() {
        return evenStartTime;
    }
}

