package presentation;


import business.model.Account;
import business.model.Department;
import business.service.department.DepartmentService;
import business.service.department.DepartmentServiceImp;
import validator.DepartmentValidator;
import java.util.Scanner;

public class DepartmentUI {
    private static final Scanner sc = new Scanner(System.in);
    private static final DepartmentService departmentService = new DepartmentServiceImp();

    public static void menu() {
        if (Account.currentUser == null) {
            System.out.println("Vui lòng đăng nhập trước.");
            return;
        }
        while (true) {
            System.out.println("\n--- QUẢN LÝ PHÒNG BAN ---");
            System.out.println("1. Thêm");
            System.out.println("2. Sửa");
            System.out.println("3. Xóa");
            System.out.println("4. Xem tất cả");
            System.out.println("5. Tìm theo tên");
            System.out.println("0. Quay lại");
            System.out.print("Chọn: ");
            String c = sc.nextLine();
            switch (c) {
                case "1" -> {
                    Department d = inputDepartment();
                    if (d != null) departmentService.save(d);
                }
                case "2" -> {
                    System.out.print("Nhập ID phòng ban: ");
                    int id = Integer.parseInt(sc.nextLine());
                    Department d = departmentService.findById(id);
                    if (d != null) {
                        Department newD = inputDepartment();
                        if (newD != null) {
                            newD.setId(id);
                            departmentService.update(newD);
                        }
                    }
                }
                case "3" -> {
                    System.out.print("ID phòng ban: ");
                    int id = Integer.parseInt(sc.nextLine());
                    Department d = departmentService.findById(id);
                    if (d != null) departmentService.delete(d);
                }
                case "4" -> departmentService.findAll().forEach(System.out::println);
                case "5" -> {
                    System.out.print("Từ khóa: ");
                    String kw = sc.nextLine();
                    departmentService.findByName(kw).forEach(System.out::println);
                }
                case "0" -> { return; }
                default -> System.out.println("Sai lựa chọn");
            }
        }
    }

    private static Department inputDepartment() {
        Department d = new Department();
        System.out.print("Tên phòng ban: ");
        String name = sc.nextLine();
        if (!DepartmentValidator.isNameValid(name)) {
            System.out.println("Tên không hợp lệ.");
            return null;
        }
        d.setName(name);

        System.out.print("Mô tả: ");
        String desc = sc.nextLine();
        if (!DepartmentValidator.isDescriptionValid(desc)) {
            System.out.println("Mô tả quá dài.");
            return null;
        }
        d.setDescription(desc);

        System.out.print("Trạng thái (ACTIVE/INACTIVE): ");
        String status = sc.nextLine();
        if (!DepartmentValidator.isStatusValid(status)) {
            System.out.println("Trạng thái không hợp lệ.");
            return null;
        }
        d.setStatus(status);
        return d;
    }
}
