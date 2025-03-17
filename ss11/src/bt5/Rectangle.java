package bt5;

public class Rectangle implements IColorable {
    private double width;
    private double height;
    private String color;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
        this.color = "No color set";
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
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