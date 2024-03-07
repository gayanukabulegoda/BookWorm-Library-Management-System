package lk.ijse.bookWormLibraryManagementSystem.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Utility {

    public static Properties getProperties() {
        Properties properties = new Properties();
        try {
            InputStream input = Utility.class.getResourceAsStream("/files/hibernate.properties");
            properties.load(input);
        } catch (IOException e) {
            System.out.println("Property File Not Found!");
            e.printStackTrace();
        }
        return properties;
    }

}
