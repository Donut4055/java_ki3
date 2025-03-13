package bt10;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle("Hình tròn 1", 5);
        Rectangle rectangle = new Rectangle("Hình chữ nhật 1", 4, 6);
        Triangle triangle = new Triangle("Hình tam giác 1", 3, 4, 5);

        System.out.println("----- Kiểm tra từng đối tượng -----");
        System.out.println("Diện tích hình tròn: " + circle.calculateArea());
        System.out.println("Chu vi hình tròn: " + circle.calculatePerimeter());
        System.out.println(circle.toString());

        System.out.println("\nDiện tích hình chữ nhật: " + rectangle.calculateArea());
        System.out.println("Chu vi hình chữ nhật: " + rectangle.calculatePerimeter());
        System.out.println(rectangle.toString());

        System.out.println("\nDiện tích hình tam giác: " + triangle.calculateArea());
        System.out.println("Chu vi hình tam giác: " + triangle.calculatePerimeter());
        System.out.println(triangle.toString());

        Shape[] shapes = new Shape[3];
        shapes[0] = circle;
        shapes[1] = rectangle;
        shapes[2] = triangle;

        System.out.println("\n----- Danh sách các hình -----");
        for (int i = 0; i < shapes.length; i++) {
            System.out.println("---");
            System.out.println("Tên hình: " + shapes[i].getName());
            System.out.println("Diện tích: " + shapes[i].calculateArea());
            System.out.println("Chu vi: " + shapes[i].calculatePerimeter());
            System.out.println("Thông tin chi tiết: " + shapes[i].toString());
        }
    }
}
