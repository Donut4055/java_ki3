import java.util.Scanner;

public class Bt5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        char math = sc.next().charAt(0);
        int b = sc.nextInt();
        switch (math) {
            case '+':
                System.out.println(a + b);
                break;
            case '-':
                System.out.println(a - b);
                break;
            case '*':
                System.out.println(a * b);
                break;
            case '/':
                if (b == 0) {
                    System.out.println("khong co chia cho 0");
                } else {
                    System.out.println(a / b);
                }
                break;
            default:
                System.out.println("phep toan nhap vao khong hop le");
                break;
        }
    }
}
