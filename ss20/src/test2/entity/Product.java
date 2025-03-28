package test2.entity;


import java.time.LocalDate;
import java.util.Scanner;

public class Product implements IProduct {
    private static int autoId = 0;
    private int productId;
    private String productName;
    private float price;
    private String category;
    private LocalDate createdDate;

    public Product() {
        this.productId = ++autoId;
        this.createdDate = LocalDate.now();
    }

    public Product(String productName, float price, String category) {
        this.productId = ++autoId;
        this.productName = productName;
        this.price = price;
        this.category = category;
        this.createdDate = LocalDate.now();
    }

    public int getProductId() { return productId; }
    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }
    public float getPrice() { return price; }
    public void setPrice(float price) { this.price = price; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public LocalDate getCreatedDate() { return createdDate; }

    @Override
    public void inputData(Scanner scanner) {
        System.out.print("ten san pham: ");
        this.productName = scanner.nextLine();
        while (this.productName.length() < 30 || this.productName.length() > 100) {
            System.out.print("ten phai co it nhat 30 ki tu va nhieu nhat 100 ki tu: ");
            this.productName = scanner.nextLine();
        }

        System.out.print("nhap gia (>0): ");
        this.price = Float.parseFloat(scanner.nextLine());
        while (this.price <= 0) {
            System.out.print("gia phai lon hon 0: ");
            this.price = Float.parseFloat(scanner.nextLine());
        }

        System.out.print("nhap danh muc: ");
        this.category = scanner.nextLine();
    }

    @Override
    public void displayData() {
        System.out.printf("ID: %d | Name: %s | Price: %.2f | Category: %s | Created: %s%n",
                productId, productName, price, category, createdDate);
    }
}
