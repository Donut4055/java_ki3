package redo.bussiness.service.student;

import redo.bussiness.model.Student;
import redo.bussiness.service.AppService;

public interface StudentService extends AppService<Student>{
    Student findById(int id);

    int getCountStudentByStatus(boolean status);
}
