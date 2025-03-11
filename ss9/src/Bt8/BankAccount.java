package Bt8;

public class BankAccount {
    public String accountNumber;
    public String accountHolder;
    public double balance;

    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Đã nạp " + amount + " vào tài khoản.");
        } else {
            System.out.println("Số tiền nạp không hợp lệ.");
        }
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Số dư không đủ để rút tiền.");
        } else if (amount > 0) {
            balance -= amount;
            System.out.println("Đã rút " + amount + " khỏi tài khoản.");
        } else {
            System.out.println("Số tiền rút không hợp lệ.");
        }
    }

    public void transfer(BankAccount recipient, double amount) {
        if (amount > balance) {
            System.out.println("Không đủ số dư để chuyển tiền.");
        } else if (amount > 0) {
            this.balance -= amount;
            recipient.balance += amount;
            System.out.println("Đã chuyển " + amount + " đến tài khoản của " + recipient.accountHolder);
        } else {
            System.out.println("Số tiền chuyển không hợp lệ.");
        }
    }

    public void display() {
        System.out.println("Số tài khoản: " + accountNumber);
        System.out.println("Chủ tài khoản: " + accountHolder);
        System.out.println("Số dư hiện tại: " + balance);
        System.out.println("-------------------------------");
    }
}
