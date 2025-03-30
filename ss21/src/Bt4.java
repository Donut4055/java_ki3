import java.util.Scanner;

public class Bt4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            int number = sc.nextInt();
            System.out.println( number);
        } catch (java.util.InputMismatchException e) {
            System.out.println("Lỗi: Bạn phải nhập số nguyên!");
        } finally {
            System.out.println("Cảm ơn bạn đã sử dụng chương trình!");
        }
    }
}