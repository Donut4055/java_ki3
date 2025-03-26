package bt3;

import java.util.Scanner;
import java.util.function.BiFunction;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        BiFunction<Integer, Integer, Integer> addFunction = MathOperations::add;
        BiFunction<Integer, Integer, Integer> subtractFunction = MathOperations::subtract;
        BiFunction<Integer, Integer, Integer> multiplyFunction = MathOperations::multiply;
        BiFunction<Integer, Integer, Double> divideFunction = MathOperations::divide;

        System.out.println("Phép cộng: " + a + " + " + b + " = " + addFunction.apply(a, b));
        System.out.println("Phép trừ: " + a + " - " + b + " = " + subtractFunction.apply(a, b));
        System.out.println("Phép nhân: " + a + " * " + b + " = " + multiplyFunction.apply(a, b));

        try {
            System.out.println("Phép chia: " + a + " / " + b + " = " + divideFunction.apply(a, b));
        } catch (ArithmeticException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }

    }
}