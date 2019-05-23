package pages;

import commons.GlobalVariables;
import enums.PortProgramType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;



public class PortPointHu {

    private WebDriverWait wait;
    private WebDriver driver;
    private By programSearchFrom = By.id("top-search-form");
    private By programType = By.xpath("//form[@id='top-search-form']/ul/li[3]/a/span");
    private By searchProgramButton = By.xpath("//form[@id='top-search-form']/button");


    public PortPointHu(WebDriver driver) {
        this.wait = new WebDriverWait(driver, GlobalVariables.GENERAL_EXPLICIT_TIMEOUT);
        this.driver = driver;
    }

    public void openPortPointHu() {
        driver.get("https://port.hu/");
    }

    public void chooseProgramType(PortProgramType portProgramType) {
        driver.findElement(programType).click();
        driver.findElement(By.linkText(portProgramType.getValue())).click();
        driver.findElement(searchProgramButton).click();
    }








}
