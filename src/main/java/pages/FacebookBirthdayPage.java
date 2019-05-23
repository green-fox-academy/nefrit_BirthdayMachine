package pages;

import commons.GlobalVariables;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FacebookBirthdayPage {

    private WebDriverWait wait;
    private WebDriver driver;

    public FacebookBirthdayPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, GlobalVariables.GENERAL_EXPLICIT_TIMEOUT);
    }

    




}

