package test.entity;

import java.util.Optional;
import java.util.Scanner;

public class Customer implements IApp {
    private static int id;
    private String name;
    private Optional<String> email;

    public Customer() {}

    public Customer(String name, String email) {
        this.name = name;
        this.email = Optional.of(email);
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Optional<String> getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = Optional.of(email);
    }
    public void setName(String name) {
        this.name = name;
    }


    @Override
    public void inputData(Scanner scanner) {
        System.out.println("nhap ten khach hang: ");
        this.name = scanner.nextLine();
        System.out.println("nhap email khach hang: ");
        this.email = Optional.of(scanner.nextLine());
    }

    @Override
    public String toString() {
        return "Customer{id=" + id + ", name='" + name + "', email=" + email.orElse("Không có email") + "}";
    }
}
