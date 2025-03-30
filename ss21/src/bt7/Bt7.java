package bt7;

import java.util.Scanner;

public class Bt7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount account = new BankAccount(1000000);

        System.out.println("Số dư ban đầu: " + account.getBalance() + " đồng");

        while (true) {
            System.out.print("Nhập số tiền muốn rút (0 để thoát): ");
            try {
                String input = sc.nextLine();
                double amount = Double.parseDouble(input);

                if (amount == 0) {
                    System.out.println("Cảm ơn bạn đã sử dụng dịch vụ!");
                    break;
                }

                if (amount < 0) {
                    throw new Exception("Lỗi: Số tiền rút không được âm!");
                }

                account.withdraw(amount);
                System.out.println("Rút tiền thành công!");
                System.out.println("Số dư còn lại: " + account.getBalance() + " đồng");

            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Vui lòng nhập một số hợp lệ!");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("-------------------");
        }
    }
}