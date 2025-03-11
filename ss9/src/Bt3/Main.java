package Bt3;

public class Main {
    public static void main(String[] args) {
        Rectangle rect1 = new Rectangle();
        System.out.println("Rectangle 1 (Default Constructor):");
        rect1.display();

        Rectangle rect2 = new Rectangle(5.5, 3.2);
        System.out.println("Rectangle 2 (Parameterized Constructor):");
        rect2.display();
    }
}
