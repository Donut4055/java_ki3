package presentation;


import business.model.Account;
import business.model.Employee;
import business.service.employee.EmployeeService;
import business.service.employee.EmployeeServiceImp;
import validator.EmployeeValidator;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class EmployeeUI {
    private static final Scanner sc = new Scanner(System.in);
    private static final EmployeeService employeeService = new EmployeeServiceImp();

    public static void menu() {
        if (Account.currentUser == null) {
            System.out.println("Vui lòng đăng nhập trước.");
            return;
        }
        while (true) {
            System.out.println("\n--- QUẢN LÝ NHÂN VIÊN ---");
            System.out.println("1. Thêm");
            System.out.println("2. Sửa");
            System.out.println("3. Xóa");
            System.out.println("4. Xem tất cả");
            System.out.println("5. Tìm theo ID");
            System.out.println("6. Tìm theo tên");
            System.out.println("7. Tìm theo khoảng tuổi");
            System.out.println("8. Sắp xếp theo lương giảm");
            System.out.println("9. Sắp xếp theo tên tăng");
            System.out.println("0. Quay lại");
            System.out.print("Chọn: ");
            String c = sc.nextLine();
            switch (c) {
                case "1" -> {
                    Employee e = inputEmployee();
                    if (e != null) employeeService.save(e);
                }
                case "2" -> {
                    System.out.print("ID nhân viên: ");
                    String id = sc.nextLine();
                    Employee e = employeeService.findById(id);
                    if (e != null) {
                        Employee newE = inputEmployee();
                        if (newE != null) {
                            newE.setId(id);
                            employeeService.update(newE);
                        }
                    }
                }
                case "3" -> {
                    System.out.print("ID nhân viên: ");
                    String id = sc.nextLine();
                    Employee e = employeeService.findById(id);
                    if (e != null) employeeService.delete(e);
                }
                case "4" -> employeeService.findAll().forEach(System.out::println);
                case "5" -> {
                    System.out.print("ID: ");
                    String id = sc.nextLine();
                    System.out.println(employeeService.findById(id));
                }
                case "6" -> {
                    System.out.print("Từ khóa: ");
                    String kw = sc.nextLine();
                    employeeService.findByName(kw).forEach(System.out::println);
                }
                case "7" -> {
                    System.out.print("Từ: ");
                    int min = Integer.parseInt(sc.nextLine());
                    System.out.print("Đến: ");
                    int max = Integer.parseInt(sc.nextLine());
                    employeeService.findByAgeRange(min, max).forEach(System.out::println);
                }
                case "8" -> employeeService.sortBySalaryDesc().forEach(System.out::println);
                case "9" -> employeeService.sortByNameAsc().forEach(System.out::println);
                case "0" -> { return; }
                default -> System.out.println("Sai lựa chọn");
            }
        }
    }

    private static Employee inputEmployee() {
        Employee e = new Employee();

        System.out.print("Mã nhân viên (Exxxx): ");
        String id = sc.nextLine();
        if (!EmployeeValidator.isIdValid(id)) {
            System.out.println("Mã không hợp lệ.");
            return null;
        }
        e.setId(id);

        System.out.print("Tên nhân viên: ");
        String name = sc.nextLine();
        if (!EmployeeValidator.isNameValid(name)) {
            System.out.println("Tên không hợp lệ.");
            return null;
        }
        e.setName(name);

        System.out.print("Email: ");
        String email = sc.nextLine();
        if (!EmployeeValidator.isEmailValid(email)) {
            System.out.println("Email không hợp lệ.");
            return null;
        }
        e.setEmail(email);

        System.out.print("SĐT: ");
        String phone = sc.nextLine();
        if (!EmployeeValidator.isPhoneValid(phone)) {
            System.out.println("SĐT không hợp lệ.");
            return null;
        }
        e.setPhone(phone);

        System.out.print("Giới tính (MALE/FEMALE/OTHER): ");
        String gender = sc.nextLine();
        if (!EmployeeValidator.isGenderValid(gender)) {
            System.out.println("Giới tính không hợp lệ.");
            return null;
        }
        e.setGender(gender);

        System.out.print("Bậc lương: ");
        int level = Integer.parseInt(sc.nextLine());
        if (!EmployeeValidator.isLevelValid(level)) {
            System.out.println("Bậc lương không hợp lệ.");
            return null;
        }
        e.setLevel(level);

        System.out.print("Lương: ");
        double salary = Double.parseDouble(sc.nextLine());
        if (!EmployeeValidator.isSalaryValid(salary)) {
            System.out.println("Lương không hợp lệ.");
            return null;
        }
        e.setSalary(salary);

        System.out.print("Ngày sinh (dd/MM/yyyy): ");
        LocalDate dob = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        if (!EmployeeValidator.isDobValid(dob)) {
            System.out.println("Ngày sinh không hợp lệ.");
            return null;
        }
        e.setDob(dob);

        System.out.print("Địa chỉ: ");
        String address = sc.nextLine();
        if (!EmployeeValidator.isAddressValid(address)) {
            System.out.println("Địa chỉ không hợp lệ.");
            return null;
        }
        e.setAddress(address);

        System.out.print("Trạng thái: ");
        String status = sc.nextLine();
        if (!EmployeeValidator.isStatusValid(status)) {
            System.out.println("Trạng thái không hợp lệ.");
            return null;
        }
        e.setStatus(status);

        System.out.print("ID phòng ban: ");
        int deptId = Integer.parseInt(sc.nextLine());
        if (!EmployeeValidator.isDepartmentIdValid(deptId)) {
            System.out.println("Mã phòng ban không hợp lệ.");
            return null;
        }
        e.setDepartmentId(deptId);

        return e;
    }
}
