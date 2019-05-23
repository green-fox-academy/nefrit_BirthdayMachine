package commons;

import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Scanner;

public class AppManager {

    private static String chosenFriend = "";

    public static String getChosenFriend() {
        return chosenFriend;
    }

    public static void selectFriendToInteractWith(WebDriver driver, List<String> listOfFriends) {
        if (listOfFriends == null || listOfFriends.size() == 0) {
            System.out.println("Sorry, you don't have any friends who has birthday today. Try this app again tomorrow!");
            DriverUtility.quitSession(driver);
            System.exit(0);
        }
        System.out.println("Friends who have birthday today: ");
        for (int i = 0; i < listOfFriends.size(); i++) {
            System.out.println((i + 1) + " -> " + listOfFriends.get(i));
        }
        System.out.println("\nSelect your friend by the number above if you want to make her/his (and your) day special:");
        Scanner scanner = new Scanner(System.in);
        int chosenNumber = -1;
        do {
            chosenNumber = scanner.nextInt();
        } while (chosenNumber <= 0 || chosenNumber > listOfFriends.size());
        chosenFriend = listOfFriends.get(chosenNumber - 1);
    }


}
