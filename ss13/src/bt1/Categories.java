package bt1;

import java.util.Scanner;

public class Categories implements IApp {
    private int id;
    private String name;
    private int priority;
    private String description;
    private boolean active;

    public Categories() {
        this.id = 0; //auto increment
    }

    public Categories(int id, String name, int priority, String description, boolean active) {
        this.id = id;
        this.name = name;
        this.priority = priority;
        this.description = description;
        this.active = active;
    }

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

    @Override
    public void inputData(Scanner scanner) {
        System.out.println("=== Thêm mới danh mục ===");
        System.out.print("Tên danh mục: ");
        this.name = scanner.nextLine();
        System.out.print("Mã ưu tiên: ");
        this.priority = Integer.parseInt(scanner.nextLine());
        System.out.print("Mô tả ngắn: ");
        this.description = scanner.nextLine();
        System.out.println();
        this.active = true;
    }

    @Override
    public void displayData() {
        System.out.println("=== Thông tin danh mục ===");
        System.out.println("ID: " + id);
        System.out.println("Tên danh mục: " + name);
        System.out.println("Mã ưu tiên: " + priority);
        System.out.println("Trạng thái: " + (active ? "Hoạt động" : "Không hoạt động"));
        System.out.println("------------------------");
    }
}