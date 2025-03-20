
import java.util.ArrayList;

public class Bt2 {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();

        numbers.add(15);
        numbers.add(7);
        numbers.add(9);
        numbers.add(22);
        numbers.add(12);
        numbers.add(33);
        numbers.add(8);
        numbers.add(18);
        numbers.add(4);
        numbers.add(27);

        System.out.println("Danh sách trước khi xóa các số chia hết cho 3:");
        System.out.println(numbers);

        for (int i = numbers.size() - 1; i >= 0; i--) {
            if (numbers.get(i) % 3 == 0) {
                numbers.remove(i);
            }
        }

        System.out.println("Danh sách sau khi xóa các số chia hết cho 3:");
        System.out.println(numbers);
    }
}