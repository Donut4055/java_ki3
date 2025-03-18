package bt2;

import java.util.Scanner;

public class Product implements IApp {
    // Constants for status
    public static final int STATUS_ACTIVE = 0;
    public static final int STATUS_OUT_OF_STOCK = 1;
    public static final int STATUS_INACTIVE = 2;

    private String code;
    private String name;
    private float importPrice;
    private float exportPrice;
    private String header;
    private String description;
    private int quantity;
    private int categoryId;
    private int status;

    // Constructors
    public Product() {
        this.status = STATUS_ACTIVE;
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
        this.status = STATUS_ACTIVE;
    }

    // Getters & Setters
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

    public boolean isActive() {
        return this.status == STATUS_ACTIVE;
    }

    private String getStatusText() {
        return switch (status) {
            case STATUS_ACTIVE -> "Đang hoạt động";
            case STATUS_OUT_OF_STOCK -> "Hết hàng";
            case STATUS_INACTIVE -> "Không hoạt động";
            default -> "Không xác định";
        };
    }

    // Input data
    @Override
    public void inputData(Scanner scanner) {
        System.out.println("=== Thêm mới sản phẩm ===");
        this.code = inputString(scanner, "Mã sản phẩm (C/E/T): ");
        this.name = inputString(scanner, "Tên sản phẩm: ");
        this.importPrice = inputFloat(scanner, "Giá nhập: ");
        this.exportPrice = inputFloat(scanner, "Giá xuất: ");
        this.header = inputString(scanner, "Tiêu đề: ");
        this.description = inputString(scanner, "Mô tả ngắn: ");
        this.quantity = inputInt(scanner, "Số lượng: ");
        this.categoryId = inputInt(scanner, "ID danh mục: ");
        this.status = STATUS_ACTIVE;
        System.out.println();
    }

    // Display data
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
        System.out.println("Trạng thái: " + getStatusText());
        System.out.println("------------------------");
    }

    public void sortByPrice() {
        System.out.println("Sắp xếp theo giá tăng dần (chỉ 1 sản phẩm):");
        displayData();
    }

    @Override
    public String toString() {
        return "Product{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", importPrice=" + importPrice +
                ", exportPrice=" + exportPrice +
                '}';
    }

    // Utility methods for input
    private String inputString(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    private int inputInt(Scanner scanner, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên hợp lệ.");
            }
        }
    }

    private float inputFloat(Scanner scanner, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Float.parseFloat(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số thực hợp lệ.");
            }
        }
    }
}
//Gom các hằng số status để tăng tính dễ đọc và tránh "magic number".
//Tách phần nhập dữ liệu thành các hàm riêng để dễ kiểm soát validate.
//Tối ưu displayData() cho dễ mở rộng.
//Gợi ý thêm getter định dạng trạng thái.