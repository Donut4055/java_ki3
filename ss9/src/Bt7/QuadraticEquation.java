package Bt7;

public class QuadraticEquation {
    public double a;
    public double b;
    public double c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getDiscriminant() {
        return b * b - 4 * a * c;
    }

    public boolean hasRealRoots() {
        return getDiscriminant() >= 0;
    }

    public double getRoot1() {
        if (!hasRealRoots()) return Double.NaN;
        return (-b + Math.sqrt(getDiscriminant())) / (2 * a);
    }

    public double getRoot2() {
        if (!hasRealRoots()) return Double.NaN;
        return (-b - Math.sqrt(getDiscriminant())) / (2 * a);
    }

    public void display() {
        System.out.println("Phương trình: " + a + "x^2 + " + b + "x + " + c + " = 0");

        double delta = getDiscriminant();
        System.out.println("Delta (discriminant): " + delta);

        if (delta > 0) {
            System.out.println("Phương trình có hai nghiệm phân biệt:");
            System.out.println("Nghiệm 1: " + getRoot1());
            System.out.println("Nghiệm 2: " + getRoot2());
        } else if (delta == 0) {
            System.out.println("Phương trình có nghiệm kép:");
            System.out.println("Nghiệm kép: " + getRoot1());
        } else {
            System.out.println("Phương trình không có nghiệm thực.");
        }
    }
}
