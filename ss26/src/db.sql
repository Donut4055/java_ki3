create database StudentManagement;
use StudentManagement;
create table Student
(
    student_id     int primary key auto_increment,
    student_name   varchar(200) not null,
    student_age    int,
    student_status bit
);
DELIMITER //
create procedure get_all_student()
begin
    select * from Student;
end;
create procedure create_student(
    name_in varchar(200),
    age_in int,
    status_in bit
)
begin
    insert into Student(student_name, student_age, student_status)
    values (name_in, age_in, status_in);
end;
create procedure update_student(
    id_in int,
    name_in varchar(200),
    age_in int,
    status_in bit
)
begin
    update Student
    set student_name   = name_in,
        student_age    = age_in,
        student_status = status_in
    where student_id = id_in;
end;
create procedure delete_student(
    id_in int
)
begin
    delete from Student where student_id = id_in;
end;
create procedure get_count_student_by_status(
    status_in bit,
    OUT cnt_student int
)
begin
    select count(student_id) into cnt_student from Student where student_status = status_in;
end;
create procedure get_student_by_id(id_in int)
begin
    select * from student where student_id = id_in;
end;
DELIMITER //