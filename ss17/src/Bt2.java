import java.util.HashSet;
import java.util.Scanner;

public class Bt2 {
    public static void main(String[] args) {
        HashSet<String> languages = new HashSet<>();
        languages.add("Java");
        languages.add("Python");
        languages.add("C++");
        languages.add("JavaScript");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (languages.contains(input)) {
            System.out.println(input + " tồn tại trong HashSet!");
        } else {
            System.out.println(input + " không tồn tại trong HashSet!");
        }

        scanner.close();
    }
}
