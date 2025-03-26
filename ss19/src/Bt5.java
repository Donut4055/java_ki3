import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bt5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            strings.add(scanner.next());
        }
        long count = strings.stream()
                .filter(str -> str.startsWith("A"))
                .filter(str -> str.length() >= 5)
                .count();

        System.out.println( count);

    }
}