import java.util.List;

public class Bt1 {
    public static void main(String[] args) {
        List<Integer> arr = List.of(1, 2, 3, 4, 5);
        arr.stream()
                .filter(e -> e % 2 == 0)
                .forEach(System.out::print);
    }
}
