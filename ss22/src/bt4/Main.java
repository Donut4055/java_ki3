package bt4;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        String fileName = "student.dat";

        Student student = new Student("Nguyễn Văn A", 20, 8.5);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(student);
            System.out.println("Đã ghi đối tượng vào file " + fileName);
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file: " + e.getMessage());
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            Student readStudent = (Student) ois.readObject();
            System.out.println("Đã đọc đối tượng từ file " + fileName);
            System.out.println(readStudent);
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Không tìm thấy lớp Student: " + e.getMessage());
        }
    }
}
