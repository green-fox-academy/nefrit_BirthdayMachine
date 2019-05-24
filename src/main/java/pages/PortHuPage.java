package pages;

import commons.GlobalVariables;
import enums.PortProgramType;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PortHuPage {

    private static final String PORT_POINT_HU_URL = "https://port.hu/";
    private static final By PROGRAM_SEARCH_FORM = By.id("top-search-form");
    private static final By CITY_CHOOSER = By.xpath("//form[@id='top-search-form']/ul/li[2]/a/span");
    private static final By PROGRAM_TYPE = By.xpath("//form[@id='top-search-form']/ul/li[3]/a/span");
    private static final By SEARCH_PROGRAM_BUTTON = By.xpath("//form[@id='top-search-form']/button");
    private static final String DEFAULT_CITY = "Budapest";

    private WebDriverWait wait;
    private WebDriver driver;

    public PortHuPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, GlobalVariables.GENERAL_EXPLICIT_TIMEOUT);
        this.driver = driver;
    }

    public void openPortPointHu() {
        driver.get(PORT_POINT_HU_URL);
    }

    public void searchForProgram(PortProgramType portProgramType, String city) {
        driver.findElement(CITY_CHOOSER).click();
        try {
            driver.findElement(By.linkText(city)).click();

        } catch (NoSuchElementException e) {
            driver.findElement(By.linkText(DEFAULT_CITY)).click();
        }
        driver.findElement(PROGRAM_TYPE).click();
        driver.findElement(By.linkText(portProgramType.getValue())).click();
        driver.findElement(SEARCH_PROGRAM_BUTTON).click();
    }
}
