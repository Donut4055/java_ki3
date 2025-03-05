import java.util.Scanner;

public class Bt9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean found = false;

        for (int i = 1; i <= n; i++) {
            int original = i;
            int reversed = 0;
            int temp = i;

            while (temp > 0) {
                reversed = reversed * 10 + temp % 10;
                temp /= 10;
            }

            if (original == reversed) {
                System.out.print(i + ", ");
                found = true;
            }
        }

        if (!found) {
            System.out.println("Khong co so Palindrome nao");
        }
    }
}
