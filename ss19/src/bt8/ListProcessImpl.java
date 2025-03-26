package bt8;

import java.util.List;
import java.util.function.Predicate;

class ListProcessImpl implements ListProcess {
    @Override
    public int sumOddNumbers(List<Integer> list) {
        Predicate<Integer> isOdd = num -> num % 2 != 0;

        return list.stream()
                .filter(isOdd)
                .mapToInt(Integer::intValue)
                .sum();
    }
}