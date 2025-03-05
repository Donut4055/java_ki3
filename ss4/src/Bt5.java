import java.util.Scanner;
import static java.lang.Math.sqrt;

public class Bt5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int mark = 0;

        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    sum += j;
                }
            }

            if (i == sum) {
                System.out.print(i + ", ");
                mark = 1;
            }
        }

        if (mark == 0) {
            System.out.println("Khong co so hoan hao nao");
        }
    }
}