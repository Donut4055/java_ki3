package business.service.department;

import business.model.Department;
import business.service.AppService;

import java.util.List;

public interface DepartmentService extends AppService<Department> {
    Department findById(int id);
    List<Department> findByName(String keyword);
}
