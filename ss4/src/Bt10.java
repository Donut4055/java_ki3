import java.util.Scanner;

public class Bt10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\nMENU:");
            System.out.println("1. Kiểm tra số nguyên tố");
            System.out.println("2. Kiểm tra số hoàn hảo");
            System.out.println("3. Tìm và tính tổng các ước của số");
            System.out.println("4. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = sc.nextInt();

            if (choice == 4) {
                System.out.println("Thoát chương trình.");
                break;
            }

            System.out.print("Nhập một số nguyên dương: ");
            int n = sc.nextInt();

            switch (choice) {
                case 1:
                    if (isPrime(n)) {
                        System.out.println(n + " là số nguyên tố.");
                    } else {
                        System.out.println(n + " không phải là số nguyên tố.");
                    }
                    break;
                case 2:
                    if (isPerfect(n)) {
                        System.out.println(n + " là số hoàn hảo.");
                    } else {
                        System.out.println(n + " không phải là số hoàn hảo.");
                    }
                    break;
                case 3:
                    int sumDivisors = sumOfDivisors(n);
                    System.out.println("Tổng các ước của " + n + " là: " + sumDivisors);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
        sc.close();
    }

    public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static boolean isPerfect(int n) {
        int sum = 0;
        for (int i = 1; i < n; i++) {
            if (n % i == 0) sum += i;
        }
        return sum == n;
    }

    public static int sumOfDivisors(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) sum += i;
        }
        return sum;
    }
}
