import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Bt1 {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList(
                "Hello",
                "",
                "Java 8",
                " ",
                "Predicate",
                ""
        );

        filterNonEmptyStrings(strings);
    }

    public static void filterNonEmptyStrings(List<String> stringList) {
        Predicate<String> isNotEmpty = str -> !str.trim().isEmpty();

        List<String> filteredList = stringList.stream()
                .filter(isNotEmpty)
                .toList();
        System.out.println(filteredList);
    }
}
