package pages;

import commons.GlobalVariables;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FacebookProfilePage {

    private static final By ABOUT_BUTTON = By.xpath("//*[@id='fbTimelineHeadline']//a[@data-tab-key='about']");
    private static final By EMAIL_ADDRESS = By.xpath("//*[@data-overviewsection='contact_basic']//a[contains(@href,'mailto')]");
    private static final By MESSAGE_BUTTON = By.xpath("//*[@id='fbTimelineHeadline']//a[contains(@href,'/messages/')]");
    private static final By MESSAGE_FIELD = By.xpath("//div[contains(@class,'_5rpu') and @role='combobox']");
    //private static final By MESSAGE_FIELD = By.xpath("//div[@class='fbNubFlyoutOuter']//div[@class='_1mf _1mj']/span/span");


    private String emailAddress;
    private WebDriver driver;
    private WebDriverWait wait;

    public FacebookProfilePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, GlobalVariables.GENERAL_EXPLICIT_TIMEOUT);
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void clickOnAboutButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ABOUT_BUTTON));
        wait.until(ExpectedConditions.elementToBeClickable(ABOUT_BUTTON)).click();
    }

    public void getFriendEmailAddress() {
        emailAddress = wait.until(ExpectedConditions.visibilityOfElementLocated(EMAIL_ADDRESS)).getText();
        System.out.println(emailAddress);
    }

    public void clickOnMessageButton() {
        wait.until(ExpectedConditions.elementToBeClickable(MESSAGE_BUTTON)).click();
    }

    public void sendMessageToFriend(String finalMessageToFriend) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(MESSAGE_FIELD));
        driver.findElement(MESSAGE_FIELD).sendKeys(finalMessageToFriend + Keys.ENTER);
    }

    public void clickOnSendMessage() {

    }

}
