package business.dao.department;

import business.config.ConnectionDB;
import business.model.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static business.config.ConnectionDB.closeConnection;

public class DepartmentDAOImp implements DepartmentDAO {

    private Department mapRow(ResultSet rs) throws SQLException {
        return new Department(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("description"),
                rs.getString("status")
        );
    }

    @Override
    public boolean save(Department d) {
        String sql = "{CALL sp_add_department(?, ?, ?)}";

        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setString(1, d.getName());
            stmt.setString(2, d.getDescription());
            stmt.setString(3, d.getStatus());

            stmt.execute();
            closeConnection(conn);
            return true;

        } catch (SQLException e) {
            System.out.println(" Lỗi save Department: " + e.getMessage());
        }

        return false;
    }

    @Override
    public boolean update(Department d) {
        String sql = "{CALL sp_update_department(?, ?, ?, ?)}";

        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, d.getId());
            stmt.setString(2, d.getName());
            stmt.setString(3, d.getDescription());
            stmt.setString(4, d.getStatus());

            stmt.execute();
            closeConnection(conn);
            return true;

        } catch (SQLException e) {
            System.out.println(" Lỗi update Department: " + e.getMessage());
        }

        return false;
    }

    @Override
    public boolean delete(Department d) {
        String sql = "{CALL sp_delete_department(?)}";

        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, d.getId());
            stmt.execute();
            closeConnection(conn);
            return true;

        } catch (SQLException e) {
            System.out.println(" Lỗi delete Department: " + e.getMessage());
        }

        return false;
    }

    @Override
    public List<Department> findAll() {
        List<Department> list = new ArrayList<>();
        String sql = "{CALL sp_search_department_by_name('')}";

        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement stmt = conn.prepareCall(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                list.add(mapRow(rs));
            }
            closeConnection(conn);

        } catch (SQLException e) {
            System.out.println(" Lỗi findAll Department: " + e.getMessage());
        }

        return list;
    }

    @Override
    public Department findById(int id) {
        String sql = "{CALL sp_find_department_by_id(?)}";

        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) return mapRow(rs);
            closeConnection(conn);

        } catch (SQLException e) {
            System.out.println(" Lỗi findById Department: " + e.getMessage());
        }

        return null;
    }

    @Override
    public List<Department> findByName(String keyword) {
        List<Department> list = new ArrayList<>();
        String sql = "{CALL sp_search_department_by_name(?)}";

        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setString(1, keyword);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                list.add(mapRow(rs));
            }
            closeConnection(conn);

        } catch (SQLException e) {
            System.out.println(" Lỗi findByName Department: " + e.getMessage());
        }

        return list;
    }
}
