package bt7;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5);

        ListProcessor processor = new ListProcessorImpl();

        boolean hasNegative1 = processor.containsNegative(numbers1);
        System.out.println(hasNegative1);
    }
}