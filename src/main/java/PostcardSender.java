import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class PostcardSender {

    private static WebDriver driver;
    private static Map<String, String> config = new HashMap<>();
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
}
