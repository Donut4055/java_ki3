package test.bussiness;

import test.entity.Student;
import test.presentation.StudentManagement;

import java.util.Scanner;

public class Main extends StudentManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Quản lý sinh viên ===");
            System.out.println("1. Danh sách sinh viên");
            System.out.println("2. Thêm mới các sinh viên");
            System.out.println("3. Xóa sinh viên theo mã sinh viên");
            System.out.println("4. Tính điểm trung bình của tất cả sinh viên");
            System.out.println("5. In thông tin sinh viên có điểm trung bình lớn nhất");
            System.out.println("6. In thông tin sinh viên có tuổi nhỏ nhất");
            System.out.println("7. Thoát");
            System.out.print("Chọn chức năng (1-7): ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: displayStudents(); break;
                case 2: addStudent(); break;
                case 3: deleteStudent(); break;
                case 4: calculateAverageScore(); break;
                case 5: displayStudentWithHighestScore(); break;
                case 6: displayStudentWithLowestAge(); break;
                case 7: System.out.println("Đã thoát chương trình!"); return;
                default: System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}
