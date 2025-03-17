package bt4;

public class Main {
    public static void main(String[] args) {
        Shape shape = new Shape();

        System.out.println("Kiểm tra Overloading trong lớp Shape:");
        System.out.printf("Diện tích mặc định: %.2f%n", shape.area());
        System.out.printf("Diện tích hình tròn (radius = 5.0): %.2f%n",
                shape.area(5.0));
        System.out.printf("Diện tích hình chữ nhật (width = 4.0, height = 6.0): %.2f%n",
                shape.area(4.0, 6.0));

        Circle circle = new Circle(5.0);
        Rectangle rectangle = new Rectangle(4.0, 6.0);

        System.out.println("\nKiểm tra Overriding trong các lớp con:");
        System.out.printf("%s: %.2f%n", circle.toString(), circle.area());
        System.out.printf("%s: %.2f%n", rectangle.toString(), rectangle.area());

        Shape[] shapes = {circle, rectangle};
        System.out.println("\nSử dụng đa hình:");
        for (Shape s : shapes) {
            System.out.printf("%s: %.2f%n", s.toString(), s.area());
        }
    }
}