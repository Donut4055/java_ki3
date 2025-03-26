package bt6;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] stringArray = {"Java", "Python"};
        List<String> stringList = Arrays.asList(stringArray);

        StringProcessor processor = (input) -> input.toUpperCase() + " - TECHNICAL";

        List<String> processedList = stringList.stream()
                .map(processor::processString)
                .toList();

        processor.printList(processedList);
    }
}
