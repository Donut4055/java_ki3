package entity;

import java.util.Scanner;

public class Product implements IApp {
    private String code;
    private String name;
    private float importPrice;
    private float exportPrice;
    private String header;
    private String description;
    private int quantity;
    private int categoryId;
    private int status;

    public Product() {
        this.status = 0; // 0: Hoạt động, 1: Hết hàng, 2: Không hoạt động
    }

    public Product(String code, String name, float importPrice, float exportPrice,
                   String header, String description, int quantity, int categoryId) {
        this.code = code;
        this.name = name;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.header = header;
        this.description = description;
        this.quantity = quantity;
        this.categoryId = categoryId;
        this.status = 0;
    }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public float getImportPrice() { return importPrice; }
    public void setImportPrice(float importPrice) { this.importPrice = importPrice; }

    public float getExportPrice() { return exportPrice; }
    public void setExportPrice(float exportPrice) { this.exportPrice = exportPrice; }

    public String getHeader() { return header; }
    public void setHeader(String header) { this.header = header; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public int getCategoryId() { return categoryId; }
    public void setCategoryId(int categoryId) { this.categoryId = categoryId; }

    public int getStatus() { return status; }
    public void setStatus(int status) { this.status = status; }

    @Override
    public void inputData(Scanner scanner) {
        System.out.println("=== Thêm mới sản phẩm ===");
        System.out.print("Mã sản phẩm (C/E/T): ");
        this.code = scanner.nextLine();
        System.out.print("Tên sản phẩm: ");
        this.name = scanner.nextLine();
        System.out.print("Giá nhập: ");
        this.importPrice = Float.parseFloat(scanner.nextLine());
        System.out.print("Giá xuất: ");
        this.exportPrice = Float.parseFloat(scanner.nextLine());
        System.out.print("Tiêu đề: ");
        this.header = scanner.nextLine();
        System.out.print("Mô tả ngắn: ");
        this.description = scanner.nextLine();
        System.out.print("Số lượng: ");
        this.quantity = Integer.parseInt(scanner.nextLine());
        System.out.print("ID danh mục: ");
        this.categoryId = Integer.parseInt(scanner.nextLine());
        System.out.println();
        this.status = 0;
    }

    @Override
    public void displayData() {
        System.out.println("=== Thông tin sản phẩm ===");
        System.out.println("Mã sản phẩm: " + code);
        System.out.println("Tên sản phẩm: " + name);
        System.out.println("Giá nhập: " + importPrice);
        System.out.println("Giá xuất: " + exportPrice);
        System.out.println("Tiêu đề: " + header);
        System.out.println("Mô tả ngắn: " + description);
        System.out.println("Số lượng còn: " + quantity);
        System.out.println("Trạng thái: " +
                (status == 0 ? "Đang hoạt động" : status == 1 ? "Hết hàng" : "Không hoạt động"));
        System.out.println("------------------------");
    }

    public void sortByPrice() {
        System.out.println("Sắp xếp theo giá tăng dần (chỉ 1 sản phẩm):");
        displayData();
    }

    public boolean isActive() {
        return status == 0;
    }

    @Override
    public String toString() {
        return "Product{code='" + code + "', name='" + name + "', importPrice=" + importPrice + "}";
    }
}