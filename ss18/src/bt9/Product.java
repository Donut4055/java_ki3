package bt9;

import javax.swing.*;

public class Product {
    private int id;
    private String name;
    private double price;
    private int quantity;

    public Product() {}

    public Product(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() { return id; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public void setPrice(double price) { this.price = price; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Price: " + price + ", Quantity: " + quantity;
    }
}
