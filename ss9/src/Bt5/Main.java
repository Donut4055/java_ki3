package Bt5;

public class Main {
    public static void main(String[] args) {
        Vector2D v1 = new Vector2D(3.0, 4.0);
        Vector2D v2 = new Vector2D(1.5, 2.5);

        System.out.print("Vector v1: ");
        v1.displayVector();

        System.out.print("Vector v2: ");
        v2.displayVector();

        System.out.println("Magnitude of v1: " + v1.calculateMagnitude());
        System.out.println("Magnitude of v2: " + v2.calculateMagnitude());

        Vector2D sum = v1.add(v2);
        System.out.print("Sum (v1 + v2): ");
        sum.displayVector();

        Vector2D diff = v1.subtract(v2);
        System.out.print("Difference (v1 - v2): ");
        diff.displayVector();

        double dot = v1.dotProduct(v2);
        System.out.println("Dot Product (v1 . v2): " + dot);
    }
}
