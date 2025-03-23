package hackathon.bussiness;

import hackathon.entity.Employee;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import static entity.IApp.BASE_SALARY;

public class EmployeeBusiness {
    private static ArrayList<Employee> employees = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public EmployeeBusiness() {
        employees = new ArrayList<>();
    }

    public static void addEmployee(Scanner scanner) {
        System.out.println("Nhập số lượng nhân viên cần thêm: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        if (n <= 0) {
            System.out.println("Số lượng không hợp lệ");
            return;
        }
        for (int i = 0; i < n; i++) {
            Employee employee = new Employee();
            employee.inputData(scanner);
            employees.add(employee);
        }
        System.out.println("Thêm mới nhân viên thành công");
    }

    public static void displayEmployee() {
        if (employees.isEmpty()) {
            System.out.println("Danh sách nhân viên rỗng");
            return;
        }
        for (Employee employee : employees) {
            employee.displayData();
        }
    }

    public static void editEmployee(Scanner scanner) {
        System.out.println("Nhập mã nhân viên cần sửa: ");
        String id = scanner.nextLine();
        for (Employee employee : employees) {
            if (employee.getEmployeeID().equals(id)) {
                employee.inputData(scanner);
                return;
            }
        }
        System.out.println("Không tìm thấy nhân viên có mã " + id);
    }

    public static void deleteEmployee() {
        System.out.println("Nhập mã nhân viên cần xóa: ");
        String id = scanner.nextLine();
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getEmployeeID().equals(id)) {
                employees.remove(i);
                System.out.println("Xóa nhân viên thành công");
                return;
            }
        }
        System.out.println("Không tìm thấy nhân viên có mã " + id);
    }

    public static void searchEmployee(Scanner scanner) {
        int choice;
        do {
            System.out.println("1. Tìm kiếm theo tên nhân viên");
            System.out.println("2. Tìm kiếm theo phòng ban");
            System.out.println("3. Tìm kiếm theo khoảng lương");
            System.out.println("0. Thoát");
            System.out.println("Mời chọn: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    searchByName();
                    break;
                case 2:
                    searchByDepartment();
                    break;
                case 3:
                    searchBySalary();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
                    break;
            }
        } while (choice != 0);
    }

    private static void searchByName() {
        System.out.println("Nhập tên nhân viên cần tìm: ");
        String name = scanner.nextLine();
        for (Employee employee : employees) {
            if (employee.getEmployeeName().contains(name)) {
                employee.displayData();
            }
        }
    }

    private static void searchByDepartment() {
        System.out.println("Nhập tên phòng ban cần tìm: ");
        String department = scanner.nextLine();
        for (Employee employee : employees) {
            if (employee.getDepartment().contains(department)) {
                employee.displayData();
            }
        }
    }

    private static void searchBySalary() {
        System.out.println("Nhập lương thấp nhất: ");
        int minSalary = scanner.nextInt();
        System.out.println("Nhập lương cao nhất: ");
        int maxSalary = scanner.nextInt();
        for (Employee employee : employees) {
            float totalSalary = employee.getCoefficient() * BASE_SALARY + employee.getAllowanceSalary();
            if (totalSalary >= minSalary && totalSalary <= maxSalary) {
                employee.displayData();
            }
        }
    }

    public static void sortEmployee() {
        Collections.sort(employees, (e1, e2) -> e1.getEmployeeID().compareTo(e2.getEmployeeID()));
        displayEmployee();
    }
}