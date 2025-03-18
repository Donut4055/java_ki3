package bt2;

import java.util.Scanner;

public class ShopManagement {
    private Scanner scanner = new Scanner(System.in);
    private Categories[] categories = new Categories[MAX_CATEGORIES];
    private Product[] products = new Product[MAX_PRODUCTS];
    private int categoryCount = 0;
    private int productCount = 0;

    private static final int MAX_CATEGORIES = 100;
    private static final int MAX_PRODUCTS = 100;

    public void handleCategoryMenu() {
        int choice;
        do {
            showCategoryMenu();
            choice = getChoice();
            switch (choice) {
                case 1 -> listCategories();
                case 2 -> addCategory();
                case 3 -> editCategory();
                case 4 -> deleteCategory();
                case 5 -> searchCategoryByName();
                case 6 -> { return; }
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (true);
    }

    public void handleProductMenu() {
        int choice;
        do {
            showProductMenu();
            choice = getChoice();
            switch (choice) {
                case 1 -> listProducts();
                case 2 -> addProduct();
                case 3 -> updateProduct();
                case 4 -> deleteProduct();
                case 5 -> searchProductByName();
                case 6 -> searchProductByPriceRange();
                case 7 -> sortProductsByPrice();
                case 8 -> sellProduct();
                case 9 -> reportProductsByCategory();
                case 10 -> { return; }
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (true);
    }

    // --- Category Methods ---
    private void showCategoryMenu() {
        System.out.println("=== MENU QUẢN LÝ DANH MỤC ===");
        System.out.println("1. Danh sách danh mục");
        System.out.println("2. Thêm danh mục");
        System.out.println("3. Sửa danh mục");
        System.out.println("4. Xóa danh mục");
        System.out.println("5. Tìm kiếm danh mục");
        System.out.println("6. Thoát");
    }

    private void addCategory() {
        if (categoryCount >= MAX_CATEGORIES) {
            System.out.println("Đã đạt giới hạn số danh mục!");
            return;
        }
        Categories category = new Categories();
        category.inputData(scanner);
        category.setId(categoryCount + 1);
        categories[categoryCount++] = category;
        System.out.println("Thêm danh mục thành công!");
    }

    private void editCategory() {
        if (categoryCount == 0) {
            System.out.println("Không có danh mục để sửa.");
            return;
        }
        System.out.print("Nhập ID cần sửa: ");
        int id = getIntInput();
        Categories cat = findCategoryById(id);
        if (cat != null) {
            System.out.print("Tên mới: ");
            cat.setName(scanner.nextLine());
            System.out.print("Mã ưu tiên mới: ");
            cat.setPriority(getIntInput());
            System.out.print("Mô tả mới: ");
            cat.setDescription(scanner.nextLine());
            System.out.println("Cập nhật thành công!");
        } else {
            System.out.println("Không tìm thấy danh mục.");
        }
    }

    private void deleteCategory() {
        if (categoryCount == 0) {
            System.out.println("Không có danh mục để xóa.");
            return;
        }
        System.out.print("Nhập ID cần xóa: ");
        int id = getIntInput();
        int index = findCategoryIndexById(id);
        if (index == -1) {
            System.out.println("Không tìm thấy danh mục.");
            return;
        }

        if (isCategoryLinkedToProducts(id)) {
            System.out.println("Không thể xóa - danh mục có sản phẩm liên kết.");
            return;
        }

        for (int i = index; i < categoryCount - 1; i++) {
            categories[i] = categories[i + 1];
        }
        categories[--categoryCount] = null;
        System.out.println("Xóa danh mục thành công!");
    }

    private void searchCategoryByName() {
        if (categoryCount == 0) {
            System.out.println("Chưa có danh mục.");
            return;
        }
        System.out.print("Nhập tên tìm kiếm: ");
        String name = scanner.nextLine().toLowerCase();
        boolean found = false;
        for (int i = 0; i < categoryCount; i++) {
            if (categories[i].getName().toLowerCase().contains(name)) {
                categories[i].displayData();
                found = true;
            }
        }
        if (!found) System.out.println("Không tìm thấy kết quả.");
    }

    private boolean isCategoryLinkedToProducts(int categoryId) {
        for (int i = 0; i < productCount; i++) {
            if (products[i].getCategoryId() == categoryId && products[i].isActive()) {
                return true;
            }
        }
        return false;
    }

    private int findCategoryIndexById(int id) {
        for (int i = 0; i < categoryCount; i++) {
            if (categories[i].getId() == id) return i;
        }
        return -1;
    }

    // --- Product Methods ---
    private void showProductMenu() {
        System.out.println("=== MENU QUẢN LÝ SẢN PHẨM ===");
        System.out.println("1. Danh sách sản phẩm");
        System.out.println("2. Thêm sản phẩm");
        System.out.println("3. Cập nhật sản phẩm");
        System.out.println("4. Xóa sản phẩm");
        System.out.println("5. Tìm kiếm theo tên");
        System.out.println("6. Tìm kiếm theo giá");
        System.out.println("7. Sắp xếp theo giá tăng");
        System.out.println("8. Bán sản phẩm");
        System.out.println("9. Thống kê theo danh mục");
        System.out.println("10. Thoát");
    }

    private void addProduct() {
        if (categoryCount == 0) {
            System.out.println("Thêm danh mục trước.");
            return;
        }
        if (productCount >= MAX_PRODUCTS) {
            System.out.println("Đã đạt giới hạn sản phẩm!");
            return;
        }
        Product product = new Product();
        product.inputData(scanner);
        products[productCount++] = product;
        System.out.println("Thêm sản phẩm thành công!");
    }

    private void updateProduct() {
        System.out.print("Mã sản phẩm cần sửa: ");
        String code = scanner.nextLine();
        Product p = findProductByCode(code);
        if (p != null) {
            p.inputData(scanner);
            System.out.println("Đã cập nhật sản phẩm.");
        } else System.out.println("Không tìm thấy sản phẩm.");
    }

    private void deleteProduct() {
        System.out.print("Mã sản phẩm cần xóa: ");
        String code = scanner.nextLine();
        int index = findProductIndexByCode(code);
        if (index == -1) {
            System.out.println("Không tìm thấy sản phẩm.");
            return;
        }
        products[index].setStatus(2); // đánh dấu đã xóa
        for (int i = index; i < productCount - 1; i++) {
            products[i] = products[i + 1];
        }
        products[--productCount] = null;
        System.out.println("Xóa sản phẩm thành công!");
    }

    private void searchProductByName() {
        System.out.print("Nhập tên sản phẩm: ");
        String name = scanner.nextLine().toLowerCase();
        boolean found = false;
        for (int i = 0; i < productCount; i++) {
            if (products[i].getName().toLowerCase().contains(name)) {
                products[i].displayData();
                found = true;
            }
        }
        if (!found) System.out.println("Không tìm thấy sản phẩm.");
    }

    private void searchProductByPriceRange() {
        System.out.print("Giá tối thiểu: ");
        float min = getFloatInput();
        System.out.print("Giá tối đa: ");
        float max = getFloatInput();
        boolean found = false;
        for (int i = 0; i < productCount; i++) {
            float price = products[i].getImportPrice();
            if (price >= min && price <= max) {
                products[i].displayData();
                found = true;
            }
        }
        if (!found) System.out.println("Không tìm thấy sản phẩm.");
    }

    private void sortProductsByPrice() {
        for (int i = 0; i < productCount - 1; i++) {
            for (int j = i + 1; j < productCount; j++) {
                if (products[i].getImportPrice() > products[j].getImportPrice()) {
                    Product temp = products[i];
                    products[i] = products[j];
                    products[j] = temp;
                }
            }
        }
        System.out.println("Đã sắp xếp sản phẩm theo giá tăng.");
        listProducts();
    }

    private void sellProduct() {
        System.out.print("Mã sản phẩm: ");
        String code = scanner.nextLine();
        Product p = findProductByCode(code);
        if (p != null && p.isActive()) {
            if (p.getQuantity() > 0) {
                p.setQuantity(p.getQuantity() - 1);
                if (p.getQuantity() == 0) p.setStatus(1);
                System.out.println("Đã bán sản phẩm!");
            } else System.out.println("Sản phẩm hết hàng!");
        } else System.out.println("Không tìm thấy sản phẩm.");
    }

    private void reportProductsByCategory() {
        for (int i = 0; i < categoryCount; i++) {
            int total = 0, count = 0;
            for (int j = 0; j < productCount; j++) {
                if (products[j].getCategoryId() == categories[i].getId()) {
                    total += products[j].getQuantity();
                    count++;
                }
            }
            System.out.println("Danh mục: " + categories[i].getName() +
                    " - " + count + " sản phẩm, Tổng SL: " + total);
        }
    }

    private int getChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            return -1;
        }
    }

    private int getIntInput() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            return 0;
        }
    }

