package commons;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Map;

public class PropertyUtility {

    public static void getPropertyFileContent(Map<String, String> content){
        Properties prop = new Properties();
        try {
            FileInputStream inputStream = new FileInputStream("./src/main/java/properties/config.properties");
            prop.load(inputStream);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String key : prop.stringPropertyNames()) {
            content.put(key, prop.get(key).toString());
        }
    }
}
