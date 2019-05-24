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
    private static Map<String, String> config = new HashMap<>();

    public static void main(String[] args) {

        //get config.properties content
        PropertyUtility.getPropertyFileContent(config);

        driver1 = DriverUtility.startUp(driver1, config, false, true, true);

        //login to Facebook
        FacebookLoginPage facebookLoginPage = new FacebookLoginPage(driver1);
        facebookLoginPage.login(config.get("username"), config.get("password"));

        //get friends' names, who have birthday today
        FacebookBirthdayPage facebookBirthdayPage = new FacebookBirthdayPage(driver1);
        facebookBirthdayPage.isThereBirthdayToday();
        facebookBirthdayPage.getFriendsWhoHaveBirthdayTodayFromFacebok();

        //select friend to greet
        AppManager.selectFriendToInteractWith(driver1, facebookBirthdayPage.getListOfNamesOfFriends());
        facebookBirthdayPage.clickOnSelectedName(AppManager.getChosenFriend());

        //get friend's location and e-mail address
        FacebookProfilePage facebookProfilePage = new FacebookProfilePage(driver1);
        facebookProfilePage.clickOnAboutButton();
        facebookProfilePage.getFriendEmailAddressOnContactPage();
        facebookProfilePage.getFriendPlaceOfResidenceOnContactPage();

        //searching for event
        driver2 = DriverUtility.startUp(driver2, config, false, true, true);
        PortHuPage portHu = new PortHuPage(driver2);
        PortHuProgramResultsPage portHuProgramResults = new PortHuProgramResultsPage(driver2);
        portHu.openPortPointHu();
        portHu.searchForProgram(PortProgramType.CONCERT, facebookProfilePage.getPlaceOfResidence());
        portHuProgramResults.chooseMostPopularEvent();
        portHuProgramResults.setFields();

        //get weather forecast
        IdokepPage idokep = new IdokepPage(driver2);
        idokep.openIdokep();
        idokep.setTemperature();
        DriverUtility.quitSession(driver2);

        //searching for restaurant
        driver2 = DriverUtility.startUp(driver2, config, false, true, true);
        FoursquareSearchPage fsPage = new FoursquareSearchPage(driver2);
        GooglePage gPage = new GooglePage(driver2);
        YouTubePage yPage = new YouTubePage(driver2);
        GoogleMapsPage gmPage = new GoogleMapsPage(driver2);

        //get most popular restaurant's name
        fsPage.getFoursquareSearchPage();
        fsPage.searchForCategoryAndCity(AppManager.getFoursquareSearchCategory(), facebookProfilePage.getPlaceOfResidence());
        fsPage.setRestaurantName();

        //get restaurant's address
        gPage.getGooglePage();
        gPage.searchText(fsPage.getRestaurantName());
        gPage.setResultAddress();

        //planning trip from the event to the restaurant
        gmPage.getGoogleMapsPage();
        gmPage.getRoutePlannerForm();
        gmPage.planTripWithPublicTransport(portHuProgramResults.getEventAddress(), gPage.getResultAddress());
        gmPage.setResultUrl();

        //searching for birthday music video
        yPage.getYouTubePage();
        yPage.searchForMusic(AppManager.getMusicSearchKeyword());
        yPage.setResultUrl();
        DriverUtility.quitSession(driver2);

        //creating greeting message
        MessageBuilder messageBuilder = new MessageBuilder(yPage.getResultUrl(), portHuProgramResults.getEventTitle(),
                fsPage.getRestaurantName(), gmPage.getResultUrl(), idokep.getTemperature());
        messageBuilder.setGreetingMessage();

        //sending message to friend
        facebookProfilePage.sendMessageToFriend(messageBuilder.getGreetingMessage());

        //sending e-card to friend's e-mail address
        driver2 = DriverUtility.startUp(driver2, config, false, true, true);
        AppManager.sendPostCardIfFriendHasEmailAddress(driver2,"Happy Birthday!!!",
                "I wish you a Happy Birthday!", config.get("myname"),
                AppManager.getChosenFriend(), facebookProfilePage.getEmailAddress(),
                config.get("myname"), config.get("myemail") );
        DriverUtility.quitSession(driver2);
    }
}
