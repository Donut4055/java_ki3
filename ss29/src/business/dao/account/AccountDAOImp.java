package business.dao.account;

import business.config.ConnectionDB;
import business.model.Account;

import java.sql.*;

import static business.config.ConnectionDB.closeConnection;

public class AccountDAOImp implements AccountDAO {

    @Override
    public Account findLoginAccount(String username, String password) {
        String sql = "{CALL sp_find_account_for_login(?, ?)}";

        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Account(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("status")
                );
            }
            closeConnection(conn);

        } catch (SQLException e) {
            System.out.println("Lỗi khi kiểm tra đăng nhập: " + e.getMessage());
        }

        return null;
    }
}
