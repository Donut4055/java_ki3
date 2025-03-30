import java.util.ArrayList;
import java.util.Scanner;

public class Bt6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        ArrayList<String> strings = new ArrayList<>();
        ArrayList<Integer> validNumbers = new ArrayList<>();

        System.out.println("Nhập " + n + " chuỗi:");
        for (int i = 0; i < n; i++) {
            strings.add(sc.nextLine());
        }

        int validCount = 0;
        int invalidCount = 0;

        for (String str : strings) {
            try {
                int number = Integer.parseInt(str);
                validNumbers.add(number);
                validCount++;
            } catch (NumberFormatException e) {
                invalidCount++;
            }
        }

        System.out.println("Số chuỗi hợp lệ: " + validCount);
        System.out.println("Số chuỗi không hợp lệ: " + invalidCount);

        if (validCount > 0) {
            System.out.println("Danh sách các số nguyên hợp lệ:");
            for (int num : validNumbers) {
                System.out.println(num);
            }
        } else {
            System.out.println("Không có số nguyên hợp lệ nào.");
        }

    }
}