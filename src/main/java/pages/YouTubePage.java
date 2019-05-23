package pages;

import commons.GlobalVariables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YouTubePage {

    private WebDriver driver;
    private WebDriverWait wait;

    private String url = "https://www.youtube.com/";

    private By searchField = By.xpath("");

    public YouTubePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, GlobalVariables.GENERAL_EXPLICIT_TIMEOUT);
    }
}
