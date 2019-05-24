package pages;

import commons.GlobalVariables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PortHuProgramResultsPage {

    private static final By RESULT_ORDER_POPULAR = By.xpath("//*[@id='s']//label[@title='Népszerű']/span");
    private static final By FIRST_RESULT = By.xpath("//*[@id='results']/li[1]//a[@class='title']");
    private static final By ADDRESS = By.className("address");
    private static final By EVENT_TITLE_BY = By.className("title");
    private static final By EVENT_START_TIME = By.xpath("(//div[@class='showtime-box']//span)[2]");

    private WebDriverWait wait;
    private WebDriver driver;

    private String searchPageName = "Keresés";
    private String eventAddress;
    private String eventTitle;
    private String evenStartTime;


    public PortHuProgramResultsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, GlobalVariables.GENERAL_EXPLICIT_TIMEOUT);
    }

    public void chooseMostPopularEvent() {
        wait.until(ExpectedConditions.titleIs(searchPageName));
        driver.findElement(RESULT_ORDER_POPULAR).click();
        driver.findElement(FIRST_RESULT).click();
    }

    public void setFields() {
        setEventAddress();
        setEventTitle();
        setEventStartTime();
    }

    private void setEventAddress() {
        eventAddress = driver.findElement(ADDRESS).getText();
    }

    private void setEventTitle() {
        eventTitle = driver.findElement(EVENT_TITLE_BY).getText();
    }

    private void setEventStartTime() {
        String startTime = driver.findElement(EVENT_START_TIME).getText();
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
