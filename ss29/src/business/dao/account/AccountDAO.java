package business.dao.account;

import business.model.Account;

public interface AccountDAO {
    Account findLoginAccount(String username, String password);
}
