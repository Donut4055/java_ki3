package bt10;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EmployeeManager {
    private Map<Integer, Employee> employees;
    private Scanner scanner;
    private int nextId;

    public EmployeeManager() {
        this.employees = new HashMap<>();
        this.scanner = new Scanner(System.in);
        this.nextId = 1;
    }

    public void start() {
        while (true) {
            System.out.println("\n=== Quản lý nhân viên ===");
            System.out.println("1. Thêm nhân viên mới");
            System.out.println("2. Hiển thị danh sách nhân viên");
            System.out.println("3. Tính tổng lương");
            System.out.println("4. Tính lương trung bình");
            System.out.println("5. Tìm nhân viên lương cao nhất");
            System.out.println("6. Tìm nhân viên lương thấp nhất");
            System.out.println("7. Thoát");
            System.out.print("Chọn chức năng (1-7): ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: addEmployee(); break;
                case 2: displayEmployees(); break;
                case 3: calculateTotalSalary(); break;
                case 4: calculateAverageSalary(); break;
                case 5: findHighestPaidEmployee(); break;
                case 6: findLowestPaidEmployee(); break;
                case 7: System.out.println("Đã thoát chương trình!"); return;
                default: System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    private void addEmployee() {
        System.out.print("Nhập tên nhân viên: ");
        String name = scanner.nextLine();

        System.out.print("Nhập lương nhân viên: ");
        double salary = scanner.nextDouble();
        if (salary < 0) {
            System.out.println("Lương không được âm! Vui lòng thử lại.");
            return;
        }

        Employee employee = new Employee(nextId, name, salary);
        employees.put(nextId, employee);
        System.out.println("Đã thêm nhân viên: " + employee);
        nextId++; // Tăng ID cho nhân viên tiếp theo
    }

    private void displayEmployees() {
        if (employees.isEmpty()) {
            System.out.println("Danh sách nhân viên trống!");
            return;
        }
        System.out.println("Danh sách nhân viên:");
        for (Employee emp : employees.values()) {
            System.out.println(emp);
        }
    }

    private void calculateTotalSalary() {
        if (employees.isEmpty()) {
            System.out.println("Danh sách nhân viên trống!");
            return;
        }
        double totalSalary = 0;
        for (Employee emp : employees.values()) {
            totalSalary += emp.getSalary();
        }
        System.out.println("Tổng lương của tất cả nhân viên: " + totalSalary);
    }

    private void calculateAverageSalary() {
        if (employees.isEmpty()) {
            System.out.println("Danh sách nhân viên trống!");
            return;
        }
        double totalSalary = 0;
        for (Employee emp : employees.values()) {
            totalSalary += emp.getSalary();
        }
        double averageSalary = totalSalary / employees.size();
        System.out.println("Lương trung bình của nhân viên: " + averageSalary);
    }

    private void findHighestPaidEmployee() {
        if (employees.isEmpty()) {
            System.out.println("Danh sách nhân viên trống!");
            return;
        }
        Employee highestPaid = null;
        double maxSalary = Double.MIN_VALUE;
        for (Employee emp : employees.values()) {
            if (emp.getSalary() > maxSalary) {
                maxSalary = emp.getSalary();
                highestPaid = emp;
            }
        }
        System.out.println("Nhân viên có lương cao nhất: " + highestPaid);
    }

    private void findLowestPaidEmployee() {
        if (employees.isEmpty()) {
            System.out.println("Danh sách nhân viên trống!");
            return;
        }
        Employee lowestPaid = null;
        double minSalary = Double.MAX_VALUE;
        for (Employee emp : employees.values()) {
            if (emp.getSalary() < minSalary) {
                minSalary = emp.getSalary();
                lowestPaid = emp;
            }
        }
        System.out.println("Nhân viên có lương thấp nhất: " + lowestPaid);
    }
}