package bt2;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        int sum1 = calculator.add(5, 7);
        System.out.println("Tổng của 5 và 7 là: " + sum1);

        int sum2 = calculator.add(10, 20, 30);
        System.out.println("Tổng của 10, 20 và 30 là: " + sum2);

        int sum3 = calculator.add(-3, 8);
        System.out.println("Tổng của -3 và 8 là: " + sum3);

        int sum4 = calculator.add(100, 200, -50);
        System.out.println("Tổng của 100, 200 và -50 là: " + sum4);
    }
}
