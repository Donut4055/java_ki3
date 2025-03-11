package Bt4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Circle circle1 = new Circle();
        System.out.println("Circle 1 (Default Constructor):");
        circle1.display();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter radius for Circle 2: ");
        double inputRadius = scanner.nextDouble();
        Circle circle2 = new Circle(inputRadius);
        System.out.println("Circle 2 (Parameterized Constructor):");
        circle2.display();

    }
}
