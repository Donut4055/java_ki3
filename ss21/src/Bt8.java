import java.util.ArrayList;
import java.util.Scanner;

public class Bt8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        String[] phoneNumbers = input.split(",");

        ArrayList<String> validNumbers = new ArrayList<>();
        ArrayList<String> invalidNumbers = new ArrayList<>();

        for (String phone : phoneNumbers) {
            String trimmedPhone = phone.trim();
            try {
                if (isValidPhoneNumber(trimmedPhone)) {
                    validNumbers.add(trimmedPhone);
                } else {
                    invalidNumbers.add(trimmedPhone);
                }
            } catch (Exception e) {
                invalidNumbers.add(trimmedPhone);
            }
        }

        System.out.println("\nKết quả kiểm tra:");
        System.out.println("Số điện thoại hợp lệ (" + validNumbers.size() + "):");
        if (validNumbers.isEmpty()) {
            System.out.println("Không có số nào hợp lệ.");
        } else {
            for (String valid : validNumbers) {
                System.out.println(valid);
            }
        }

        System.out.println("\nSố điện thoại không hợp lệ (" + invalidNumbers.size() + "):");
        if (invalidNumbers.isEmpty()) {
            System.out.println("Không có số nào không hợp lệ.");
        } else {
            for (String invalid : invalidNumbers) {
                System.out.println(invalid + " - Lý do: " + getInvalidReason(invalid));
            }
        }

    }

    public static boolean isValidPhoneNumber(String phone) throws Exception {
        if (phone.length() != 10) {
            return false;
        }

        for (char c : phone.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        return true;
    }

    public static String getInvalidReason(String phone) {
        if (phone.length() != 10) {
            return "Độ dài không đúng (phải 10 chữ số)";
        }
        for (char c : phone.toCharArray()) {
            if (!Character.isDigit(c)) {
                return "Chứa ký tự không phải số";
            }
        }
        return "Lỗi không xác định";
    }
}