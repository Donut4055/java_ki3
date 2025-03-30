import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Bt2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String fileName = sc.nextLine();

        File file = new File(fileName);

        try {
            if (file.exists()) {
                System.out.println("Tệp đã tồn tại!");
            } else {
                boolean created = file.createNewFile();
                if (created) {
                    System.out.println("Tệp đã được tạo!");
                } else {
                    System.out.println("Không thể tạo tệp!");
                }
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi xử lý tệp: " + e.getMessage());
        }

    }
}
