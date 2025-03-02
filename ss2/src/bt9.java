import java.util.Scanner;

public class bt9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a, b, c, perimeter, area;

        System.out.print("Nhập cạnh thứ nhất của tam giác: ");
        a = scanner.nextDouble();

        System.out.print("Nhập cạnh thứ hai của tam giác: ");
        b = scanner.nextDouble();

        System.out.print("Nhập cạnh thứ ba của tam giác: ");
        c = scanner.nextDouble();

        perimeter = a + b + c;

        double semiPerimeter = perimeter / 2;
        area = Math.sqrt(semiPerimeter * (semiPerimeter - a) * (semiPerimeter - b) * (semiPerimeter - c));

        System.out.println("Chu vi của tam giác: " + perimeter);
        System.out.println("Diện tích của tam giác: " + area);
    }
}
