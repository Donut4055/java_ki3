import java.util.Scanner;

public class Bt1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        if (a == 0) {
            System.out.println(a + " khong phai so chan hay le");
        } else  if (a%2 == 0){
            System.out.println(a + " la so chan");
        } else {
            System.out.println(a + " la so le");
        }
    }
}
