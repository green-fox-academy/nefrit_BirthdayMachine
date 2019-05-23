package pages;

import commons.DriverUtility;
import commons.GlobalVariables;
import commons.PropertyUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

public class PostcardSender {

    private static final String[] emojis = new String[] {
            " (_mosoly_) ", " (_nevet_) ", " (_szomoru_) ", " (_kacsint_) ", " (_nyelv_) ",
            " (_csodalkozo_) ", " (_sir_) ", " (_szemuveg_) ", " (_alszom_) ", " (_szarkasztikus_) ",
            " (_szegyenlos_) ", " (_nemtudom_) ", " (_lakat_) ", " (_beteg_) ", " (_duhos_) ",
            " (_parti_) ", " (_nap_) ", " (_csillag_) ", " (_ok_) ", " (_sziv_) ",
            " (_sziv2_) ", " (_csok_) ", " (_level_) ", " (_virag_) ", " (_virag2_) ",
            " (_virag3_) ", " (_virag4_) ", " (_virag5_) ", " (_virag6_) ", " (_rozsa1_) ",
            " (_rozsa2_) ", " (_rozsa3_) ", " (_torta1_) ", " (_torta2_) ", " (_torta3_) ",
            " (_tigris_) ", " (_pingvin_) ", " (_cica_) ", " (_kutya_) ", " (_ajandek_) ",
            " (_ajandek2_) ", " (_udito_) ", " (_koktel_) ", " (_koktel2_) ", " (_sor1_) ",
            " (_sor2_) ", " (_bor_) ",
    };
    private static final By quoteMenu = By.id("Idezetek");
    private static final By postcardTitle = By.xpath("//*[@id=\"tartalom\"]/table/tbody/tr/td[1]/form/div/div[2]/input");
    private static final By postcardBody = By.xpath("//*[@id=\"tartalom\"]/table/tbody/tr/td[1]/form/div/div[3]/textarea");
    private static final By signatureField = By.xpath("//*[@id=\"tartalom\"]/table/tbody/tr/td[1]/form/div/div[5]/input");
    private static final By receiverNameField = By.xpath("//*[@id=\"tartalom\"]/table/tbody/tr/td[1]/form/div/div[6]/input");
    private static final By receiverEmailField = By.xpath("//*[@id=\"tartalom\"]/table/tbody/tr/td[1]/form/div/div[7]/input");
    private static final By ownNameField = By.xpath("//*[@id=\"tartalom\"]/table/tbody/tr/td[1]/form/div/div[8]/input");
    private static final By ownEmailField = By.xpath("//*[@id=\"tartalom\"]/table/tbody/tr/td[1]/form/div/div[9]/input");
    private static final By sendPostcardButton = By.xpath("/html/body/div[2]/ul/li[1]/form/input[21]");
    private static final By postcardFontColorMenu = By.xpath("//*[@id=\"tartalom\"]/table/tbody/tr/td[1]/form/div/div[10]/div[1]/label/select");
    private static final By postcardFontTypeMenu = By.xpath("//*[@id=\"tartalom\"]/table/tbody/tr/td[1]/form/div/div[11]/div[1]/label/select");
    private static final By postcardFontSizeMenu = By.xpath("//*[@id=\"tartalom\"]/table/tbody/tr/td[1]/form/div/div[12]/div/label/select");
    private static final By postcardBackgroundColorMenu = By.xpath("//*[@id=\"tartalom\"]/table/tbody/tr/td[1]/form/div/div[13]/div[1]/label/select");
    private static final By postcardStampMenu = By.xpath("//*[@id=\"tartalom\"]/table/tbody/tr/td[1]/form/div/div[14]/div[1]/label/select");
    private static final By postcardBackgroundMenu = By.xpath("//*[@id=\"tartalom\"]/table/tbody/tr/td[1]/form/div/div[15]/div[1]/label/select");
    private static final By postcardBackgroundSong = By.xpath("//*[@id=\"tartalom\"]/table/tbody/tr/td[1]/form/div/div[17]/div/label/select");

    private static WebDriver driver;
    private static Map<String, String> config = new HashMap<>();

    PostcardSender(WebDriver extDriver, String postcardTitle, String postcardBodyMessage, String signature,
              String receiverUsername, String receiverEmail, String ownUsername, String ownEmail) {

        /*
        postcardBodyMessage can contain emojis:

                    The syntax is : $[1-47] where the number is the emoji type from the emojis array.

                    e.g.: passing "happy $1" will look like this: "happy 🙂"

                    DO NOT write two consecutive emojis, like "happy wink $1 $4" because the message will look weird.
         */

        driver = extDriver;
        PropertyUtility.getPropertyFileContent(config);
        driver = DriverUtility.startUp(driver, config, false, true, true);
        driver.get("https://www.e-kepeslap.com/kepeslapkuldes-13-szuletesnapi-kepeslapok.html");
        ((JavascriptExecutor) driver)
                .executeScript(String.format(
                        "document.querySelector(\"#tartalom > table > tbody > tr > td.fo > div > ul > li:nth-child(%s) > a > img\").click()",
                        1 + (int)(Math.random() * 24)
                ));
        fillPostcardTitle(postcardTitle);
        fillPostcardBody(postcardBodyMessage);
        selectQuote();
        fillSignature(signature);
        fillReceiverData(receiverUsername, receiverEmail);
        fillOwnData(ownUsername, ownEmail);
        selectPostcardFontColor();
        selectPostcardFontType();
        selectPostcardFontSize();
        selectPostcardBackground();
        selectPostcardBackgroundColor();
        selectPostcardStamp();
        selectPostcardBackground();
        selectPostcardSong();
        submitPostcard();
        sendPostcard();

    }

