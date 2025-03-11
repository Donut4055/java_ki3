package Bt10;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<Student> students = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Hiển thị danh sách tất cả sinh viên");
            System.out.println("2. Thêm mới sinh viên");
            System.out.println("3. Sửa thông tin sinh viên theo mã HS");
            System.out.println("4. Xóa sinh viên");
            System.out.println("5. Thoát");
            System.out.print("Chọn: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    showStudents();
                    break;
                case 2:
                    addStudent();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 5);
    }

    public static void showStudents() {
        if (students.isEmpty()) {
            System.out.println("Danh sách rỗng!");
        } else {
            for (Student s : students) {
                s.displayData();
            }
        }
    }

    public static void addStudent() {
        Student s = new Student();
        s.inputData();
        students.add(s);
        System.out.println("Thêm sinh viên thành công.");
    }

    public static void updateStudent() {
        System.out.print("Nhập mã HS cần sửa: ");
        int id = Integer.parseInt(sc.nextLine());
        boolean found = false;
        for (Student s : students) {
            if (s.getId() == id) {
                System.out.println("Nhập lại thông tin mới:");
                s.updateInfo();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy sinh viên có mã: " + id);
        }
    }

    public static void deleteStudent() {
        System.out.print("Nhập mã HS cần xóa: ");
        int id = Integer.parseInt(sc.nextLine());
        Student toRemove = null;
        for (Student s : students) {
            if (s.getId() == id) {
                toRemove = s;
                break;
            }
        }
        if (toRemove != null) {
            students.remove(toRemove);
            System.out.println("Xóa thành công.");
        } else {
            System.out.println("Không tìm thấy sinh viên.");
        }
    }
}

