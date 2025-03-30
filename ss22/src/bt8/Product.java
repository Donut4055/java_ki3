package bt8;

import java.io.Serializable;

class Product implements Serializable {
    private static final long serialVersionUID = 1L; // Đảm bảo phiên bản Serializable ổn định

    private int id;
    private String name;
    private double price;

    public Product() {
    }
    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("ID: %d | Tên: %-15s | Giá: %.2f", id, name, price);
    }
}

