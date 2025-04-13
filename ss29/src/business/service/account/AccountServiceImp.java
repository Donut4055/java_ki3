package business.service.account;

import business.dao.account.AccountDAO;
import business.dao.account.AccountDAOImp;
import business.model.Account;

public class AccountServiceImp implements AccountService {

    private final AccountDAO dao = new AccountDAOImp();

    @Override
    public boolean login(String username, String password) {
        Account acc = dao.findLoginAccount(username, password);

        if (acc == null) {
            System.out.println("Sai tên đăng nhập hoặc mật khẩu.");
            return false;
        }

        if (!"ACTIVE".equalsIgnoreCase(acc.getStatus())) {
            System.out.println("Tài khoản chưa được kích hoạt hoặc đã bị vô hiệu hóa.");
            return false;
        }

        Account.currentUser = acc;
        System.out.println("Đăng nhập thành công. Xin chào, " + acc.getUsername());
        return true;
    }

    @Override
    public void logout() {
        if (Account.currentUser != null) {
            System.out.println("Đăng xuất thành công: " + Account.currentUser.getUsername());
        }
        Account.currentUser = null;
    }
}
