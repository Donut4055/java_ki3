import java.util.ArrayList;
import java.util.HashMap;

public class Bt5 {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();

        numbers.add(5);
        numbers.add(12);
        numbers.add(8);
        numbers.add(5);
        numbers.add(12);
        numbers.add(7);
        numbers.add(8);
        numbers.add(12);
        numbers.add(5);
        numbers.add(10);


            HashMap<Integer, Integer> countMap = new HashMap<>();

            for (int number : numbers) {
                if (countMap.containsKey(number)) {
                    countMap.put(number, countMap.get(number) + 1);
                } else {
                    countMap.put(number, 1);
                }
            }

            for (int key : countMap.keySet()) {
                System.out.println(key + ": " + countMap.get(key));
            }
    }
}