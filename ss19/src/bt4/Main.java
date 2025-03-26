package bt4;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(5.0);

        System.out.println("Diện tích hình tròn: " + circle.area());

        Shape.description();
    }
}