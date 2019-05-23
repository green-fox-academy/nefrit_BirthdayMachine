package commons;

public class MessageBuilder {

    private String greetingMessage;
    private String musicVideoLink;
    private String eventTitle;
    private String restaurantName;
    private String tripPlanUrl;
    private String dressingTip;

    public MessageBuilder(String musicVideoLink, String eventTitle, String restaurantName, String tripPlanUrl, String dressingTip) {
        this.musicVideoLink = musicVideoLink;
        this.eventTitle = eventTitle;
        this.restaurantName = restaurantName;
        this.tripPlanUrl = tripPlanUrl;
        this.dressingTip = dressingTip;
    }

    public void setGreetingMessage(){
        greetingMessage = "Happy birthday, my friend! \n" +
                "On this special day I would like to cheer you up with this sweet little song :) \n" +
                musicVideoLink + "\n" +
                "If You want to go out tonight, ";
    }

    public String getGreetingMessage() {
        return greetingMessage;
    }
}
