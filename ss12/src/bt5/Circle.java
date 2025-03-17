package bt5;

public class Circle extends Shape {
    private double radius;
    private static final double PI = Math.PI; // Hằng số PI

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return PI * radius * radius;
    }
}