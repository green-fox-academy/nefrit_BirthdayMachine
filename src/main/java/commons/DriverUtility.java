package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Map;

public class DriverUtility {

    public static void openBrowser(WebDriver driver, String mainPage) {
        driver.get(mainPage);
    }

    public static void closeBrowser(WebDriver driver) {
        driver.close();
    }

    public static void quitSession(WebDriver driver) {
        driver.quit();
    }

    public static void maximizeBrowser(WebDriver driver) {
        driver.manage().window().maximize();
    }

    public static void fullScreenBrowser(WebDriver driver) {
        driver.manage().window().fullscreen();
    }

    public static void refreshPage(WebDriver driver) {
        driver.navigate().refresh();
    }

    public static void deleteAllCookies(WebDriver driver) {
        driver.manage().deleteAllCookies();
    }

    public static WebDriver startUp(WebDriver driver, Map<String,String> configuration, boolean headlessMode, boolean deleteAllCookies, boolean maximizeBrowser) {
        if (GlobalVariables.GENERAL_EXPLICIT_TIMEOUT < 0) {
            GlobalVariables.GENERAL_EXPLICIT_TIMEOUT = Long.parseLong(configuration.get("explicitWaitTimeOut"));
        }
        FirefoxOptions options = new FirefoxOptions();
        if (configuration.get("headless").equals("yes") || (configuration.get("headless").equals("custom") && headlessMode)){
            options.setHeadless(true);
        } else if (configuration.get("headless").equals("no") || (configuration.get("headless").equals("custom") && !headlessMode)){
            options.setHeadless(false);
        }
        options.addPreference("dom.webnotifications.enabled", false);
        driver = new FirefoxDriver(options);

        if (deleteAllCookies) {
            driver.manage().deleteAllCookies();
        }
        if (maximizeBrowser) {
            driver.manage().window().maximize();
        }
        return driver;
    }
}
