package bt2;

import java.util.Scanner;

/**
 * Lớp Categories đại diện cho một danh mục sản phẩm hoặc mục nội dung.
 */
public class Categories implements IApp {
    private int id;
    private String name;
    private int priority;
    private String description;
    private boolean active;

    /**
     * Constructor mặc định - gán ID mặc định là 0 (có thể dùng auto increment sau).
     */
    public Categories() {
        this.id = 0;
    }

    /**
     * Constructor đầy đủ tham số.
     */
    public Categories(int id, String name, int priority, String description, boolean active) {
        this.id = id;
        this.name = name;
        this.priority = priority;
        this.description = description;
        this.active = active;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getPriority() { return priority; }
    public void setPriority(int priority) { this.priority = priority; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    /**
     * Nhập dữ liệu danh mục từ người dùng.
     */
    @Override
    public void inputData(Scanner scanner) {
        System.out.println("=== Nhập thông tin danh mục ===");

        System.out.print("Tên danh mục: ");
        this.name = scanner.nextLine().trim();

        System.out.print("Mức độ ưu tiên: ");
        while (true) {
            try {
                this.priority = Integer.parseInt(scanner.nextLine().trim());
                break;
            } catch (NumberFormatException e) {
                System.out.print("Giá trị không hợp lệ. Vui lòng nhập số nguyên: ");
            }
        }

        System.out.print("Mô tả danh mục: ");
        this.description = scanner.nextLine().trim();

        this.active = true;
        System.out.println("Danh mục đã được kích hoạt mặc định.");
    }

    /**
     * Hiển thị thông tin danh mục ra màn hình.
     */
    @Override
    public void displayData() {
        System.out.println("\n=== Thông tin chi tiết danh mục ===");
        System.out.println("ID           : " + id);
        System.out.println("Tên danh mục : " + name);
        System.out.println("Ưu tiên      : " + priority);
        System.out.println("Mô tả        : " + description);
        System.out.println("Trạng thái   : " + (active ? "Hoạt động" : "Không hoạt động"));
        System.out.println("----------------------------------");
    }
}
//Lợi ích của refactoring lần này:
//Dễ đọc, dễ bảo trì và mở rộng.
//Giao diện người dùng (CLI) thân thiện hơn.
//Giảm rủi ro lỗi đầu vào.