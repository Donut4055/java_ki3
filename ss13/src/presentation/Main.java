package presentation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShopManagement shop = new ShopManagement();

        while (true) {
            System.out.println("\n-------------------[SHOP MANAGEMENT SYSTEM]-------------------");
            System.out.println("1. Quản lý danh mục");
            System.out.println("2. Quản lý sản phẩm");
            System.out.println("3. Thoát");

            int choice = inputMenuChoice(scanner, 1, 3);

            switch (choice) {
                case 1 -> shop.handleCategoryMenu();
                case 2 -> shop.handleProductMenu();
                case 3 -> {
                    System.out.println("Thoát chương trình. Tạm biệt!");
                    return;
                }
            }
        }
    }

    // Nhập lựa chọn menu có kiểm tra
    private static int inputMenuChoice(Scanner scanner, int min, int max) {
        int choice;
        while (true) {
            System.out.print("Chọn chức năng (" + min + "-" + max + "): ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice >= min && choice <= max) {
                    return choice;
                } else {
                    System.out.println("⚠️ Vui lòng nhập số từ " + min + " đến " + max + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Vui lòng nhập một số hợp lệ.");
            }
        }
    }
}
//Tăng tính rõ ràng
//Giảm lặp mã
//Xử lý lỗi nhập sai dữ liệu (NumberFormatException)
//Tách logic nhập lựa chọn thành hàm riêng có validate