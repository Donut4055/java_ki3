package test.util;

public class Validator {
    public static boolean validateInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean validateFloat(String input) {
        try {
            Float.parseFloat(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean validateDouble(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean validateBoolean(String input) {
        if (input == null || input.trim().isEmpty()) {
            return false;
        }
        String inputString = input.trim();
        return inputString.equalsIgnoreCase("true") || inputString.equalsIgnoreCase("false");
    }

    public static boolean validateString(String input) {
        if (input == null || input.trim().isEmpty()) {
            return false;
        }
        String inputString = input.trim();
        int minLength = 1;
        int maxLength = 100;
        return inputString.length() >= minLength && inputString.length() <= maxLength;
    }

    public static boolean validateEmail(String input) {
        if (input == null || input.trim().isEmpty()) {
            return false;
        }
        String inputString = input.trim();
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return inputString.matches(emailRegex);
    }

    public static boolean validatePhoneNumber(String input) {
        if (input == null || input.trim().isEmpty()) {
            return false;
        }
        String inputString = input.trim();
        String phoneRegex = "^(032|033|034|035|036|037|038|039|096|097|098|086|083|084|085|081|082|088|091|094|070|079|077|076|078|090|093|089|056|058|092|059)[0-9]{7}$";
        return inputString.matches(phoneRegex);
    }
}
