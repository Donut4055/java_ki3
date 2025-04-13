package business.service.employee;

import business.model.Employee;
import business.service.AppService;

import java.util.List;

public interface EmployeeService extends AppService<Employee> {
    Employee findById(String id);
    List<Employee> findByName(String keyword);
    List<Employee> findByAgeRange(int min, int max);
    List<Employee> sortBySalaryDesc();
    List<Employee> sortByNameAsc();
}

