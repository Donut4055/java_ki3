import java.util.Scanner;

public class Bt2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        if (a == b & b == c ) {
            System.out.println("3 so bang nhau");
            return;
        }
        int max = a;
        max = (max > b) ? max : b;
        max = (max > c) ? max : c;
        System.out.println("so lon nhat la: " + max);
    }
}
