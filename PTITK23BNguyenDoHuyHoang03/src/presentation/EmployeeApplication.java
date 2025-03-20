package presentation;

import bussiness.EmployeeBusiness;
import entity.Employee;

import java.util.Scanner;

public class EmployeeApplication extends EmployeeBusiness {
    public static void main(String[] args) {
        int choice;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("1.Hiển thị danh sách nhân viên");
            System.out.println("2. Thêm mới nhân viên");
            System.out.println("3. Chỉnh sửa thông tin nhân viên");
            System.out.println("4.  Xóa nhân viên");
            System.out.println("5. Tìm kiếm nhân viên");
            System.out.println("6. Sắp xếp ");
            System.out.println("0. thoát");

            System.out.println("mời nhập lựa chọn: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    displayEmployee();
                    break;
                case 2:
                    addEmployee(scanner);
                    break;
                case 3:
                    editEmployee(scanner);
                    break;
                case 4:
                    deleteEmployee();
                    break;
                case 5:
                    searchEmployee(scanner);
                    break;
                case 6:
                    sortEmployee();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("lựa chọn không hợp lệ");
            }
        } while (choice != 0);
    }
}
