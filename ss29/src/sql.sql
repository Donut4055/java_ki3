
DROP DATABASE IF EXISTS recruitment;
CREATE DATABASE recruitment;
USE recruitment;


CREATE TABLE accounts (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          username VARCHAR(50) NOT NULL UNIQUE,
                          password VARCHAR(255) NOT NULL,
                          status ENUM('ACTIVE', 'INACTIVE') NOT NULL DEFAULT 'ACTIVE',
                          role ENUM('ADMIN', 'HR') NOT NULL
);

CREATE TABLE departments (
                             id INT AUTO_INCREMENT PRIMARY KEY,
                             name VARCHAR(100) NOT NULL UNIQUE,
                             description VARCHAR(255),
                             status ENUM('ACTIVE', 'INACTIVE') NOT NULL
);

CREATE TABLE employees (
                           id CHAR(5) PRIMARY KEY,
                           name VARCHAR(150) NOT NULL,
                           email VARCHAR(100) NOT NULL UNIQUE,
                           phone VARCHAR(15) NOT NULL UNIQUE,
                           gender ENUM('MALE', 'FEMALE', 'OTHER') NOT NULL,
                           level INT NOT NULL CHECK (level > 0),
                           salary DECIMAL(15, 2) NOT NULL CHECK (salary > 0),
                           dob DATE NOT NULL,
                           address VARCHAR(255) NOT NULL,
                           status ENUM('ACTIVE', 'INACTIVE', 'ONLEAVE', 'POLICYLEAVE') NOT NULL,
                           department_id INT NOT NULL,
                           FOREIGN KEY (department_id) REFERENCES departments(id)
);



DELIMITER $$

CREATE PROCEDURE sp_find_account_for_login(
    IN p_username VARCHAR(50),
    IN p_password VARCHAR(255)
)
BEGIN
    SELECT * FROM accounts
    WHERE username = p_username AND password = p_password;
END $$


CREATE PROCEDURE sp_add_department(IN p_name VARCHAR(100), IN p_description VARCHAR(255), IN p_status ENUM('ACTIVE', 'INACTIVE'))
BEGIN
    DECLARE dup INT;
    SELECT COUNT(*) INTO dup FROM departments WHERE name = p_name;
    IF dup > 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Tên phòng ban đã tồn tại.';
    ELSE
        INSERT INTO departments(name, description, status) VALUES(p_name, p_description, p_status);
    END IF;
END $$

CREATE PROCEDURE sp_update_department(IN p_id INT, IN p_name VARCHAR(100), IN p_description VARCHAR(255), IN p_status ENUM('ACTIVE', 'INACTIVE'))
BEGIN
    DECLARE existing INT;
    SELECT COUNT(*) INTO existing FROM departments WHERE id = p_id;
    IF existing = 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Không tìm thấy phòng ban để cập nhật.';
    ELSE
        UPDATE departments SET name = p_name, description = p_description, status = p_status WHERE id = p_id;
    END IF;
END $$

CREATE PROCEDURE sp_delete_department(IN p_id INT)
BEGIN
    DECLARE emp_count INT;
    SELECT COUNT(*) INTO emp_count FROM employees WHERE department_id = p_id;
    IF emp_count > 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Không thể xóa phòng ban đang có nhân viên.';
    ELSE
        DELETE FROM departments WHERE id = p_id;
    END IF;
END $$

CREATE PROCEDURE sp_search_department_by_name(IN p_keyword VARCHAR(100))
BEGIN
    SELECT * FROM departments WHERE name LIKE CONCAT('%', p_keyword, '%');
END $$

CREATE PROCEDURE sp_add_employee(
    IN p_id CHAR(5), IN p_name VARCHAR(150), IN p_email VARCHAR(100), IN p_phone VARCHAR(15),
    IN p_gender ENUM('MALE', 'FEMALE', 'OTHER'), IN p_level INT, IN p_salary DECIMAL(15,2),
    IN p_dob DATE, IN p_address VARCHAR(255), IN p_status ENUM('ACTIVE', 'INACTIVE', 'ONLEAVE', 'POLICYLEAVE'),
    IN p_dept_id INT
)
BEGIN
    DECLARE dept_status ENUM('ACTIVE', 'INACTIVE');
    START TRANSACTION;
    SELECT status INTO dept_status FROM departments WHERE id = p_dept_id;
    IF dept_status <> 'ACTIVE' THEN
        ROLLBACK;
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Không thể thêm nhân viên vào phòng ban không hoạt động.';
    ELSE
        INSERT INTO employees(id, name, email, phone, gender, level, salary, dob, address, status, department_id)
        VALUES(p_id, p_name, p_email, p_phone, p_gender, p_level, p_salary, p_dob, p_address, p_status, p_dept_id);
        COMMIT;
    END IF;
