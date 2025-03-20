import java.util.ArrayList;

public class Bt4 {
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

            int sum = 0;
            for (int number : numbers) {
                sum += number;
            }

            System.out.println("Tổng của tất cả các phần tử: " + sum);
    }
}