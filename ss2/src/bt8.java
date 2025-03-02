import java.util.Scanner;

public class bt8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String studentId, fullName, birthDate, gender, phoneNumber;
        double math, physics, chemistry, biology, foreignLanguage, averageScore;

        System.out.print("Nhập mã sinh viên: ");
        studentId = scanner.nextLine();

        System.out.print("Nhập họ và tên: ");
        fullName = scanner.nextLine();

        System.out.print("Nhập ngày sinh: ");
        birthDate = scanner.nextLine();

        System.out.print("Nhập giới tính: ");
        gender = scanner.nextLine();

        System.out.print("Nhập số điện thoại: ");
        phoneNumber = scanner.nextLine();

        System.out.print("Nhập điểm Toán: ");
        math = scanner.nextDouble();

        System.out.print("Nhập điểm Vật lý: ");
        physics = scanner.nextDouble();

        System.out.print("Nhập điểm Hóa học: ");
        chemistry = scanner.nextDouble();

        System.out.print("Nhập điểm Sinh học: ");
        biology = scanner.nextDouble();

        System.out.print("Nhập điểm Ngoại ngữ: ");
        foreignLanguage = scanner.nextDouble();

        averageScore = (math + physics + chemistry + biology + foreignLanguage) / 5;

        System.out.println("\n===== THÔNG TIN SINH VIÊN =====");
        System.out.println("Mã sinh viên: " + studentId);
        System.out.println("Họ và tên: " + fullName);
        System.out.println("Ngày sinh: " + birthDate);
        System.out.println("Giới tính: " + gender);
        System.out.println("Số điện thoại: " + phoneNumber);
        System.out.println("\n===== ĐIỂM CÁC MÔN =====");
        System.out.println("Toán: " + math);
        System.out.println("Vật lý: " + physics);
        System.out.println("Hóa học: " + chemistry);
        System.out.println("Sinh học: " + biology);
        System.out.println("Ngoại ngữ: " + foreignLanguage);
        System.out.printf("Điểm trung bình: %.2f\n", averageScore);
    }
}