END $$

CREATE PROCEDURE sp_update_employee(
    IN p_id CHAR(5), IN p_name VARCHAR(150), IN p_email VARCHAR(100), IN p_phone VARCHAR(15),
    IN p_gender ENUM('MALE', 'FEMALE', 'OTHER'), IN p_level INT, IN p_salary DECIMAL(15,2),
    IN p_dob DATE, IN p_address VARCHAR(255), IN p_status ENUM('ACTIVE', 'INACTIVE', 'ONLEAVE', 'POLICYLEAVE'),
    IN p_dept_id INT
)
BEGIN
    DECLARE emp_exist INT;
    SELECT COUNT(*) INTO emp_exist FROM employees WHERE id = p_id;
    IF emp_exist = 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Không tìm thấy nhân viên để cập nhật.';
    ELSE
        UPDATE employees
        SET name = p_name, email = p_email, phone = p_phone, gender = p_gender, level = p_level,
            salary = p_salary, dob = p_dob, address = p_address, status = p_status, department_id = p_dept_id
        WHERE id = p_id;
    END IF;
END $$

CREATE PROCEDURE sp_soft_delete_employee(IN p_id CHAR(5))
BEGIN
    UPDATE employees SET status = 'INACTIVE' WHERE id = p_id;
END $$

CREATE PROCEDURE sp_search_employee_by_name(IN p_keyword VARCHAR(150))
BEGIN
    SELECT * FROM employees WHERE name LIKE CONCAT('%', p_keyword, '%');
END $$

CREATE PROCEDURE sp_search_employee_by_age_range(IN p_min_age INT, IN p_max_age INT)
BEGIN
    SELECT *, TIMESTAMPDIFF(YEAR, dob, CURDATE()) AS age
    FROM employees
    WHERE TIMESTAMPDIFF(YEAR, dob, CURDATE()) BETWEEN p_min_age AND p_max_age;
END $$

CREATE PROCEDURE sp_sort_employee_by_salary_desc()
BEGIN
    SELECT * FROM employees ORDER BY salary DESC;
END $$

CREATE PROCEDURE sp_sort_employee_by_name_asc()
BEGIN
    SELECT * FROM employees ORDER BY name ASC;
END $$


CREATE PROCEDURE sp_find_department_by_id(IN p_id INT)
BEGIN
    SELECT * FROM departments WHERE id = p_id;
END $$

CREATE PROCEDURE sp_find_employee_by_id(IN p_id CHAR(5))
BEGIN
    SELECT * FROM employees WHERE id = p_id;
END $$

CREATE PROCEDURE sp_get_all_employees()
BEGIN
    SELECT * FROM employees;
END $$

CREATE PROCEDURE sp_count_employees_per_department()
BEGIN
    SELECT d.name AS department_name, COUNT(e.id) AS employee_count
    FROM departments d
             LEFT JOIN employees e ON d.id = e.department_id
    GROUP BY d.id;
END $$

CREATE PROCEDURE sp_most_employees_department()
BEGIN
    SELECT d.name, COUNT(e.id) AS total_employees
    FROM departments d
             LEFT JOIN employees e ON d.id = e.department_id
    GROUP BY d.id
    ORDER BY total_employees DESC
    LIMIT 1;
END $$

CREATE PROCEDURE sp_highest_avg_salary_department()
BEGIN
    SELECT d.name, AVG(e.salary) AS avg_salary
    FROM departments d
             JOIN employees e ON d.id = e.department_id
    GROUP BY d.id
    ORDER BY avg_salary DESC
    LIMIT 1;
END $$

DELIMITER ;
