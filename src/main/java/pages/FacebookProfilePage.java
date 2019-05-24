package pages;

import commons.GlobalVariables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FacebookProfilePage {

    private static final By ABOUT_BUTTON = By.xpath("//*[@id='fbTimelineHeadline']//a[@data-tab-key='about']");
    private static final By EMAIL_ADDRESS = By.xpath("//*[@data-overviewsection='contact_basic']//a[contains(@href,'mailto')]");
    private static final By PLACE_OF_RESIDENCE = By.xpath("//div[@data-overviewsection='places']/div/div/div/a");
    private static final By MESSAGE_BUTTON = By.xpath("//*[@id='fbTimelineHeadline']//a[contains(@href,'/messages/')]");
    private static final By MESSAGE_FIELD = By.xpath("//div[contains(@class,'_5rpu') and @role='combobox']");

    private String emailAddress;
    private String placeOfResidence;
    private WebDriver driver;
    private WebDriverWait wait;

    public FacebookProfilePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, GlobalVariables.GENERAL_EXPLICIT_TIMEOUT);
        this.emailAddress = "";
        this.placeOfResidence = "Budapest";
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPlaceOfResidence() {
        return placeOfResidence;
    }

    public void clickOnAboutButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ABOUT_BUTTON));
        wait.until(ExpectedConditions.elementToBeClickable(ABOUT_BUTTON)).click();
    }

    public void getFriendEmailAddressOnContactPage() {
        try {
            emailAddress = wait.until(ExpectedConditions.visibilityOfElementLocated(EMAIL_ADDRESS)).getText();
        } catch (NoSuchElementException | TimeoutException e) {
            System.out.println("Couldn't find email address.");
            e.printStackTrace();
        }
        System.out.println(emailAddress);
    }

    public void getFriendPlaceOfResidenceOnContactPage() {
        try {
            placeOfResidence = wait.until(ExpectedConditions.visibilityOfElementLocated(PLACE_OF_RESIDENCE)).getText();
        } catch (NoSuchElementException | TimeoutException e) {
            System.out.println("Couldn't find place of residence. Default will be Budapest.");
            e.printStackTrace();
        }
        System.out.println(placeOfResidence);
    }

    public void sendMessageToFriend(String finalMessageToFriend) {
        clickOnMessageButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(MESSAGE_FIELD));
        driver.findElement(MESSAGE_FIELD).sendKeys(finalMessageToFriend + Keys.ENTER);
    }

    private void clickOnMessageButton() {
        wait.until(ExpectedConditions.elementToBeClickable(MESSAGE_BUTTON)).click();
    }
}
