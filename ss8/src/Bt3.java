import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bt3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String email = sc.nextLine();
        String password = sc.nextLine();
        boolean emailValid = false, passwordValid = false;
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        if (email.matches(emailRegex)) {
            emailValid = true;
        }


        if (password.length() < 8) {
            System.out.println("Invalid password");
            return;
        }
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;
        String specialChars = "@#$!%";

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (specialChars.indexOf(c) >= 0) {
                hasSpecialChar = true;
            }
        }
        if (hasUpperCase && hasLowerCase && hasDigit && hasSpecialChar) {
            passwordValid = true;
        }

        if (emailValid && passwordValid) {
            System.out.println("email va mat khau hop le");
        } else if (emailValid) {
            System.out.println("email hop le, mat khau khong hop le");
        } else if (passwordValid) {
            System.out.println("email khong hop le, mat khau hop le");
        } else {
            System.out.println("email va mat khau khong hop le");
        }
    }
}
