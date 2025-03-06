import java.util.Scanner;

public class Bt1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        String[] words = str.trim().split("\\s+");

        int wordCount = (str.trim().isEmpty()) ? 0 : words.length;

        System.out.println(wordCount);

    }
}
