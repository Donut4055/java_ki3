package test.presentation;

import test.entity.Student;

import java.util.*;

public class StudentManagement extends Student {
    static Map<String, Student> students = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);

    public static void addStudent() {
        System.out.print("Nhập mã sinh viên: ");
        String id = scanner.nextLine();

        System.out.print("Nhập tên sinh viên: ");
        String name = scanner.nextLine();

        System.out.print("Nhập tuổi: ");
        int age = scanner.nextInt();

        System.out.print("Nhập điểm trung bình: ");
        float avg_score = scanner.nextFloat();

        Student student = new Student(id, name, age, avg_score);
        students.put(id, student);
        System.out.println("Đã thêm sinh viên: " + student);
    }

    public static void displayStudents() {
        for (Student student : students.values()) {
            System.out.println(student);
        }
    }

    public static void deleteStudent() {
        scanner.nextLine();
        System.out.print("Nhập mã sinh viên cần xóa: ");
        String id = scanner.nextLine();

        if (!students.containsKey(id)) {
            System.out.println("Mã sinh viên không tồn tại!");
            return;
        }

        students.remove(id);
        System.out.println("Đã xóa sinh viên có mã: " + id);
    }

    public static void calculateAverageScore() {
        float total = 0;
        for (Student student : students.values()) {
            total += student.getAvg_score();
        }

        float avg = total / students.size();
        System.out.println("Điểm trung bình của tất cả sinh viên: " + avg);
    }

    public static void displayStudentWithHighestScore() {
        List<Student> studentsList = new ArrayList<>(students.values());
        studentsList.sort(Comparator.comparing(Student::getAvg_score).reversed());

        Student student = studentsList.getFirst();
        System.out.println("Sinh viên có điểm trung bình cao nhất: " + student);
    }

    public static void displayStudentWithLowestAge() {
        List<Student> studentsList = new ArrayList<>(students.values());
        studentsList.sort(Comparator.comparing(Student::getAge));

        Student student = studentsList.getFirst();
        System.out.println("Sinh viên có tuổi nhỏ nhất: " + student);
    }

}
