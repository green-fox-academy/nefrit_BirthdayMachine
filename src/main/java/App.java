import commons.DriverUtility;
import commons.PropertyUtility;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class App {

    private static WebDriver driver;
    private static Map<String, String> config = new HashMap<>();



    public static void main(String[] args) {

        PropertyUtility.getPropertyFileContent(config);
        driver = DriverUtility.startUp(driver, config, false, true, true);
        driver.get("https://facebook.com");





    }
}
