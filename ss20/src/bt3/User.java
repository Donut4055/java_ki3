package bt3;

import java.util.Optional;

public class  User {
    String name;
    Optional<String> phoneNumber;

    public User() {}

    public User(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = Optional.ofNullable(phoneNumber);
    }

    public void printInfo() {
        System.out.println("Name: " + name + ", Phone number: " + phoneNumber.orElse("không có"));
    }
}
