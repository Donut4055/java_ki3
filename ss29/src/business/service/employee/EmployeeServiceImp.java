package business.service.employee;

import business.dao.employee.EmployeeDAO;
import business.dao.employee.EmployeeDAOImp;
import business.model.Employee;

import java.util.List;

public class EmployeeServiceImp implements EmployeeService {

    private final EmployeeDAO dao = new EmployeeDAOImp();

    @Override
    public boolean save(Employee emp) {
        return dao.save(emp);
    }

    @Override
    public boolean update(Employee emp) {
        return dao.update(emp);
    }

    @Override
    public boolean delete(Employee emp) {
        return dao.delete(emp);
    }

    @Override
    public List<Employee> findAll() {
        return dao.findAll();
    }

    @Override
    public Employee findById(String id) {
        return dao.findById(id);
    }

    @Override
    public List<Employee> findByName(String keyword) {
        return dao.findByName(keyword);
    }

    @Override
    public List<Employee> findByAgeRange(int min, int max) {
        return dao.findByAgeRange(min, max);
    }

    @Override
    public List<Employee> sortBySalaryDesc() {
        return dao.sortBySalaryDesc();
    }

    @Override
    public List<Employee> sortByNameAsc() {
        return dao.sortByNameAsc();
    }
}
