import java.util.Scanner;

public class Bt4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder str = new StringBuilder(sc.nextLine());
        String str1 = str.toString().toLowerCase();
        String str2 = str.reverse().toString().toLowerCase();
        if (str1.equals(str2)) {
            System.out.println("chuoi doi xung");
        } else {
            System.out.println("chuoi khong doi xung");
        }
    }
}