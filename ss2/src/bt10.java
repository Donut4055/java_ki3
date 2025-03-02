import java.math.BigInteger;
import java.util.Scanner;

public class bt10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số nguyên lớn thứ nhất: ");
        BigInteger number1 = new BigInteger(scanner.nextLine());

        System.out.print("Nhập số nguyên lớn thứ hai: ");
        BigInteger number2 = new BigInteger(scanner.nextLine());

        BigInteger sum = number1.add(number2);
        BigInteger difference = number1.subtract(number2);
        BigInteger product = number1.multiply(number2);
        BigInteger quotient = number1.divide(number2);
        BigInteger remainder = number1.mod(number2);
        BigInteger powerOfTen = number1.pow(10);

        System.out.println("Tổng: " + sum.toString());
        System.out.println("Hiệu: " + difference.toString());
        System.out.println("Tích: " + product.toString());
        System.out.println("Thương: " + quotient.toString());
        System.out.println("Số dư: " + remainder.toString());
        System.out.println("Lũy thừa bậc 10 của số thứ nhất: " + powerOfTen.toString());
    }
}
