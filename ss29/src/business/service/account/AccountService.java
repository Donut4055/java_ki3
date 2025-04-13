package business.service.account;

import business.model.Account;

public interface AccountService {
    boolean login(String username, String password);
    void logout();
}