    private float getFloatInput() {
        try {
            return Float.parseFloat(scanner.nextLine());
        } catch (Exception e) {
            return 0f;
        }
    }

    private Categories findCategoryById(int id) {
        for (int i = 0; i < categoryCount; i++) {
            if (categories[i].getId() == id) return categories[i];
        }
        return null;
    }

    private Product findProductByCode(String code) {
        for (int i = 0; i < productCount; i++) {
            if (products[i].getCode().equalsIgnoreCase(code)) return products[i];
        }
        return null;
    }

    private int findProductIndexByCode(String code) {
        for (int i = 0; i < productCount; i++) {
            if (products[i].getCode().equalsIgnoreCase(code)) return i;
        }
        return -1;
    }

    private void listCategories() {
        if (categoryCount == 0) {
            System.out.println("Chưa có danh mục.");
        } else {
            for (int i = 0; i < categoryCount; i++) {
                categories[i].displayData();
            }
        }
    }

    private void listProducts() {
        if (productCount == 0) {
            System.out.println("Chưa có sản phẩm.");
        } else {
            for (int i = 0; i < productCount; i++) {
                products[i].displayData();
            }
        }
    }
}
//Tách nhỏ logic thành phương thức riêng.
//Loại bỏ đoạn code lặp.
//Tăng khả năng mở rộng và bảo trì mã.