package Bt7;

public class Main {
    public static void main(String[] args) {
        // Trường hợp 1: hai nghiệm phân biệt
        QuadraticEquation eq1 = new QuadraticEquation(1, -5, 6);
        eq1.display();
        System.out.println();

        // Trường hợp 2: nghiệm kép
        QuadraticEquation eq2 = new QuadraticEquation(1, -4, 4);
        eq2.display();
        System.out.println();

        // Trường hợp 3: không có nghiệm thực
        QuadraticEquation eq3 = new QuadraticEquation(1, 2, 5);
        eq3.display();
    }
}
