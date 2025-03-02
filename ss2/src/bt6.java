import java.util.Scanner;

public class bt6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String studentName;
        float subject1, subject2, subject3, average;
        String evaluation;


        System.out.print("ten: ");
        studentName = scanner.nextLine();

        System.out.print("diem mon 1: ");
        subject1 = scanner.nextFloat();

        System.out.print("diem mon 2: ");
        subject2 = scanner.nextFloat();

        System.out.print("diem mon 3: ");
        subject3 = scanner.nextFloat();

        average = (subject1 + subject2 + subject3) / 3;

        evaluation = average >= 5 ? "lên lớp" : "học lại";

        System.out.println("ten: " + studentName);
        System.out.println("mon 1 diem: " + subject1);
        System.out.println("mon 2 diem: " + subject2);
        System.out.println("mon 3 diem: " + subject3);
        System.out.println("diem trung binh: " + average);
        System.out.println("danh gia: " + evaluation);
    }
}
