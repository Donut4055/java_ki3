import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Bt6 {
    public static void main(String[] args) {
        List<String> items = List.of("apple", "banana", "apple", "orange", "banana", "apple");
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String formatted = time.format(formatter);
        System.out.println(formatted);

        Map<String, Long> itemCounts = items.stream()
                .collect(Collectors.groupingBy(item -> item, Collectors.counting()));

        System.out.println(itemCounts);

    }
}
