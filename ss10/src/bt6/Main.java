package bt6;

public class Main {
    public static void main(String[] args) {
        Point point = new Point(2.5, 3.0);
        System.out.println("Point: " + point);

        MoveablePoint movePoint = new MoveablePoint(2.5, 3.0, 1.5, 2.0);
        System.out.println("MoveablePoint trước khi di chuyển: " + movePoint);

        movePoint.move();
        System.out.println("MoveablePoint sau khi di chuyển: " + movePoint);

        movePoint.setXSpeed(3.0);
        movePoint.setYSpeed(1.0);
        System.out.println("MoveablePoint sau khi thay đổi tốc độ: " + movePoint);

        movePoint.move();
        System.out.println("MoveablePoint sau khi di chuyển tiếp: " + movePoint);
    }
}

