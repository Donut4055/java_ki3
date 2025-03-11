package Bt8;

public class Main {
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("123456", "Nguyen Van A", 5000);
        BankAccount acc2 = new BankAccount("789012", "Tran Thi B", 3000);

        System.out.println("Thông tin tài khoản ban đầu:");
        acc1.display();
        acc2.display();

        acc1.deposit(1500);
        acc1.display();

        acc2.withdraw(1000);
        acc2.display();

        acc1.transfer(acc2, 2000);
        acc1.display();
        acc2.display();
    }
}

