package lk.ijse.bookWormLibraryManagementSystem.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Random;

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

    public static String generateOTP() {
        String numbers = "0123456789";
        StringBuilder otp = new StringBuilder(6);

        Random random = new Random();

        for (int i = 0; i < 6; i++) {
            int index = random.nextInt(numbers.length());
            char digit = numbers.charAt(index);
            otp.append(digit);
        }
        return otp.toString();
    }

}
