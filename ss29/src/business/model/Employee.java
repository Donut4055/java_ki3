package business.model;

import java.time.LocalDate;

public class Employee {
    private String id;
    private String name;
    private String email;
    private String phone;
    private String gender;
    private int level;
    private double salary;
    private LocalDate dob;
    private String address;
    private String status;
    private int departmentId;

    public Employee() {}

    public Employee(String id, String name, String email, String phone, String gender,
                    int level, double salary, LocalDate dob, String address,
                    String status, int departmentId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.level = level;
        this.salary = salary;
        this.dob = dob;
        this.address = address;
        this.status = status;
        this.departmentId = departmentId;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public int getLevel() { return level; }
    public void setLevel(int level) { this.level = level; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public LocalDate getDob() { return dob; }
    public void setDob(LocalDate dob) { this.dob = dob; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public int getDepartmentId() { return departmentId; }
    public void setDepartmentId(int departmentId) { this.departmentId = departmentId; }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", level=" + level +
                ", salary=" + salary +
                ", dob=" + dob +
                ", status='" + status + '\'' +
                ", departmentId=" + departmentId +
                '}';
    }
}
