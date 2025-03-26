package bt8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;





public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 4, 6, 8, 10);

        ListProcess process = new ListProcessImpl();

        boolean hasOdd = process.checkOdd(numbers);
        System.out.println("Danh sách có chứa số lẻ không? " + hasOdd);
        int sumOdd1 = process.sumOddNumbers(numbers);
        System.out.println("Tổng các số lẻ: " + sumOdd1);

        List<Integer> oddNumbers = numbers.stream()
                .filter(num -> num % 2 != 0)
                .toList();
        if (oddNumbers.isEmpty()) {
            System.out.println("Không có số lẻ trong danh sách.");
        } else {
            ListProcess.printList(oddNumbers);
        }

    }
}