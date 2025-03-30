import java.util.Scanner;

public class Bt1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        try {
            if (b == 0) {
                throw new ArithmeticException("Chia cho 0");
            }
            double c = (double) a / b;
            System.out.println(c);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}
