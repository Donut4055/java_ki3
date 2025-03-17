package bt9;

public class CheckingAccount extends BankAccount {

    public CheckingAccount(String accountNumber) {
        super(accountNumber);
    }

    @Override
    public void withdraw(double amount) {
        setBalance(getBalance() - amount);
        System.out.println("Rút tiền thành công: $" + amount);
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
        System.out.println("Loại tài khoản: Tài khoản vãng lai");
        System.out.println("Số tài khoản: " + getAccountNumber());
        System.out.println("Số dư: $" + getBalance());
    }
}
