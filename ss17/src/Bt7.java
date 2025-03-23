import java.util.*;

public class Bt7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        String[] words = text.toLowerCase().split("\\W+");

        HashSet<String> uniqueWords = new HashSet<>();

        List<String> allWords = new ArrayList<>();

        for (String word : words) {
            if (!word.isEmpty()) {
                uniqueWords.add(word);
                allWords.add(word);
            }
        }

        TreeSet<String> sortedUniqueWords = new TreeSet<>(uniqueWords);

        for (String word : sortedUniqueWords) {
            int frequency = Collections.frequency(allWords, word);
            System.out.println(word + ": " + frequency);
        }

        scanner.close();
    }
}