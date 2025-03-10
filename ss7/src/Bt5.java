import java.util.Scanner;

public class Bt5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] arr = str.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length -1; i >= 0 ; i--) {
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb);
    }
}
