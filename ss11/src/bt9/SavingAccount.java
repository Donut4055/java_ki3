package bt9;

public class SavingAccount extends BankAccount {

    public SavingAccount(String accountNumber) {
        super(accountNumber);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > getBalance()) {
            System.out.println("Rút tiền không thành công. Số dư không đủ.");
        } else {
            setBalance(getBalance() - amount);
            System.out.println("Rút tiền thành công: $" + amount);
        }
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            setBalance(getBalance() + amount);
            System.out.println("Nạp tiền thành công: $" + amount);
        } else {
            System.out.println("Số tiền nạp vào không hợp lệ.");
        }
    }

    @Override
    public void displayBalance() {
        System.out.println("Loại tài khoản: Tài khoản tiết kiệm");
        System.out.println("Số tài khoản: " + getAccountNumber());
        System.out.println("Số dư: $" + getBalance());
    }
}