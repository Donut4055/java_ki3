package business.dao.employee;

import business.dao.AppDAO;
import business.model.Employee;

import java.util.List;

public interface EmployeeDAO extends AppDAO<Employee> {
    Employee findById(String id);
    List<Employee> findByName(String keyword);
    List<Employee> findByAgeRange(int min, int max);
    List<Employee> sortBySalaryDesc();
    List<Employee> sortByNameAsc();
}
