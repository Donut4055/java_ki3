import java.util.Scanner;

public class Bt1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        String s3 = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        sb.append(s1).append(" ").append(s2).append(" ").append(s3);
        System.out.println(sb.toString().toUpperCase());
    }
}
