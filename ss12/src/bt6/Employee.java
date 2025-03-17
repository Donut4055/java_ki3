package bt6;

public class Employee {
    protected String name;
    protected int age;
    protected double basicSalary;

    public Employee(String name, int age, double basicSalary) {
        this.name = name;
        this.age = age;
        this.basicSalary = basicSalary;
    }

    public double calculateSalary() {
        return basicSalary;
    }

    public void showInfo() {
        System.out.println("Tên: " + name + ", Tuổi: " + age + ", Lương cơ bản: " + basicSalary);
    }
}