import java.util.Scanner;

import static java.lang.Math.sqrt;

public class Bt5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            String input = sc.nextLine();
            int number = Integer.parseInt(input);

            if (number <= 0) {
                throw new IllegalArgumentException("Lỗi: Số phải là số nguyên dương lớn hơn 0!");
            }

            boolean isPrime =isPrime(number);
            if (isPrime) {
                System.out.println(number + " là số nguyên tố.");
            } else {
                System.out.println(number + " không phải là số nguyên tố.");
            }

        } catch (NumberFormatException e) {
            System.out.println("Lỗi: Bạn phải nhập một số nguyên!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            sc.close();
        }
    }

    public static boolean isPrime(int n)  {
        if (n < 2) {
            return false;
        } else if (n == 2 || n == 3 || n == 5 || n == 7) {
            return true;
        } else if (n % 2 == 0 || n % 3 == 0) {
            return false;
        } else {
            int i = -1;
            while (i < sqrt(n)) {
                i += 6;
                if (n % i == 0 || n % (i + 2) == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
