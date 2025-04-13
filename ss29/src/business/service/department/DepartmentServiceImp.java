package business.service.department;

import business.dao.department.DepartmentDAO;
import business.dao.department.DepartmentDAOImp;
import business.model.Department;

import java.util.List;

public class DepartmentServiceImp implements DepartmentService {

    private final DepartmentDAO dao = new DepartmentDAOImp();

    @Override
    public boolean save(Department department) {
        return dao.save(department);
    }

    @Override
    public boolean update(Department department) {
        return dao.update(department);
    }

    @Override
    public boolean delete(Department department) {
        return dao.delete(department);
    }

    @Override
    public List<Department> findAll() {
        return dao.findAll();
    }

    @Override
    public Department findById(int id) {
        return dao.findById(id);
    }

    @Override
    public List<Department> findByName(String keyword) {
        return dao.findByName(keyword);
    }
}
