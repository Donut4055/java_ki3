package bt7;

public class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) throws Exception {
        if (amount > balance) {
            throw new Exception("Lỗi: Số tiền rút vượt quá số dư!");
        }
        if (balance - amount < 50000) {
            throw new Exception("Lỗi: Tài khoản phải duy trì số dư tối thiểu 50.000 đồng!");
        }
        balance -= amount;
    }
}

