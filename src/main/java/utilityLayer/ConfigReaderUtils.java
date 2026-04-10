package utilityLayer;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import constant.FrameworkConstant;

public class ConfigReaderUtils {

    private static Properties prop = new Properties();

    static {

        try {
            FileInputStream fis = new FileInputStream(FrameworkConstant.QA_CONFIG_PATH);
            prop.load(fis);
        } 
        catch (IOException e) {
            throw new RuntimeException("Failed to load config file");
        }

    }

    public static String readProperty(String key) {

        return prop.getProperty(key);
    }
}
