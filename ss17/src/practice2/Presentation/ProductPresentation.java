package practice2.Presentation;

import practice2.Entity.Product;
import practice2.Validate.ProductValidate;
import practice2.Business.ProductBusiness;

import java.util.Scanner;

public class ProductPresentation {
    private static Product[] arrProduct = new Product[100];
    private static int currentIndex = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            displayMenu();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    inputProducts(scanner);
                    break;
                case 2:
                    displayProducts();
                    break;
                case 3:
                    calculateProfits();
                    break;
                case 4:
                    sortProductsByProfit();
                    break;
                case 5:
                    statisticByPriceRange(scanner);
                    break;
                case 6:
                    searchProductsByName(scanner);
                    break;
                case 7:
                    importProduct(scanner);
                    break;
                case 8:
                    sellProduct(scanner);
                    break;
                case 9:
                    updateProductStatus(scanner);
                    break;
                case 10:
                    System.out.println("Thoát chương trình!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Chức năng không hợp lệ!");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\n===== MENU =====");
        System.out.println("1. Nhập thông tin n sản phẩm");
        System.out.println("2. Hiển thị thông tin các sản phẩm");
        System.out.println("3. Tính lợi nhuận các sản phẩm");
        System.out.println("4. Sắp xếp các sản phẩm theo lợi nhuận giảm dần");
        System.out.println("5. Thống kê các sản phẩm theo giá");
        System.out.println("6. Tìm các sản phẩm theo tên sản phẩm");
        System.out.println("7. Nhập sản phẩm");
        System.out.println("8. Bán sản phẩm");
        System.out.println("9. Cập nhật trạng thái sản phẩm");
        System.out.println("10. Thoát");
        System.out.print("Chọn chức năng (1-10): ");
    }

    private static void inputProducts(Scanner scanner) {
        System.out.print("Nhập số lượng sản phẩm cần thêm: ");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n && currentIndex < arrProduct.length; i++) {
            Product product = new Product();
            System.out.println("Nhập thông tin sản phẩm thứ " + (i + 1) + ":");
            inputProductData(scanner, product);
            arrProduct[currentIndex] = product;
            ProductBusiness.calculateProfit(product); // Tính profit ngay khi nhập
            currentIndex++;
        }
    }

    private static void inputProductData(Scanner scanner, Product product) {
        while (true) {
            System.out.print("Nhập mã sản phẩm (4 ký tự, không trùng): ");
            String id = scanner.nextLine();
            if (ProductValidate.validateProductId(id, arrProduct)) {
                product.setProductId(id);
                break;
            }
            System.out.println("Mã không hợp lệ hoặc đã tồn tại!");
        }

        while (true) {
            System.out.print("Nhập tên sản phẩm (6-50 ký tự, không trùng): ");
            String name = scanner.nextLine();
            if (ProductValidate.validateProductName(name, arrProduct)) {
                product.setProductName(name);
                break;
            }
            System.out.println("Tên không hợp lệ hoặc đã tồn tại!");
        }

        while (true) {
            System.out.print("Nhập giá nhập (> 0): ");
            float price = Float.parseFloat(scanner.nextLine());
            if (ProductValidate.validateImportPrice(price)) {
                product.setImportPrice(price);
                break;
            }
            System.out.println("Giá nhập phải lớn hơn 0!");
        }

        while (true) {
            System.out.print("Nhập giá xuất (> importPrice 20%): ");
            float price = Float.parseFloat(scanner.nextLine());
            if (ProductValidate.validateExportPrice(price, product.getImportPrice())) {
                product.setExportPrice(price);
                break;
            }
            System.out.println("Giá xuất phải lớn hơn ít nhất 20% giá nhập!");
        }

        while (true) {
            System.out.print("Nhập số lượng (> 0): ");
            int qty = Integer.parseInt(scanner.nextLine());
            if (ProductValidate.validateQuantity(qty)) {
                product.setQuantity(qty);
                break;
            }
            System.out.println("Số lượng phải lớn hơn 0!");
        }

        System.out.print("Nhập mô tả sản phẩm: ");
        product.setDescriptions(scanner.nextLine());

        System.out.print("Nhập trạng thái (true/false): ");
        product.setStatus(Boolean.parseBoolean(scanner.nextLine()));
    }

    private static void displayProducts() {
        System.out.println("Danh sách sản phẩm:");
        for (int i = 0; i < currentIndex; i++) {
            if (arrProduct[i] != null) {
                Product p = arrProduct[i];
                System.out.printf("Mã SP: %s | Tên SP: %s | Giá nhập: %.2f | Giá xuất: %.2f | Lợi nhuận: %.2f | Số lượng: %d | Mô tả: %s | Trạng thái: %s%n",
                        p.getProductId(), p.getProductName(), p.getImportPrice(), p.getExportPrice(), p.getProfit(),
                        p.getQuantity(), p.getDescriptions(), p.isStatus() ? "Đang bán" : "Không bán");
            }
        }
    }

    private static void calculateProfits() {
        for (int i = 0; i < currentIndex; i++) {
            if (arrProduct[i] != null) {
                ProductBusiness.calculateProfit(arrProduct[i]);
                System.out.println("Lợi nhuận sản phẩm " + arrProduct[i].getProductId() + ": " + arrProduct[i].getProfit());
            }
        }
    }

    private static void sortProductsByProfit() {
        ProductBusiness.sortByProfit(arrProduct, currentIndex);
        System.out.println("Đã sắp xếp theo lợi nhuận giảm dần!");
    }

    private static void statisticByPriceRange(Scanner scanner) {
        System.out.print("Nhập giá từ: ");
        float fromPrice = Float.parseFloat(scanner.nextLine());
        System.out.print("Nhập giá đến: ");
        float toPrice = Float.parseFloat(scanner.nextLine());
        int count = ProductBusiness.countProductsByPriceRange(arrProduct, currentIndex, fromPrice, toPrice);
        System.out.println("Số sản phẩm trong khoảng giá " + fromPrice + " - " + toPrice + ": " + count);
    }

    private static void searchProductsByName(Scanner scanner) {
        System.out.print("Nhập tên sản phẩm cần tìm: ");
        String searchName = scanner.nextLine();
        for (int i = 0; i < currentIndex; i++) {
            if (arrProduct[i] != null && arrProduct[i].getProductName().contains(searchName)) {
                Product p = arrProduct[i];
                System.out.printf("Mã SP: %s | Tên SP: %s | Giá nhập: %.2f | Giá xuất: %.2f | Lợi nhuận: %.2f | Số lượng: %d | Mô tả: %s | Trạng thái: %s%n",
                        p.getProductId(), p.getProductName(), p.getImportPrice(), p.getExportPrice(), p.getProfit(),
                        p.getQuantity(), p.getDescriptions(), p.isStatus() ? "Đang bán" : "Không bán");
            }
        }
    }

    private static void importProduct(Scanner scanner) {
        System.out.print("Nhập mã sản phẩm cần nhập: ");
        String importId = scanner.nextLine();
        System.out.print("Nhập số lượng cần nhập: ");
        int importQty = Integer.parseInt(scanner.nextLine());
        ProductBusiness.importProduct(arrProduct, currentIndex, importId, importQty);
        System.out.println("Đã cập nhật số lượng!");
    }

    private static void sellProduct(Scanner scanner) {
        System.out.print("Nhập tên sản phẩm cần bán: ");
        String sellName = scanner.nextLine();
        System.out.print("Nhập số lượng cần bán: ");
        int sellQty = Integer.parseInt(scanner.nextLine());
        if (ProductBusiness.sellProduct(arrProduct, currentIndex, sellName, sellQty)) {
            System.out.println("Đã bán sản phẩm!");
        } else {
            System.out.println("Không đủ số lượng hoặc sản phẩm không tồn tại!");
        }
    }

    private static void updateProductStatus(Scanner scanner) {
        System.out.print("Nhập mã sản phẩm cần cập nhật trạng thái: ");
        String updateId = scanner.nextLine();
        ProductBusiness.updateStatus(arrProduct, currentIndex, updateId);
        System.out.println("Đã cập nhật trạng thái!");
    }
}