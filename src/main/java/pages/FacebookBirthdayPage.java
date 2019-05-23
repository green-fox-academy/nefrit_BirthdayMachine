package pages;

import commons.GlobalVariables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class FacebookBirthdayPage {

    private static final String BIRTHDAY_PAGE_URL = "https://www.facebook.com/events/birthdays/";
    private static final By PEOPLE_WHO_HAVE_BIRTHDAY_TODAY = By.xpath("//*[@id=\"birthdays_content\"]/div[1]/div[2]/ul[1]//div[@class='_tzn lfloat _ohe']/a");

    private List<WebElement> listOfWebelementsOfPeople;
    private List<String> listOfNamesOfPeople;
    private WebDriverWait wait;
    private WebDriver driver;

    public FacebookBirthdayPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, GlobalVariables.GENERAL_EXPLICIT_TIMEOUT);
        this.listOfWebelementsOfPeople = new ArrayList<>();
        this.listOfNamesOfPeople = new ArrayList<>();
    }

    public List<WebElement> getListOfWebelementsOfPeople() {
        return listOfWebelementsOfPeople;
    }

    public List<String> getListOfNamesOfFriends() {
        return listOfNamesOfPeople;
    }

    public void navigateToBirthdayPage() {
        driver.get(BIRTHDAY_PAGE_URL);
    }

    public void getFriendsWhoHaveBirthdayTodayFromFacebok() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(PEOPLE_WHO_HAVE_BIRTHDAY_TODAY));
        listOfWebelementsOfPeople = driver.findElements(PEOPLE_WHO_HAVE_BIRTHDAY_TODAY);
        collectNamesFromWebelements();
    }

    public void clickOnSelectedName(String nameToClickOn) {
        for (WebElement friend :
                listOfWebelementsOfPeople) {
            if (nameToClickOn.equalsIgnoreCase(friend.getText())) {
                friend.click();
                break;
            }
        }
    }

    private void collectNamesFromWebelements() {
        for (WebElement friend : listOfWebelementsOfPeople) {
            listOfNamesOfPeople.add(friend.getText());
        }
    }
}
