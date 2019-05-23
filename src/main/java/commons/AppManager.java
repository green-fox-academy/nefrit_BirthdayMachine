package commons;

import org.openqa.selenium.WebDriver;

import java.util.List;

public class AppManager {

    public static void selectFriendToInteractWith(WebDriver driver, List<String> listOfFriends) {
        if (listOfFriends != null) {
        System.out.println("Friends who have birthday today: ");
            for (int i = 0; i < listOfFriends.size(); i++) {
                System.out.println((i + 1) + " -> " + listOfFriends.get(i));
            }
            System.out.println("\nSelect your friend by the number above if you want to make her/his (and your) day special.");
        } else {
            System.out.println("Sorry, you don't have any friends who has birthday today. Try this app again tomorrow!");
            DriverUtility.quitSession(driver);
            System.exit(0);
        }




    }


}
