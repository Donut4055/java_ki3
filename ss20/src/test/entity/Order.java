package test.entity;

import java.time.LocalDate;
import java.util.Scanner;

import static test.business.OrderBusiness.orders;

public class Order implements IApp {
    private int id;
    private Customer customer;
    private LocalDate orderDate;
    private double totalAmount;
    private Boolean status;

    public Order(){}
    public Order(int id,  Customer customer, LocalDate orderDate, double totalAmount, Boolean status) {
        this.id = orders.getLast().getId() + 1;
        this.customer = customer;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.status = status;
    }

    public int getId() {
        return id;
    }
    public Customer getCustomer() {
        return customer;
    }
    public LocalDate getOrderDate() {
        return orderDate;
    }
    public double getTotalAmount() {
        return totalAmount;
    }
    public Boolean getStatus() {
        return status;
    }


    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public void inputData(Scanner scanner) {
        this.customer = new Customer();
        this.customer.inputData(scanner);
        System.out.println("nhap ngay dat: "); // YYYY-MM-DD
        this.orderDate = LocalDate.parse(scanner.nextLine());
        System.out.println("nhap tong gia san pham: ");
        this.totalAmount = scanner.nextDouble();
        this.status = false;
    }

    @Override
    public String toString() {
        return "Order{id=" + id + ", customer=" + customer + ", orderDate=" + orderDate + ", totalAmount=" + totalAmount + ", status=" + status + "}";
    }
}
