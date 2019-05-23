package commons;

import java.util.List;

public class AppManager {

    public static void selectFriendToInteractWith(List<String> listOfFriends) {
        System.out.println("Friends who have birthday today: ");
        for (String friend : listOfFriends) {
            System.out.println(friend);
        }

    }


}
