package bt9;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<BankAccount> accounts = new ArrayList<>();
        accounts.add(new BankAccount("ACC001", 1000000));
        accounts.add(new BankAccount("ACC002", 500000));

        while (true) {
            System.out.println("\n=== HỆ THỐNG NGÂN HÀNG ===");
            System.out.println("1. Xem danh sách tài khoản");
            System.out.println("2. Gửi tiền");
            System.out.println("3. Rút tiền");
            System.out.println("4. Chuyển tiền");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Vui lòng nhập số hợp lệ!");
                continue;
            }

            if (choice == 0) {
                System.out.println("Cảm ơn bạn đã sử dụng hệ thống!");
                break;
            }

            switch (choice) {
                case 1:
                    System.out.println("\nDanh sách tài khoản:");
                    for (BankAccount acc : accounts) {
                        System.out.println(acc);
                    }
                    break;

                case 2:
                    System.out.print("Nhập số tài khoản: ");
                    String depositId = sc.nextLine();
                    BankAccount depositAcc = findAccount(accounts, depositId);
                    if (depositAcc != null) {
                        System.out.print("Nhập số tiền gửi: ");
                        try {
                            double depositAmount = Double.parseDouble(sc.nextLine());
                            depositAcc.deposit(depositAmount);
                            System.out.println("Gửi tiền thành công! " + depositAcc);
                        } catch (NumberFormatException e) {
                            System.out.println("Lỗi: Số tiền không hợp lệ!");
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println("Tài khoản không tồn tại!");
                    }
                    break;

                case 3:
                    System.out.print("Nhập số tài khoản: ");
                    String withdrawId = sc.nextLine();
                    BankAccount withdrawAcc = findAccount(accounts, withdrawId);
                    if (withdrawAcc != null) {
                        System.out.print("Nhập số tiền rút: ");
                        try {
                            double withdrawAmount = Double.parseDouble(sc.nextLine());
                            withdrawAcc.withdraw(withdrawAmount);
                            System.out.println("Rút tiền thành công! " + withdrawAcc);
                        } catch (NumberFormatException e) {
                            System.out.println("Lỗi: Số tiền không hợp lệ!");
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println("Tài khoản không tồn tại!");
                    }
                    break;

                case 4:
                    System.out.print("Nhập số tài khoản nguồn: ");
                    String fromId = sc.nextLine();
                    BankAccount fromAcc = findAccount(accounts, fromId);
                    if (fromAcc == null) {
                        System.out.println("Tài khoản nguồn không tồn tại!");
                        break;
                    }

                    System.out.print("Nhập số tài khoản đích: ");
                    String toId = sc.nextLine();
                    BankAccount toAcc = findAccount(accounts, toId);

                    if (toAcc != null) {
                        System.out.print("Nhập số tiền chuyển: ");
                        try {
                            double transferAmount = Double.parseDouble(sc.nextLine());
                            fromAcc.transfer(toAcc, transferAmount);
                            System.out.println("Chuyển tiền thành công!");
                            System.out.println("Nguồn: " + fromAcc);
                            System.out.println("Đích: " + toAcc);
                        } catch (NumberFormatException e) {
                            System.out.println("Lỗi: Số tiền không hợp lệ!");
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println("Tài khoản đích không tồn tại!");
                    }
                    break;

                default:
                    System.out.println("Chức năng không hợp lệ!");
            }
        }

    }

    private static BankAccount findAccount(ArrayList<BankAccount> accounts, String accountId) {
        for (BankAccount acc : accounts) {
            if (acc.getAccountId().equals(accountId)) {
                return acc;
            }
        }
        return null;
    }
}