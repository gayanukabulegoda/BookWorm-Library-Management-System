package lk.ijse.bookWormLibraryManagementSystem.util;

import java.util.regex.Pattern;

public class RegExPatterns {

    public static boolean namePattern(String name) {
        return !Pattern.matches("[A-Za-z\\s]{2,}", name);
    }

    public static boolean contactNoPattern(String contactNo) {
        return !Pattern.matches("(0\\d{9})", contactNo);
    }

    public static boolean emailPattern(String email) {
        return !Pattern.matches("([A-Za-z0-9]{3,}@[A-Za-z]{3,}\\.[A-Za-z]{1,})", email);
    }

    public static boolean idPattern(String value) {
        return !Pattern.matches("(\\d+)", value);
    }

    public static boolean otpPattern(String otp) {
        return !Pattern.matches("[0-9]{6}", otp);
    }

    public static boolean passwordPattern(String password) {
        return !Pattern.matches(".{5,25}", password);
    }

}