package test.business;

import test.entity.Customer;

import java.util.*;

public class CustomerBusiness {
    static List<Customer> customers = new LinkedList<>();
    static Scanner sc = new Scanner(System.in);
    public static void addCustomer() {
        System.out.println("them khach hang");
        Customer customer = new Customer();
        customer.inputData(sc);
        customers.add(customer);
    }

    public static void displayCustomer() {
        customers.forEach(System.out::println);
    }
}