    private static void fillPostcardTitle(String text) {
        new WebDriverWait(driver, GlobalVariables.GENERAL_EXPLICIT_TIMEOUT)
                .until(ExpectedConditions.presenceOfElementLocated(postcardTitle)).sendKeys(text);
    }

    private static void fillPostcardBody(String text) {
        text = encodeEmojis(text);
        new WebDriverWait(driver, GlobalVariables.GENERAL_EXPLICIT_TIMEOUT)
                .until(ExpectedConditions.presenceOfElementLocated(postcardBody)).sendKeys(text);
    }

    private static void fillSignature(String text) {
        new WebDriverWait(driver, GlobalVariables.GENERAL_EXPLICIT_TIMEOUT)
                .until(ExpectedConditions.presenceOfElementLocated(signatureField)).sendKeys(text);
    }

    private static void fillReceiverData(String name, String email) {
        new WebDriverWait(driver, GlobalVariables.GENERAL_EXPLICIT_TIMEOUT)
                .until(ExpectedConditions.presenceOfElementLocated(receiverNameField)).sendKeys(name);
        new WebDriverWait(driver, GlobalVariables.GENERAL_EXPLICIT_TIMEOUT)
                .until(ExpectedConditions.presenceOfElementLocated(receiverEmailField)).sendKeys(email);
    }

    private static void fillOwnData(String name, String email) {
        new WebDriverWait(driver, GlobalVariables.GENERAL_EXPLICIT_TIMEOUT)
                .until(ExpectedConditions.presenceOfElementLocated(ownNameField)).sendKeys(name);
        new WebDriverWait(driver, GlobalVariables.GENERAL_EXPLICIT_TIMEOUT)
                .until(ExpectedConditions.presenceOfElementLocated(ownEmailField)).sendKeys(email);
    }

    private static void selectQuote() {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -2000)");
        selectFromMenu(quoteMenu, 48);
    }

    private static void selectPostcardFontColor() {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -500)");
        selectFromMenu(postcardFontColorMenu, 61);
    }

    private static void selectPostcardFontType() {
        selectFromMenu(postcardFontTypeMenu, 16);
    }

    private static void selectPostcardFontSize() {
        selectFromMenu(postcardFontSizeMenu, 3);
    }

    private static void selectPostcardBackgroundColor() {
        selectFromMenu(postcardBackgroundColorMenu, 61);
    }

    private static void selectPostcardStamp() {
        selectFromMenu(postcardStampMenu, 44);
    }

    private static void selectPostcardBackground() {
        selectFromMenu(postcardBackgroundMenu, 129);
    }

    private static void selectPostcardSong() {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -500)");
        selectFromMenu(postcardBackgroundSong, 64);
    }

    private static void submitPostcard() {
        ((JavascriptExecutor) driver)
                .executeScript("document.querySelector(\"#tartalom > table > tbody > tr > td.fo > form > div > div:nth-child(23) > input\").click()");
    }

    private static void sendPostcard() {
        new WebDriverWait(driver, GlobalVariables.GENERAL_EXPLICIT_TIMEOUT)
                .until(
                        ExpectedConditions.and(
                                ExpectedConditions.presenceOfElementLocated(sendPostcardButton),
                                ExpectedConditions.elementToBeClickable(sendPostcardButton)
                        )
                );
        ((JavascriptExecutor) driver)
                .executeScript("document.querySelector(\"body > div.center > ul > li:nth-child(1) > form > input.gombkek\").click()");
    }

    private static String encodeEmojis(String text) {
        while (text.contains("$")) {
            int emojiCode;
            String charCodes = "";
            int startCodeIndex = text.indexOf('$');
            int charCodeLength = startCodeIndex + 2;

            for (int i = 1; i < 3; i++) {
                int c = text.charAt(text.indexOf('$') + i);
                if (c > 48 && c < 58) {
                    charCodes += (char) c;
                    charCodeLength += 1;
                }
            }

            try {
                emojiCode = Integer.parseInt(charCodes);
                if (emojiCode > -1 && emojiCode < 48) {
                    text = text.substring(0, startCodeIndex - 1) + emojis[emojiCode] + text.substring(charCodeLength);
                }
            }
            catch (NumberFormatException e) {
                System.out.println(charCodes + " IS NOT A VALID EMOJI CODE");
            }
        }

        return text;
    }

    private static void selectFromMenu(By menu, int menuMaxIndex) {
        new WebDriverWait(driver, GlobalVariables.GENERAL_EXPLICIT_TIMEOUT)
                .until(
                        ExpectedConditions.and(
                                ExpectedConditions.presenceOfElementLocated(menu),
                                ExpectedConditions.visibilityOfElementLocated(menu),
                                ExpectedConditions.elementToBeClickable(menu)
                        )
                );

        while (true) {
            try {
                new Select(driver.findElement(menu)).selectByIndex(1 + (int)(Math.random() * menuMaxIndex));
                break;
            } catch (ElementClickInterceptedException e) {
                ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -20)");
            }
        }
    }

}
