package business.dao.employee;

import business.config.ConnectionDB;
import business.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static business.config.ConnectionDB.closeConnection;

public class EmployeeDAOImp implements EmployeeDAO {

    private Employee mapRow(ResultSet rs) throws SQLException {
        return new Employee(
                rs.getString("id"),
                rs.getString("name"),
                rs.getString("email"),
                rs.getString("phone"),
                rs.getString("gender"),
                rs.getInt("level"),
                rs.getDouble("salary"),
                rs.getDate("dob").toLocalDate(),
                rs.getString("address"),
                rs.getString("status"),
                rs.getInt("department_id")
        );
    }

    @Override
    public boolean save(Employee emp) {
        String sql = "{CALL sp_add_employee(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";

        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setString(1, emp.getId());
            stmt.setString(2, emp.getName());
            stmt.setString(3, emp.getEmail());
            stmt.setString(4, emp.getPhone());
            stmt.setString(5, emp.getGender());
            stmt.setInt(6, emp.getLevel());
            stmt.setDouble(7, emp.getSalary());
            stmt.setDate(8, Date.valueOf(emp.getDob()));
            stmt.setString(9, emp.getAddress());
            stmt.setString(10, emp.getStatus());
            stmt.setInt(11, emp.getDepartmentId());

            stmt.execute();
            closeConnection(conn);

            return true;

        } catch (SQLException e) {
            System.out.println(" Lỗi save Employee: " + e.getMessage());
        }

        return false;
    }

    @Override
    public boolean update(Employee emp) {
        String sql = "{CALL sp_update_employee(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";

        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setString(1, emp.getId());
            stmt.setString(2, emp.getName());
            stmt.setString(3, emp.getEmail());
            stmt.setString(4, emp.getPhone());
            stmt.setString(5, emp.getGender());
            stmt.setInt(6, emp.getLevel());
            stmt.setDouble(7, emp.getSalary());
            stmt.setDate(8, Date.valueOf(emp.getDob()));
            stmt.setString(9, emp.getAddress());
            stmt.setString(10, emp.getStatus());
            stmt.setInt(11, emp.getDepartmentId());

            stmt.execute();
            closeConnection(conn);

            return true;

        } catch (SQLException e) {
            System.out.println(" Lỗi update Employee: " + e.getMessage());
        }

        return false;
    }

    @Override
    public boolean delete(Employee emp) {
        String sql = "{CALL sp_soft_delete_employee(?)}";

        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setString(1, emp.getId());
            stmt.execute();
            closeConnection(conn);

            return true;

        } catch (SQLException e) {
            System.out.println(" Lỗi soft delete Employee: " + e.getMessage());
        }

        return false;
    }

    @Override
    public List<Employee> findAll() {
        List<Employee> list = new ArrayList<>();
        String sql = "{CALL sp_get_all_employees()}";

        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement stmt = conn.prepareCall(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                list.add(mapRow(rs));
            }
            closeConnection(conn);

        } catch (SQLException e) {
            System.out.println(" Lỗi findAll Employee: " + e.getMessage());
        }

        return list;
    }

    @Override
    public Employee findById(String id) {
        String sql = "{CALL sp_find_employee_by_id(?)}";

        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) return mapRow(rs);
            closeConnection(conn);

        } catch (SQLException e) {
            System.out.println(" Lỗi findById Employee: " + e.getMessage());
        }

        return null;
    }

    @Override
    public List<Employee> findByName(String keyword) {
        List<Employee> list = new ArrayList<>();
        String sql = "{CALL sp_search_employee_by_name(?)}";

        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setString(1, keyword);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                list.add(mapRow(rs));
            }
            closeConnection(conn);

        } catch (SQLException e) {
            System.out.println(" Lỗi findByName Employee: " + e.getMessage());
        }

        return list;
    }

    @Override
    public List<Employee> findByAgeRange(int minAge, int maxAge) {
        List<Employee> list = new ArrayList<>();
        String sql = "{CALL sp_search_employee_by_age_range(?, ?)}";

        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, minAge);
            stmt.setInt(2, maxAge);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                list.add(mapRow(rs));
            }
            closeConnection(conn);

        } catch (SQLException e) {
            System.out.println(" Lỗi findByAgeRange Employee: " + e.getMessage());
        }

        return list;
    }

    @Override
    public List<Employee> sortBySalaryDesc() {
        return executeSimpleListProcedure("{CALL sp_sort_employee_by_salary_desc()}", "sortBySalaryDesc");
    }

    @Override
    public List<Employee> sortByNameAsc() {
        return executeSimpleListProcedure("{CALL sp_sort_employee_by_name_asc()}", "sortByNameAsc");
    }

    private List<Employee> executeSimpleListProcedure(String procedure, String debugName) {
        List<Employee> list = new ArrayList<>();

        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement stmt = conn.prepareCall(procedure);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                list.add(mapRow(rs));
            }

        } catch (SQLException e) {
            System.out.println(" Lỗi " + debugName + ": " + e.getMessage());
        }

        return list;
    }
}
