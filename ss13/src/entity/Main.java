package entity;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ShopManagement shop = new ShopManagement();
        while (true) {
            System.out.println("\n-------------------[SHOP MANAGEMENT SYSTEM]-------------------");
            System.out.println("1. Quản lý danh mục\n2. Quản lý sản phẩm\n3. Thoát");
            int choice = Integer.parseInt(new Scanner(System.in).nextLine());

            switch (choice) {
                case 1:
                    shop.handleCategoryMenu();
                    break;
                case 2:
                    shop.handleProductMenu();
                    break;
                case 3:
                    return;
            }
        }
    }
}

