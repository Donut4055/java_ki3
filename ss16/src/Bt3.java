import java.util.ArrayList;

public class Bt3 {
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



            int max = numbers.getFirst();
            int min = numbers.getFirst();

            for (int number : numbers) {
                if (number > max) {
                    max = number;
                }
                if (number < min) {
                    min = number;
                }
            }

            System.out.println("Phần tử lớn nhất: " + max);
            System.out.println("Phần tử nhỏ nhất: " + min);
    }
}
