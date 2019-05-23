package pages;

import commons.GlobalVariables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FacebookProfilePage {

    private static final By ABOUT_BUTTON = By.xpath("//*[@id='fbTimelineHeadline']//a[@data-tab-key='about']");
    private static final By EMAIL_ADDRESS = By.xpath("//*[@data-overviewsection='contact_basic']//a[contains(@href,'mailto')]");
    private String emailAddress;

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

    public void getFriendEmailAddress() {
        emailAddress = wait.until(ExpectedConditions.visibilityOfElementLocated(EMAIL_ADDRESS)).getText();
        System.out.println(emailAddress);
    }


}
