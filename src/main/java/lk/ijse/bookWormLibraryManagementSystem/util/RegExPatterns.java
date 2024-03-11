package lk.ijse.bookWormLibraryManagementSystem.util;

import java.util.regex.Pattern;

public class RegExPatterns {

    public static boolean namePattern(String name) {
        return !Pattern.matches("[A-Za-z\\s]{3,}", name);
    }

    public static boolean contactNoPattern(String contactNo) {
        return !Pattern.matches("(0\\d{9})", contactNo);
    }

    public static boolean emailPattern(String email) {
        return !Pattern.matches("([A-Za-z0-9]{3,}@[A-Za-z]{3,}\\.[A-Za-z]{1,})", email);
    }

    public static boolean firstLastNamePattern(String name) {
        return !Pattern.matches("([A-Z][a-z]{2,})", name);
    }

    public static boolean nicPattern(String nic) {
        return !Pattern.matches("([\\dV]{10,12})", nic);
    }

    public static boolean houseNoPattern(String houseNo) {
        return !Pattern.matches("([\\d]{1,})", houseNo);
    }

    public static boolean qtyPattern(String value) {
        return !Pattern.matches("(\\d+)", value);
    }

    public static boolean pricePattern(String value) {
        return !Pattern.matches("([\\d.]+)", value);
    }

    public static boolean otpPattern(String otp) {
        return !Pattern.matches("[0-9]{6}", otp);
    }

    public static boolean userNamePattern(String userName) {
        return !Pattern.matches("([A-Za-z]+)", userName);
    }

    public static boolean passwordPattern(String password) {
        return !Pattern.matches(".{6,25}", password);
    }

    public static boolean employeeIdPattern(String employeeId) {
        return !Pattern.matches("(E-00)\\d+", employeeId);
    }

    public static boolean customerOrderIdPattern(String customerOrderId) {
        return !Pattern.matches("(CO-0)\\d+", customerOrderId);
    }

    public static boolean supplierOrderIdPattern(String supplierOrderId) {
        return !Pattern.matches("(SO-0)\\d+", supplierOrderId);
    }
}