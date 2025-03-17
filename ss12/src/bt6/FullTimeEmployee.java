package bt6;

public class FullTimeEmployee extends Employee {
    private double bonus;

    public FullTimeEmployee(String name, int age, double basicSalary, double bonus) {
        super(name, age, basicSalary);
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return basicSalary + bonus;
    }

    @Override
    public void showInfo() {
        System.out.println("Nhân viên toàn thời gian:");
        System.out.println("Tên: " + name + ", Tuổi: " + age +
                ", Lương cơ bản: " + basicSalary +
                ", Thưởng: " + bonus +
                ", Tổng lương: " + calculateSalary());
    }
}
