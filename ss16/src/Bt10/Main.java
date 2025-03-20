package Bt10;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private ArrayList<Student> students;
    private Scanner scanner;

    public Main() {
        students = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void inputStudents() {
        System.out.println("Nhập số lượng sinh viên: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin sinh viên thứ " + (i + 1) + ":");
            System.out.print("Mã sinh viên: ");
            String id = scanner.nextLine();
            System.out.print("Họ và tên: ");
            String name = scanner.nextLine();
            System.out.print("Điểm trung bình (GPA): ");
            double gpa = scanner.nextDouble();

            Student student = new Student(id, name, gpa);
            students.add(student);
        }
        System.out.println("Đã nhập xong danh sách sinh viên!");
    }

    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("Danh sách sinh viên rỗng!");
            return;
        }
        System.out.println("Danh sách sinh viên:");
        for (Student student : students) {
            student.display();
        }
    }

    public void searchByName() {
        if (students.isEmpty()) {
            System.out.println("Danh sách sinh viên rỗng!");
            return;
        }
        System.out.print("Nhập tên sinh viên cần tìm: ");
        String searchName = scanner.nextLine().toLowerCase();
        boolean found = false;

        System.out.println("Kết quả tìm kiếm:");
        for (Student student : students) {
            if (student.getName().toLowerCase().contains(searchName)) {
                student.display();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy sinh viên nào với tên: " + searchName);
        }
    }

    public void classifyStudents() {
        if (students.isEmpty()) {
            System.out.println("Danh sách sinh viên rỗng!");
            return;
        }
        System.out.println("Danh sách sinh viên sau khi phân loại:");
        for (Student student : students) {
            System.out.printf("Mã SV: %-10s | Họ và tên: %-20s | GPA: %.2f | Xếp loại: %s\n",
                    student.getId(), student.getName(), student.getGpa(), student.classifyGpa());
        }
    }

    public void menu() {
        int choice;
        do {
            System.out.println("\n=== QUẢN LÝ SINH VIÊN ===");
            System.out.println("1. Nhập danh sách sinh viên");
            System.out.println("2. In danh sách sinh viên");
            System.out.println("3. Tìm kiếm sinh viên theo tên");
            System.out.println("4. Phân loại sinh viên theo GPA");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng (1-5): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    inputStudents();
                    break;
                case 2:
                    displayStudents();
                    break;
                case 3:
                    searchByName();
                    break;
                case 4:
                    classifyStudents();
                    break;
                case 5:
                    System.out.println("Thoát chương trình!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 5);
    }

    public static void main(String[] args) {
        Main management = new Main();
        management.menu();
    }
}
