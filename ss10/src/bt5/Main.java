package bt5;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(3);
        System.out.println("Diện tích hình tròn: " + circle.getArea());

        Cylinder cylinder = new Cylinder(3.5, 10.0);
        System.out.println("Thể tích hình trụ: " + cylinder.getVolume());

        circle.setRadius(5.0);
        System.out.println("\nSau khi thay đổi bán kính:");
        System.out.println("Diện tích hình tròn mới: " + circle.getArea());

        cylinder.setRadius(4.0);
        cylinder.setHeight(12.0);
        System.out.println("\nSau khi thay đổi bán kính và chiều cao:");
        System.out.println("Thể tích hình trụ mới: " + cylinder.getVolume());

        cylinder.setRadius(-1.0);
        cylinder.setHeight(-4.0);
    }
}

