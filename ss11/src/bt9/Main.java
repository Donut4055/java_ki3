package bt9;

public class Main {
    public static void main(String[] args) {
        SavingAccount savingAccount = new SavingAccount("SA123");
        CheckingAccount checkingAccount = new CheckingAccount("CA456");

        Bank bank = new Bank();

        bank.addAccount(savingAccount);
        bank.addAccount(checkingAccount);

        System.out.println("\n----- Thông tin tài khoản ban đầu -----");
        bank.displayAllBalances();

        System.out.println("\n----- Giao dịch tài khoản tiết kiệm -----");
        savingAccount.deposit(1000);
        savingAccount.withdraw(200);
        savingAccount.withdraw(900);
        savingAccount.displayBalance();

        System.out.println("\n----- Giao dịch tài khoản vãng lai -----");
        checkingAccount.deposit(500);
        checkingAccount.withdraw(1000);
        checkingAccount.displayBalance();

        System.out.println("\n----- Số dư tất cả tài khoản sau giao dịch -----");
        bank.displayAllBalances();
    }
}