package bt9;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InventoryManager {
    private Map<Integer, Product> inventory;
    private Scanner scanner;

    public InventoryManager() {
        this.inventory = new HashMap<>();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("\n=== Quản lý kho hàng ===");
            System.out.println("1. Thêm sản phẩm mới");
            System.out.println("2. Cập nhật sản phẩm");
            System.out.println("3. Xóa sản phẩm");
            System.out.println("4. Tính tổng giá trị kho");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng (1-5): ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: addProduct(); break;
                case 2: updateProduct(); break;
                case 3: deleteProduct(); break;
                case 4: calculateTotalValue(); break;
                case 5: System.out.println("Đã thoát chương trình!"); return;
                default: System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    private void addProduct() {
        System.out.print("Nhập ID sản phẩm: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (inventory.containsKey(id)) {
            System.out.println("ID sản phẩm đã tồn tại!");
            return;
        }

        System.out.print("Nhập tên sản phẩm: ");
        String name = scanner.nextLine();

        System.out.print("Nhập giá sản phẩm: ");
        double price = scanner.nextDouble();
        if (price < 0) {
            System.out.println("Giá không được âm! Vui lòng thử lại.");
            return;
        }

        System.out.print("Nhập số lượng: ");
        int quantity = scanner.nextInt();
        if (quantity < 0) {
            System.out.println("Số lượng không được âm! Vui lòng thử lại.");
            return;
        }

        Product product = new Product(id, name, price, quantity);
        inventory.put(id, product);
        System.out.println("Đã thêm sản phẩm: " + product);
    }

    private void updateProduct() {
        System.out.print("Nhập ID sản phẩm cần cập nhật: ");
        int id = scanner.nextInt();

        if (!inventory.containsKey(id)) {
            System.out.println("Sản phẩm không tồn tại!");
            return;
        }

        Product product = inventory.get(id);
        System.out.println("Sản phẩm hiện tại: " + product);
        System.out.println("1. Cập nhật giá");
        System.out.println("2. Cập nhật số lượng");
        System.out.print("Chọn (1-2): ");
        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.print("Nhập giá mới: ");
            double newPrice = scanner.nextDouble();
            if (newPrice < 0) {
                System.out.println("Giá không được âm!");
                return;
            }
            product.setPrice(newPrice);
            System.out.println("Đã cập nhật giá!");
        } else if (choice == 2) {
            System.out.print("Nhập số lượng mới: ");
            int newQuantity = scanner.nextInt();
            if (newQuantity < 0) {
                System.out.println("Số lượng không được âm!");
                return;
            }
            product.setQuantity(newQuantity);
            System.out.println("Đã cập nhật số lượng!");
        } else {
            System.out.println("Lựa chọn không hợp lệ!");
        }
    }

    private void deleteProduct() {
        System.out.print("Nhập ID sản phẩm cần xóa: ");
        int id = scanner.nextInt();

        if (!inventory.containsKey(id)) {
            System.out.println("Sản phẩm không tồn tại!");
            return;
        }

        Product removed = inventory.remove(id);
        System.out.println("Đã xóa sản phẩm: " + removed);
    }

    private void calculateTotalValue() {
        if (inventory.isEmpty()) {
            System.out.println("Kho đang trống!");
            return;
        }

        double totalValue = 0;
        System.out.println("Danh sách sản phẩm trong kho:");
        for (Product product : inventory.values()) {
            double value = product.getPrice() * product.getQuantity();
            System.out.println(product + " - Giá trị: " + value);
            totalValue += value;
        }
        System.out.println("Tổng giá trị kho: " + totalValue);
    }
}
