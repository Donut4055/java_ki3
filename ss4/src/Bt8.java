import java.util.Scanner;

public class Bt8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean found = false;

        for (int i = 1; i <= n; i++) {
            int  sum = 0, digits = 0;
            int num = i;

            while (num > 0) {
                digits++;
                num /= 10;
            }

            num = i;
            while (num > 0) {
                int digit = num % 10;
                sum += Math.pow(digit, digits);
                num /= 10;
            }

            if (sum == i) {
                System.out.print(i + ", ");
                found = true;
            }
        }

        if (!found) {
            System.out.println("Khong co so Armstrong nao");
        }
    }
}
