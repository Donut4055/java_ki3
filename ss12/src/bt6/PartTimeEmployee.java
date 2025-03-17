package bt6;

public class PartTimeEmployee extends Employee {
    private int workingHours;

    public PartTimeEmployee(String name, int age, double basicSalary, int workingHours) {
        super(name, age, basicSalary);
        this.workingHours = workingHours;
    }

    @Override
    public double calculateSalary() {
        return basicSalary * workingHours;
    }

    @Override
    public void showInfo() {
        System.out.println("Nhân viên bán thời gian:");
        System.out.println("Tên: " + name + ", Tuổi: " + age +
                ", Lương cơ bản/giờ: " + basicSalary +
                ", Số giờ làm: " + workingHours +
                ", Tổng lương: " + calculateSalary());
    }
}
