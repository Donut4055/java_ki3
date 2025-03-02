import java.util.Scanner;

public class bt5 {
    public static void main(String[] args) {
        float width, height, area, circumference;

        Scanner scanner = new Scanner(System.in);

        width = scanner.nextFloat();
        height = scanner.nextFloat();

        area = width * height;
        circumference = 2 * (width + height);

        System.out.println("dien tich: " + area);
        System.out.println("chu vi: " + circumference);
    }
}
