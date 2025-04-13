package business.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static final String URL = "jdbc:mysql://localhost:3306/recruitment";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "donut_12321";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Kết nối database thành công.");
        } catch (SQLException e) {
            System.out.println("Kết nối database thất bại: " + e.getMessage());
        }
        return conn;
    }

    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Đã đóng kết nối .");
            } catch (SQLException e) {
                System.out.println("Lỗi khi đóng kết nối: " + e.getMessage());
            }
        }
    }
    public static void main(String[] args) {
        Connection conn = getConnection();
        closeConnection(conn);
    }
}
