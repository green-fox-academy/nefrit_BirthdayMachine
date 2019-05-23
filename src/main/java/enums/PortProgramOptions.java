package enums;

public enum PortProgramOptions {

    TVEVENT("Tv"),
    CINEMAEVENT("Mozi"),
    THEATER("Színház"),
    CONCERT("Koncert"),
    FESTIVAL("Fesztivál"),
    EXHIBITION("Kiállítás"),
    BOOK("Könyv"),
    OTHER("Egyéb");

    private final String value;

    PortProgramOptions(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}

