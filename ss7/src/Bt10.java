import java.util.Scanner;

public class Bt10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder str = new StringBuilder();

        System.out.print("Nhập chuỗi ban đầu: ");
        str.append(sc.nextLine());

        int choice;

        do {
            System.out.println("\n========= MENU =========");
            System.out.println("1. Đảo ngược chuỗi");
            System.out.println("2. Chèn chuỗi vào vị trí bất kỳ");
            System.out.println("3. Xóa một đoạn trong chuỗi");
            System.out.println("4. Thay thế một đoạn trong chuỗi");
            System.out.println("5. Chuyển đổi chữ hoa/chữ thường");
            System.out.println("6. Thoát chương trình");
            System.out.print("Lựa chọn của bạn: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    str.reverse();
                    System.out.println("Chuỗi sau khi đảo ngược: " + str);
                    break;

                case 2:
                    System.out.print("Nhập chuỗi cần chèn: ");
                    String insertStr = sc.nextLine();
                    System.out.print("Nhập vị trí cần chèn (0 - " + str.length() + "): ");
                    int insertPos = sc.nextInt();
                    sc.nextLine();
                    if (insertPos >= 0 && insertPos <= str.length()) {
                        str.insert(insertPos, insertStr);
                        System.out.println("Chuỗi sau khi chèn: " + str);
                    } else {
                        System.out.println("Vị trí chèn không hợp lệ!");
                    }
                    break;

                case 3:
                    System.out.print("Nhập vị trí bắt đầu: ");
                    int start = sc.nextInt();
                    System.out.print("Nhập vị trí kết thúc: ");
                    int end = sc.nextInt();
                    sc.nextLine();
                    if (start >= 0 && end <= str.length() && start < end) {
                        str.delete(start, end);
                        System.out.println("Chuỗi sau khi xóa: " + str);
                    } else {
                        System.out.println("Vị trí không hợp lệ!");
                    }
                    break;

                case 4:
                    System.out.print("Nhập vị trí bắt đầu: ");
                    int replaceStart = sc.nextInt();
                    System.out.print("Nhập vị trí kết thúc: ");
                    int replaceEnd = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nhập chuỗi thay thế: ");
                    String replaceStr = sc.nextLine();
                    if (replaceStart >= 0 && replaceEnd <= str.length() && replaceStart < replaceEnd) {
                        str.replace(replaceStart, replaceEnd, replaceStr);
                        System.out.println("Chuỗi sau khi thay thế: " + str);
                    } else {
                        System.out.println("Vị trí không hợp lệ!");
                    }
                    break;

                case 5:
                    System.out.println("1. Chuyển sang CHỮ HOA");
                    System.out.println("2. Chuyển sang chữ thường");
                    int option = sc.nextInt();
                    sc.nextLine();
                    if (option == 1) {
                        str = new StringBuilder(str.toString().toUpperCase());
                        System.out.println("Chuỗi sau khi chuyển sang chữ HOA: " + str);
                    } else if (option == 2) {
                        str = new StringBuilder(str.toString().toLowerCase());
                        System.out.println("Chuỗi sau khi chuyển sang chữ thường: " + str);
                    } else {
                        System.out.println("Lựa chọn không hợp lệ!");
                    }
                    break;

                case 6:
                    System.out.println("Thoát chương trình. Tạm biệt!");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (choice != 6);

        sc.close();
    }
}
