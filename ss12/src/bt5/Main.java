package bt5;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(5);
        shapes[1] = new Rectangle(4, 6);
        shapes[2] = new Square(5);

        for (Shape shape : shapes) {
            double area = shape.area();
            String shapeName = "";

            if (shape instanceof Circle) {
                shapeName = "Hình tròn";
            } else if (shape instanceof Rectangle) {
                shapeName = "Hình chữ nhật";
            } else if (shape instanceof Square) {
                shapeName = "Hình vuông";
            } else if (shape instanceof Shape) {
                shapeName = "Hình dạng chung";
            }

            System.out.println("Diện tích của " + shapeName + " là: " + area);
        }
    }
}
