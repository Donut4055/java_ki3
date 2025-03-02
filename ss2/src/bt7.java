import java.util.Scanner;

public class bt7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập giờ ban đầu: ");
        int initialHours = scanner.nextInt();
        System.out.print("Nhập phút ban đầu: ");
        int initialMinutes = scanner.nextInt();
        System.out.print("Nhập giây ban đầu: ");
        int initialSeconds = scanner.nextInt();

        System.out.print("Nhập giờ cần cộng: ");
        int additionalHours = scanner.nextInt();
        System.out.print("Nhập phút cần cộng: ");
        int additionalMinutes = scanner.nextInt();
        System.out.print("Nhập giây cần cộng: ");
        int additionalSeconds = scanner.nextInt();

        int totalInitialSeconds = initialHours * 3600 + initialMinutes * 60 + initialSeconds;

        int totalAdditionalSeconds = additionalHours * 3600 + additionalMinutes * 60 + additionalSeconds;

        int totalFinalSeconds = totalInitialSeconds + totalAdditionalSeconds;

        int finalHours = totalFinalSeconds / 3600;
        int finalMinutes = (totalFinalSeconds % 3600) / 60;
        int finalSeconds = totalFinalSeconds % 60;

        System.out.println("Kết quả sau khi cộng thời gian:");
        System.out.println("Giờ: " + finalHours);
        System.out.println("Phút: " + finalMinutes);
        System.out.println("Giây: " + finalSeconds);
    }
}
