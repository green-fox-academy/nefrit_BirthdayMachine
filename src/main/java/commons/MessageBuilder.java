package commons;

public class MessageBuilder {

    private String greetingMessage;
    private String musicVideoLink;
    private String eventTitle;
    private String restaurantName;
    private String tripPlanUrl;
    private String dressingSuggestion;

    public MessageBuilder(String musicVideoLink, String eventTitle, String restaurantName, String tripPlanUrl, int temperature) {
        this.musicVideoLink = musicVideoLink;
        this.eventTitle = eventTitle;
        this.restaurantName = restaurantName;
        this.tripPlanUrl = tripPlanUrl;
        this.dressingSuggestion = buildDressingSuggestionMessage(temperature);
    }

    public void setGreetingMessage(){
        greetingMessage = "Happy birthday, my friend! " +
                "On this special day I would like to cheer you up with this sweet little song :) " +
                musicVideoLink + " If You want to go out tonight, I can suggest You this event: " + eventTitle +
                " And after that we can have a bite at " + restaurantName + ", and travel there like this: " +
                tripPlanUrl + ". " + dressingSuggestion + " Let me know how you feel about this. :)";
    }

    public String getGreetingMessage() {
        return greetingMessage;
    }

    public String buildDressingSuggestionMessage(int temperature){
        if(temperature < 5){
            return "Bring your winter coat, it will be really cold!";
        } else if(temperature >= 5 && temperature < 15){
            return "Bring some warm clothes, it's going to be cold tonight.";
        } else if(temperature >= 15 && temperature < 22){
            return "Bring a sweater, the weather is going to be cool tonight.";
        } else {
            return "Dress lightly, the weather is going to be pleasant tonight.";
        }
    }
}
