package pages;

import commons.GlobalVariables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FacebookBirthdayPage {


    private static final String BIRTHDAY_PAGE_URL = "https://www.facebook.com/events/birthdays/";
    private static final By PEOPLE_WHO_HAVE_BIRTHDAY_TODAY3 = By.xpath("//*[@id=\"birthdays_content\"]/div[1]/div[2]/ul");
    private static final ByChained PEOPLE_WHO_HAVE_BIRTHDAY_TODAY = new ByChained(By.id("birthdays_content"),By.className("_tzl"));

    private WebDriverWait wait;
    private WebDriver driver;


    public FacebookBirthdayPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, GlobalVariables.GENERAL_EXPLICIT_TIMEOUT);
    }

    public void navigateToBirthdayPage() {
        driver.get(BIRTHDAY_PAGE_URL);
    }

    public void getListOfPeopleWhoHaveBirthdayToday() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(PEOPLE_WHO_HAVE_BIRTHDAY_TODAY3));
        List<WebElement> listOfPeople = driver.findElements(PEOPLE_WHO_HAVE_BIRTHDAY_TODAY3);
        System.out.println(listOfPeople.size());


    }




}

