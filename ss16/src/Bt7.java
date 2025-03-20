
import java.util.ArrayList;

public class Bt7 {
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


        System.out.println("Các phần tử xuất hiện đúng một lần:");
        boolean hasUnique = false;
        for (int i = 0; i < numbers.size(); i++) {
            int count = 0;
            for (int j = 0; j < numbers.size(); j++) {
                if (numbers.get(i).equals(numbers.get(j))) {
                    count++;
                }
            }
            if (count == 1) {
                System.out.print(numbers.get(i) + " ");
                hasUnique = true;
            }
        }
        if (!hasUnique) {
            System.out.println("Không có phần tử nào xuất hiện đúng một lần.");
        } else {
            System.out.println();
        }
    }
}