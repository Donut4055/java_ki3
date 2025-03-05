import java.util.Scanner;

public class Bt4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int n = 0;
        while (true){
            n = sc.nextInt();
            sum += n;
            if (n == 0) {
                System.out.println("Tong la: " + sum);
                break;
            }
        }
    }
}
