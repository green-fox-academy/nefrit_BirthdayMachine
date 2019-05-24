import commons.AppManager;
import commons.DriverUtility;
import commons.MessageBuilder;
import commons.PropertyUtility;
import enums.PortProgramType;
import org.openqa.selenium.WebDriver;
import pages.*;

import java.util.HashMap;
import java.util.Map;

public class App {

    private static WebDriver driver1;
    private static WebDriver driver2;
    private static WebDriver driver3;
    private static WebDriver driver4;
    private static Map<String, String> config = new HashMap<>();

    public static void main(String[] args) {

        PropertyUtility.getPropertyFileContent(config);

        driver1 = DriverUtility.startUp(driver1, config, false, true, true);
        FacebookLoginPage facebookLoginPage = new FacebookLoginPage(driver1);
        facebookLoginPage.login(config.get("username"), config.get("password"));

        FacebookBirthdayPage facebookBirthdayPage = new FacebookBirthdayPage(driver1);
        facebookBirthdayPage.isThereBirthdayToday();
        facebookBirthdayPage.getFriendsWhoHaveBirthdayTodayFromFacebok();
        AppManager.selectFriendToInteractWith(driver1, facebookBirthdayPage.getListOfNamesOfFriends());
        facebookBirthdayPage.clickOnSelectedName(AppManager.getChosenFriend());

        FacebookProfilePage facebookProfilePage = new FacebookProfilePage(driver1);
        facebookProfilePage.clickOnAboutButton();
        facebookProfilePage.getFriendEmailAddressOnContactPage();
        facebookProfilePage.getFriendPlaceOfResidenceOnContactPage();


        driver2 = DriverUtility.startUp(driver2, config, false, true, true);
        PortHuPage portHu = new PortHuPage(driver2);
        PortHuProgramResultsPage portHuProgramResults = new PortHuProgramResultsPage(driver2);
        portHu.openPortPointHu();
        portHu.searchForProgram(PortProgramType.CONCERT, facebookProfilePage.getPlaceOfResidence());
        portHuProgramResults.chooseMostPopularEvent();
        portHuProgramResults.setFields();
        IdokepPage idokep = new IdokepPage(driver2);
        idokep.openIdokep();
        idokep.setTemperature();
        DriverUtility.quitSession(driver2);


        driver3 = DriverUtility.startUp(driver3, config, false, true, true);
        FoursquareSearchPage fsPage = new FoursquareSearchPage(driver3);
        GooglePage gPage = new GooglePage(driver3);
        YouTubePage yPage = new YouTubePage(driver3);
        GoogleMapsPage gmPage = new GoogleMapsPage(driver3);
        fsPage.getFoursquareSearchPage();
        fsPage.searchForCategoryAndCity("food", facebookProfilePage.getPlaceOfResidence());
        fsPage.setRestaurantName();
        gPage.getGooglePage();
        gPage.searchText(fsPage.getRestaurantName());
        gPage.setResultAddress();
        gmPage.getGoogleMapsPage();
        gmPage.getRoutePlannerForm();
        gmPage.planTripWithPublicTransport(portHuProgramResults.getEventAddress(), gPage.getResultAddress());
        gmPage.setResultUrl();
        yPage.getYouTubePage();
        yPage.searchForMusic("születésnapi zenék");
        yPage.setResultUrl();
        DriverUtility.quitSession(driver3);


        MessageBuilder messageBuilder = new MessageBuilder(yPage.getResultUrl(), portHuProgramResults.getEventTitle(),
                fsPage.getRestaurantName(), gmPage.getResultUrl(), idokep.getTemperature());
        messageBuilder.setGreetingMessage();
        facebookProfilePage.sendMessageToFriend(messageBuilder.getGreetingMessage());


        driver4 = DriverUtility.startUp(driver4, config, false, true, true);
        EKepeslapPage eKepeslapPage = new EKepeslapPage(driver4);
        eKepeslapPage.sendPostCardToFriendsEmailAddress("Happy Birthday!!!",
                "I wish you a Happy Birthday!", config.get("myname"),
                AppManager.getChosenFriend(), facebookProfilePage.getEmailAddress(),
                config.get("myname"), config.get("myemail") );
    }
}
