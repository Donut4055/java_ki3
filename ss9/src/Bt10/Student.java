package Bt10;

import java.util.Scanner;

public class Student {
    private int id;
    private String name;
    private int age;
    private Gender gender;
    private String address;
    private String phoneNumber;

    public Student() {}

    public Student(int id, String name, int age, Gender gender, String address, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public void inputData() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã HS: ");
        this.id = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập tên HS: ");
        this.name = sc.nextLine();
        System.out.print("Nhập tuổi: ");
        this.age = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập giới tính (MALE/FEMALE/OTHER): ");
        this.gender = Gender.valueOf(sc.nextLine().toUpperCase());
        System.out.print("Nhập địa chỉ: ");
        this.address = sc.nextLine();
        System.out.print("Nhập số điện thoại: ");
        this.phoneNumber = sc.nextLine();
    }

    public void displayData() {
        System.out.println("Mã HS: " + id);
        System.out.println("Tên HS: " + name);
        System.out.println("Tuổi: " + age);
        System.out.println("Giới tính: " + gender);
        System.out.println("Địa chỉ: " + address);
        System.out.println("SĐT: " + phoneNumber);
        System.out.println("----------------------------");
    }

    public int getId() {
        return id;
    }

    public void updateInfo() {
        inputData();
    }
}
