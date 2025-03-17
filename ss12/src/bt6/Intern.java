package bt6;

public class Intern extends Employee {
    public Intern(String name, int age, double basicSalary) {
        super(name, age, basicSalary);
    }

    @Override
    public void showInfo() {
        System.out.println("Thực tập sinh:");
        System.out.println("Tên: " + name + ", Tuổi: " + age +
                ", Lương cơ bản: " + basicSalary +
                ", Tổng lương: " + calculateSalary());
    }
}