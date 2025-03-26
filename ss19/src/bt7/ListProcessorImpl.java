package bt7;

import java.util.List;
import java.util.function.Predicate;

class ListProcessorImpl implements ListProcessor {
    @Override
    public boolean containsNegative(List<Integer> list) {
        Predicate<Integer> isNegative = num -> num < 0;

        return list.stream()
                .anyMatch(isNegative);
    }
}

