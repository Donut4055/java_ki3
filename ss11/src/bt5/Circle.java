package bt5;

public class Circle implements IColorable {
    private double radius;
    private String color;

    public Circle(double radius) {
        this.radius = radius;
        this.color = "No color set";
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String getColor() {
        return color;
    }
}