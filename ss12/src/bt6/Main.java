package bt6;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[4];

        employees[0] = new FullTimeEmployee("Nguyen Van A", 30, 5000000, 1000000);
        employees[1] = new PartTimeEmployee("Tran Thi B", 25, 50000, 20);
        employees[2] = new Intern("Le Van C", 20, 2000000);
        employees[3] = new FullTimeEmployee("Pham Thi D", 28, 6000000, 1500000);

        System.out.println("Danh sách nhân viên:");
        for (Employee emp : employees) {
            emp.showInfo();
            System.out.println("------------------------");
        }
    }
}
