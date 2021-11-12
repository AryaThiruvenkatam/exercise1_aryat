package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    public static Properties getPropertyObject() throws IOException

    {
       FileInputStream fp = new FileInputStream("Config\\config.properties");

        Properties prop = new Properties();
        prop.load(fp);
        return prop;

    }

    public static String geturl() throws IOException {

        return getPropertyObject().getProperty("url1");

    }

    public static String geturl1() throws IOException {

        return getPropertyObject().getProperty("url2");

    }
}
