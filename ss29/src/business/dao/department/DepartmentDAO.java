package business.dao.department;


import business.dao.AppDAO;
import business.model.Department;

import java.util.List;

public interface DepartmentDAO extends AppDAO<Department> {
    Department findById(int id);
    List<Department> findByName(String keyword);
}
