package bt9;

public class Bank {
    private BankAccount[] accounts;
    private final int MAX_ACCOUNTS = 10;
    private int accountCount;

    public Bank() {
        this.accounts = new BankAccount[MAX_ACCOUNTS];
        this.accountCount = 0;
    }

    public void addAccount(BankAccount account) {
        if (accountCount < MAX_ACCOUNTS) {
            accounts[accountCount] = account;
            accountCount++;
            System.out.println("Tài khoản " + account.getAccountNumber() + " đã được thêm vào ngân hàng.");
        } else {
            System.out.println("Ngân hàng đã đạt tối đa số lượng tài khoản (" + MAX_ACCOUNTS + "). Không thể thêm tài khoản mới.");
        }
    }

    public void displayAllBalances() {
        System.out.println("----- Số dư tất cả tài khoản trong ngân hàng -----");
        if (accountCount == 0) {
            System.out.println("Ngân hàng hiện chưa có tài khoản nào.");
        } else {
            for (int i = 0; i < accountCount; i++) {
                accounts[i].displayBalance();
                System.out.println("--------------------");
            }
        }
    }
}
