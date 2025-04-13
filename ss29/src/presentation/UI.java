package presentation;

import business.model.Account;
import business.service.account.AccountService;
import business.service.account.AccountServiceImp;

import java.util.Scanner;

public class UI {
    private static final Scanner sc = new Scanner(System.in);
    private static final AccountService accountService = new AccountServiceImp();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== HỆ THỐNG QUẢN LÝ NHÂN SỰ =====");
            System.out.println("1. Đăng nhập");
            System.out.println("2. Quản lý phòng ban");
            System.out.println("3. Quản lý nhân viên");
            System.out.println("4. Đăng xuất");
            System.out.println("0. Thoát chương trình");
            System.out.print("Chọn: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1" -> handleLogin();
                case "2" -> DepartmentUI.menu();
                case "3" -> EmployeeUI.menu();
                case "4" -> handleLogout();
                case "0" -> {
                    System.out.println("Thoát chương trình.");
                    return;
                }
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    private static void handleLogin() {
        if (Account.currentUser != null) {
            System.out.println("Đã đăng nhập.");
            return;
        }
        System.out.print("Username: ");
        String u = sc.nextLine();
        System.out.print("Password: ");
        String p = sc.nextLine();
        accountService.login(u, p);
    }

    private static void handleLogout() {
        accountService.logout();
    }
}