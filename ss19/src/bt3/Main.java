package bt3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        // sử dụng 1 interface chỉ có 1 phương thức trừu tượng duy nhất để gán tham chiếu cho phương thức ::
        IntOperation addFunction = MathOperations::add;
        IntOperation subtractFunction = MathOperations::subtract;
        IntOperation multiplyFunction = MathOperations::multiply;
        DoubleOperation divideFunction = MathOperations::divide;

        System.out.println("Phép cộng: " + a + " + " + b + " = " + addFunction.apply(a, b));
        System.out.println("Phép trừ: " + a + " - " + b + " = " + subtractFunction.apply(a, b));
        System.out.println("Phép nhân: " + a + " * " + b + " = " + multiplyFunction.apply(a, b));
        System.out.println("Phép chia: " + a + " / " + b + " = " + divideFunction.apply(a, b));

    }
}