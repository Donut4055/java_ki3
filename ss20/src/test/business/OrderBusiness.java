package test.business;

import test.entity.Order;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class OrderBusiness implements IOrderBusiness {
    public static List<Order> orders = new ArrayList<>();
    public static void addOrder(Scanner sc) {
        System.out.println("Add order");
        Order order = new Order();
        order.inputData(sc);
        orders.add(order);
    }

    public static void displayOrder() {
        orders.forEach(System.out::println);
    }

    public static void updateStatus(Scanner sc) {
        System.out.println("nhap id don hang can sua");
        int id = sc.nextInt();
        orders.stream()
                .filter(o -> o.getId() == id)
                .findFirst()
                .ifPresent(o -> o.setStatus(sc.nextBoolean())
        );
    }

    public static List<Order> getOrderOverdue() {
        return orders.stream()
                .filter(o -> o.getOrderDate().isBefore(LocalDate.now()))
                .filter(o -> !o.getStatus())
                .toList();
    }

    public static List<Order> getOrderDelivied() {
        return orders.stream()
                .filter(Order::getStatus)
                .toList();
    }

    public double getTotalRevenue() {
        return orders.stream()
                .filter(Order::getStatus)
                .mapToDouble(Order::getTotalAmount)
                .sum();
    }

}
