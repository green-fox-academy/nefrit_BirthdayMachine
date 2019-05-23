package pages;

import commons.GlobalVariables;
import enums.PortProgramType;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;



public class PortPointHu {

    private WebDriverWait wait;
    private WebDriver driver;
    private By programSearchFrom = By.id("top-search-form");
    private By cityChooser = By.xpath("//form[@id='top-search-form']/ul/li[2]/a/span");
    private By programType = By.xpath("//form[@id='top-search-form']/ul/li[3]/a/span");
    private By searchProgramButton = By.xpath("//form[@id='top-search-form']/button");
    private String defaultCity = "Budapest";


    public PortPointHu(WebDriver driver) {
        this.wait = new WebDriverWait(driver, GlobalVariables.GENERAL_EXPLICIT_TIMEOUT);
        this.driver = driver;
    }

    public void openPortPointHu() {
        driver.get("https://port.hu/");
    }

    public void searchForProgram(PortProgramType portProgramType, String city) {
        driver.findElement(cityChooser).click();
        try {
            driver.findElement(By.linkText(city)).click();

        } catch (NoSuchElementException e) {
            driver.findElement(By.linkText(defaultCity)).click();
        }
        driver.findElement(programType).click();
        driver.findElement(By.linkText(portProgramType.getValue())).click();
        driver.findElement(searchProgramButton).click();
    }
}

