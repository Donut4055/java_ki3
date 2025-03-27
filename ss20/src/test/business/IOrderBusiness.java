package test.business;

import test.entity.Order;

import java.util.List;
import java.util.Scanner;

public interface IOrderBusiness {
    static void addOrder(Scanner scanner) {

    }

    static void displayOrder() {

    }

    static  void updateStatus(Scanner scanner){

    };

    static List<Order> getOrderOverdue(){
        return null;
    };

    static List<Order> getOrderDelivied(){
        return null;
    };

    default double getTotalRevenue() {
        return 0;
    }
}
