import java.util.Scanner;

public class Bt3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int age = scan.nextInt();

        try {
            checkAge(age);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        scan.close();
    }

    public static void checkAge(int age) throws Exception {
        if (age < 18) {
            throw new Exception("Bạn chưa đủ 18 tuổi!");
        } else {
            System.out.println("Chào mừng bạn!");
        }
    }
}