package bt5;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(5);
        Rectangle rectangle = new Rectangle(4, 6);
        Square square = new Square(5);

        System.out.println("Màu sắc ban đầu:");
        System.out.println("Hình tròn: " + circle.getColor());
        System.out.println("Hình chữ nhật: " + rectangle.getColor());
        System.out.println("Hình vuông: " + square.getColor());

        circle.setColor("Đỏ");
        rectangle.setColor("Xanh lá cây");
        square.setColor("Xanh da trời");

        System.out.println("\nMàu sắc sau khi thiết lập:");
        System.out.println("Hình tròn: " + circle.getColor());
        System.out.println("Hình chữ nhật: " + rectangle.getColor());
        System.out.println("Hình vuông: " + square.getColor());
    }
}
