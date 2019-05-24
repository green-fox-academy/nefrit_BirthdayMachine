package pages;

import commons.GlobalVariables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FacebookLoginPage {

    private static final String FACEBOOK_URL = "https://facebook.com";
    private static final By LOGIN_EMAIL_FIELD = By.id("email");
    private static final By PASSWORD_FIELD = By.id("pass");
    private static final By LOGIN_BUTTON = By.id("loginbutton");
    private WebDriverWait wait;
    private WebDriver driver;

    public FacebookLoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, GlobalVariables.GENERAL_EXPLICIT_TIMEOUT);
    }

    public void login(String userEmail, String userPassword) {
        navigateToFacebook();
        typeInEmail(userEmail);
        typeInPassword(userPassword);
        clickLogInButton();
    }

    private void navigateToFacebook() {
        driver.get(FACEBOOK_URL);
    }

    private void typeInEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_EMAIL_FIELD)).sendKeys(email);
    }

    private void typeInPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(PASSWORD_FIELD)).sendKeys(password);
    }

    private void clickLogInButton() {
        wait.until(ExpectedConditions.elementToBeClickable(LOGIN_BUTTON)).click();
    }
}
