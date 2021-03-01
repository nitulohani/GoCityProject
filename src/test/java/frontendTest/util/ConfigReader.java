package frontendTest.util;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    public static Properties getAllProperties() {
        return
                loadProperties();
    }

    public static String getProperty(String key) {
        Properties prop = loadProperties();
        return prop.get(key).toString();
    }

    @NotNull
    private static Properties loadProperties() {
        try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream("config/Config.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            return prop;
        } catch (IOException ex) {
            throw new RuntimeException("Something Went Wrong File loading Properties");
        }
    }


}
