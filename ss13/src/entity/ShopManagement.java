package entity;

import java.util.Scanner;

public class ShopManagement {
    private Scanner scanner;
    private Categories[] categories;
    private Product[] products;
    private int categoryCount;
    private int productCount;
    private static final int MAX_CATEGORIES = 100;
    private static final int MAX_PRODUCTS = 100;

    public ShopManagement() {
        this.scanner = new Scanner(System.in);
        this.categories = new Categories[MAX_CATEGORIES];
        this.products = new Product[MAX_PRODUCTS];
        this.categoryCount = 0;
        this.productCount = 0;
    }

    public void handleCategoryMenu() {
        System.out.println("=== Chức năng quản lý danh mục ===");
        int choice;
        do {
            System.out.println("\n1. Danh sách danh mục\n2. Thêm danh mục\n3. Sửa danh mục\n4. Xóa danh mục\n5. Tìm kiếm danh mục\n6. Thoát");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    listCategories();
                    break;
                case 2:
                    if (categoryCount < MAX_CATEGORIES) {
                        Categories newCategory = new Categories();
                        newCategory.inputData(scanner);
                        newCategory.setId(categoryCount + 1);
                        categories[categoryCount] = newCategory;
                        categoryCount++;
                        System.out.println("Đã thêm danh mục!");
                    } else {
                        System.out.println("Đã đạt giới hạn số danh mục!");
                    }
                    break;
                case 3:
                    if (categoryCount > 0) {
                        System.out.print("Nhập ID danh mục cần sửa: ");
                        int editId = Integer.parseInt(scanner.nextLine());
                        Categories categoryToEdit = findCategoryById(editId);
                        if (categoryToEdit != null) {
                            System.out.println("=== Sửa thông tin danh mục (ID: " + editId + ") ===");
                            System.out.print("Tên danh mục mới: ");
                            categoryToEdit.setName(scanner.nextLine());
                            System.out.print("Mã ưu tiên mới: ");
                            categoryToEdit.setPriority(Integer.parseInt(scanner.nextLine()));
                            System.out.print("Mô tả ngắn mới: ");
                            categoryToEdit.setDescription(scanner.nextLine());
                            System.out.println("Đã cập nhật danh mục!");
                        } else {
                            System.out.println("Không tìm thấy danh mục với ID: " + editId);
                        }
                    } else {
                        System.out.println("Chưa có danh mục để sửa!");
                    }
                    break;
                case 4:
                    if (categoryCount > 0) {
                        System.out.print("Nhập ID danh mục cần xóa: ");
                        int deleteId = Integer.parseInt(scanner.nextLine());
                        Categories categoryToDelete = findCategoryById(deleteId);
                        if (categoryToDelete != null) {
                            boolean hasProducts = false;
                            for (int i = 0; i < productCount; i++) {
                                if (products[i].getCategoryId() == deleteId && products[i].isActive()) {
                                    hasProducts = true;
                                    break;
                                }
                            }
                            if (!hasProducts) {
                                categoryToDelete.setActive(false);
                                for (int i = 0; i < categoryCount; i++) {
                                    if (categories[i].getId() == deleteId) {
                                        for (int j = i; j < categoryCount - 1; j++) {
                                            categories[j] = categories[j + 1];
                                        }
                                        categories[categoryCount - 1] = null;
                                        categoryCount--;
                                        break;
                                    }
                                }
                                System.out.println("Đã xóa danh mục!");
                            } else {
                                System.out.println("Không thể xóa danh mục vì vẫn còn sản phẩm liên kết!");
                            }
                        } else {
                            System.out.println("Không tìm thấy danh mục với ID: " + deleteId);
                        }
                    } else {
                        System.out.println("Không có danh mục để xóa!");
                    }
                    break;
                case 5:
                    if (categoryCount > 0) {
                        System.out.print("Tìm kiếm danh mục theo tên: ");
                        String searchName = scanner.nextLine();
                        boolean found = false;
                        for (int i = 0; i < categoryCount; i++) {
                            if (categories[i].getName().toLowerCase().contains(searchName.toLowerCase())) {
                                categories[i].displayData();
                                found = true;
                            }
                        }
                        if (!found) {
                            System.out.println("Không tìm thấy danh mục phù hợp!");
                        }
                    } else {
                        System.out.println("Chưa có danh mục để tìm kiếm!");
                    }
                    break;
                case 6:
                    return;
            }
        } while (true);
    }

    public void handleProductMenu() {
        System.out.println("=== Chức năng quản lý sản phẩm ===");
        int choice;
        do {
            System.out.println("\n1. Danh sách sản phẩm\n2. Thêm mới sản phẩm\n3. Cập nhật sản phẩm\n4. Xóa sản phẩm\n5. Tìm kiếm theo tên\n6. Tìm kiếm theo khoảng giá\n7. Sắp xếp tăng dần\n8. Bán sản phẩm\n9. Thống kê theo danh mục\n10. Thoát");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    listProducts();
                    break;
                case 2:
                    if (categoryCount == 0) {
                        System.out.println("Vui lòng thêm danh mục trước khi thêm sản phẩm!");
                        break;
                    }
                    if (productCount < MAX_PRODUCTS) {
                        Product newProduct = new Product();
                        newProduct.inputData(scanner);
                        products[productCount] = newProduct;
                        productCount++;
                        System.out.println("Đã thêm sản phẩm!");
                    } else {
                        System.out.println("Đã đạt giới hạn số sản phẩm!");
                    }
                    break;
                case 3:
                    if (productCount > 0) {
                        System.out.print("Nhập mã sản phẩm cần cập nhật: ");
                        String editCode = scanner.nextLine();
                        Product productToEdit = findProductByCode(editCode);
                        if (productToEdit != null) {
                            productToEdit.inputData(scanner);
                            System.out.println("Đã cập nhật sản phẩm!");
                        } else {
                            System.out.println("Không tìm thấy sản phẩm với mã: " + editCode);
                        }
                    } else {
                        System.out.println("Chưa có sản phẩm để cập nhật!");
                    }
                    break;
                case 4:
                    if (productCount > 0) {
                        System.out.print("Nhập mã sản phẩm cần xóa: ");
                        String deleteCode = scanner.nextLine();
                        Product productToDelete = findProductByCode(deleteCode);
                        if (productToDelete != null && productToDelete.isActive()) {
                            productToDelete.setStatus(2);
                            for (int i = 0; i < productCount; i++) {
                                if (products[i].getCode().equals(deleteCode)) {
                                    for (int j = i; j < productCount - 1; j++) {
                                        products[j] = products[j + 1];
                                    }
                                    products[productCount - 1] = null;
                                    productCount--;
                                    break;
                                }
                            }
                            System.out.println("Đã xóa sản phẩm!");
                        } else {
                            System.out.println("Không tìm thấy sản phẩm hoặc sản phẩm đã bị xóa!");
                        }
                    } else {
                        System.out.println("Chưa có sản phẩm để xóa!");
                    }
                    break;
                case 5:
                    if (productCount > 0) {
                        System.out.print("Tìm kiếm theo tên: ");
                        String searchName = scanner.nextLine();
                        boolean found = false;
                        for (int i = 0; i < productCount; i++) {
                            if (products[i].getName().toLowerCase().contains(searchName.toLowerCase())) {
                                products[i].displayData();
                                found = true;
                            }
                        }
                        if (!found) {
                            System.out.println("Không tìm thấy sản phẩm phù hợp!");
                        }
                    } else {
                        System.out.println("Chưa có sản phẩm để tìm kiếm!");
                    }
                    break;
                case 6:
                    if (productCount > 0) {
                        System.out.print("Nhập giá tối thiểu: ");
                        float minPrice = Float.parseFloat(scanner.nextLine());
                        System.out.print("Nhập giá tối đa: ");
                        float maxPrice = Float.parseFloat(scanner.nextLine());
                        boolean found = false;
                        for (int i = 0; i < productCount; i++) {
                            if (products[i].getImportPrice() >= minPrice && products[i].getImportPrice() <= maxPrice) {
                                products[i].displayData();
                                found = true;
                            }
                        }
                        if (!found) {
                            System.out.println("Không tìm thấy sản phẩm trong khoảng giá!");
                        }
                    } else {
                        System.out.println("Chưa có sản phẩm để tìm kiếm!");
                    }
                    break;
                case 7:
                    if (productCount > 0) {
                        for (int i = 0; i < productCount - 1; i++) {
                            for (int j = i + 1; j < productCount; j++) {
                                if (products[i].getImportPrice() > products[j].getImportPrice()) {
                                    Product temp = products[i];
                                    products[i] = products[j];
                                    products[j] = temp;
                                }
                            }
                        }
                        System.out.println("Đã sắp xếp sản phẩm theo giá tăng dần:");
                        listProducts();
                    } else {
                        System.out.println("Chưa có sản phẩm để sắp xếp!");
                    }
                    break;
                case 8:
                    if (productCount > 0) {
                        System.out.print("Nhập mã sản phẩm cần bán: ");
                        String sellCode = scanner.nextLine();
                        Product productToSell = findProductByCode(sellCode);
                        if (productToSell != null && productToSell.isActive()) {
                            if (productToSell.getQuantity() > 0) {
                                productToSell.setQuantity(productToSell.getQuantity() - 1);
                                if (productToSell.getQuantity() == 0) {
                                    productToSell.setStatus(1);
                                }
                                System.out.println("Đã bán sản phẩm!");
                                productToSell.displayData();
                            } else {
                                System.out.println("Sản phẩm đã hết hàng!");
                            }
                        } else {
                            System.out.println("Không tìm thấy sản phẩm hoặc sản phẩm không hoạt động!");
                        }
                    } else {
                        System.out.println("Chưa có sản phẩm để bán!");
                    }
                    break;
                case 9:
                    if (categoryCount > 0) {
                        System.out.println("Thống kê số lượng sản phẩm theo danh mục:");
                        for (int i = 0; i < categoryCount; i++) {
                            int count = 0;
                            int totalQuantity = 0;
                            for (int j = 0; j < productCount; j++) {
                                if (products[j].getCategoryId() == categories[i].getId() && products[j].isActive()) {
                                    count++;
                                    totalQuantity += products[j].getQuantity();
                                }
                            }
                            System.out.println("Danh mục " + categories[i].getName() + " (ID: " + categories[i].getId() + "): " + count + " sản phẩm, tổng số lượng: " + totalQuantity);
                        }
                    } else {
                        System.out.println("Chưa có danh mục để thống kê!");
                    }
                    break;
                case 10:
                    return;
            }
        } while (true);
    }

    private void listCategories() {
        System.out.println("Danh sách danh mục:");
        if (categoryCount == 0) {
            System.out.println("Chưa có danh mục nào.");
        } else {
            for (int i = 0; i < categoryCount; i++) {
                categories[i].displayData();
            }
        }
    }

    private void listProducts() {
        System.out.println("Danh sách sản phẩm:");
        if (productCount == 0) {
            System.out.println("Chưa có sản phẩm nào.");
        } else {
            for (int i = 0; i < productCount; i++) {
                products[i].displayData();
            }
        }
    }

    private Categories findCategoryById(int id) {
        for (int i = 0; i < categoryCount; i++) {
            if (categories[i].getId() == id) {
                return categories[i];
            }
        }
        return null;
    }

    private Product findProductByCode(String code) {
        for (int i = 0; i < productCount; i++) {
            if (products[i].getCode().equals(code)) {
                return products[i];
            }
        }
        return null;
    }

    public Categories[] getAllCategories() {
        return categories;
    }

    public Product[] getAllProducts() {
        return products;
    }
}