package bt5;

public class Square implements IColorable {
    private double side;
    private String color;

    public Square(double side) {
        this.side = side;
        this.color = "No color set";
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
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