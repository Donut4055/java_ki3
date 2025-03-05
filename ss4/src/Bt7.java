import java.util.Scanner;

public class Bt7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 1; i < n; i++) {
            int temp = i, sum = 0;

            while (temp != 1 && temp != 4) {
                sum = 0;
                int num = temp;

                while (num != 0) {
                    int digit = num % 10;
                    sum += digit * digit;
                    num /= 10;
                }
                temp = sum;
            }

            if (temp == 1) {
                System.out.print(i + ", ");
            }
        }
    }
}