package Bt6;

public class Main {
    public static void main(String[] args) {
        Point2D point1 = new Point2D(2.0, 3.0);
        Point2D point2 = new Point2D(5.0, 7.0);

        System.out.print("Point 1: ");
        point1.displayPoint();

        System.out.print("Point 2: ");
        point2.displayPoint();

        double distance = point1.distanceTo(point2);
        System.out.println("Distance between Point1 and Point2: " + distance);

        point1.setX(10.0);
        point1.setY(12.5);
        System.out.println("After updating Point1:");
        point1.displayPoint();
    }
}
