import java.util.Scanner;

public class Bt3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float score = sc.nextFloat();
        if (score < 0 || score > 10) {
            System.out.println("diem khong hop le");
            return;
        }
        if (score >= 8.0) {
            System.out.println("Xep loai gioi");
        } else if (score >= 6.5) {
            System.out.println("Xep loai kha");
        } else if (score >= 5.0) {
            System.out.println("xep loai trung binh");
        } else {
            System.out.println("xep loai yeu");
        }
    }
}
