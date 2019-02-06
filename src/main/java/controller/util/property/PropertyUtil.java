package controller.util.property;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtil {
    private static Properties properties = initProperties();

    private static Properties initProperties() {
        Properties prop = new Properties();
        InputStream input = null;
        try {
            String fileName = "clearing.properties";
            input = PropertyUtil.class.getClassLoader().getResourceAsStream(fileName);
            if (input == null) {
                System.out.println("Sorry, unable to find " + fileName);
                return null;
            }
            prop.load(input);

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return prop;
    }

    public static String getProperty(String key) {
        if(properties == null) return null;
        return properties.getProperty(key);
    }
}
