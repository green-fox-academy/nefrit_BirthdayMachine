package commons;

import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class MessageBuilder {

    private String greetingMessage = "Hello";
    private String friendName;
    private String greetingText;
    private String musicVideoLink;
    private String eventTitle;
    private String restaurantName;
    private String tripPlanUrl;
    private String weatherBasedDressingTip;

    public void setGreetingMessage(){
        greetingMessage = "";
    }

    public String getGreetingMessage() {
        return greetingMessage;
    }
}
