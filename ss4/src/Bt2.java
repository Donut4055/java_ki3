import java.util.Scanner;
import static java.lang.Math.sqrt;

public class Bt2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean isPrime = true;

        if (n < 2) {
            isPrime = false;
        } else if (n == 2 || n == 3 || n == 5 || n == 7) {
            isPrime = true;
        } else if (n % 2 == 0 || n % 3 == 0) {
            isPrime = false;
        } else {
            int i = -1;
            while (i < sqrt(n)) {
                i += 6;
                if (n % i == 0 || n % (i + 2) == 0) {
                    isPrime = false;
                    break;
                }
            }
        }

        if (isPrime) {
            System.out.println(n + " la so nguyen to");
        } else {
            System.out.println(n + " khong la so nguyen to");
        }
    }
}
