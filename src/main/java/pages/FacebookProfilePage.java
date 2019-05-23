package pages;

import commons.GlobalVariables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FacebookProfilePage {

    private static final By ABOUT_BUTTON = By.xpath("//*[@id='fbTimelineHeadline']//a[@data-tab-key='about']");


    private WebDriver driver;
    private WebDriverWait wait;

    public FacebookProfilePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, GlobalVariables.GENERAL_EXPLICIT_TIMEOUT);
    }

    public void clickOnAboutButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ABOUT_BUTTON));
        wait.until(ExpectedConditions.elementToBeClickable(ABOUT_BUTTON)).click();
    }




}
