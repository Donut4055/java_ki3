import java.util.Scanner;

public class bt4 {
    public static void main(String[] args) {
        boolean a, b, c;

        Scanner scanner = new Scanner(System.in);
        a = scanner.nextBoolean();
        b = scanner.nextBoolean();
        c = scanner.nextBoolean();

        boolean condition1 = a && b;
        boolean condition2 = a || b;
        boolean condition3 = !c;

        if (condition1) {
            System.out.println("Cả hai đều đúng");
        }
        if (condition2) {
            System.out.println("Ít nhất một đúng");
        }
        if (!a && b) {
            System.out.println("Không đúng");
        }

        System.out.println(condition1 ? "Cả hai giá trị a và b đều đúng" : "Hoặc a sai hoặc b sai");
        System.out.println(condition2 ? "Trong a và b có ít nhất 1 giá trị đúng" : "Cả 2 giá trị a và b đều sai");
        System.out.println(condition3 ? "Phủ định của c là đúng" : "Phủ định của c là sai");
    }
}
