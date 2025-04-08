package redo.bussiness.dao.student;

import redo.bussiness.dao.AppDAO;
import redo.bussiness.model.Student;

public interface StudentDAO extends AppDAO<Student>{
    int getCountStudentByStatus(boolean status);

    Student findById(int id);
}
