package entity;

import validate.inputValidate;

import java.util.Scanner;

public class Employee implements IApp {

    private String employeeID;
    private String employeeName;
    private String birthday;
    private String phoneNumber;
    private Boolean sex;
    private Float coefficient;
    private int allowanceSalary = 0;
    private String department;
    byte status = 1;

    public Employee() {
    }

    public Employee(String employeeID, String employeeName, String birthday, String phoneNumber, Boolean sex, Float coefficient, int allowanceSalary, String department, byte status) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.sex = sex;
        this.coefficient = coefficient;
        this.allowanceSalary = allowanceSalary;
        this.department = department;
        this.status = status;
    }
    public String getEmployeeID() {
        return employeeID;
    }

    public String setEmployeeID(String employeeID) {
        return this.employeeID = employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String setEmployeeName(String employeeName) {
        return this.employeeName = employeeName;
    }

    public String getBirthday() {
        return birthday;
    }

    public String setBirthday(String birthday) {
        return this.birthday = birthday;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String setPhoneNumber(String phoneNumber) {
        return this.phoneNumber = phoneNumber;
    }

    public Boolean getSex() {
        return sex;
    }

    ;

    public Boolean setSex(Boolean sex) {
        return sex;
    }

    public Float getCoefficient() {
        return coefficient;
    }

    public Float setCoefficient(Float coefficient) {
        return this.coefficient = coefficient;
    }

    public int getAllowanceSalary() {
        return allowanceSalary;
    }

    public int setAllowanceSalary(int allowanceSalary) {
        return this.allowanceSalary = allowanceSalary;
    }

    public String getDepartment() {
        return department;
    }

    public String setDepartment(String department) {
        return this.department = department;
    }

    @Override
    public void inputData(Scanner scanner) {
        System.out.println("Nhập mã nhân viên: ");
        employeeID = scanner.nextLine();
        while (!inputValidate.checkID(employeeID)) {
            System.out.println("Id không hợp lệ, vui lòng nhập lại: ");
            employeeID = scanner.nextLine();
        }

        System.out.println("nhập tên nhân viên: ");
        employeeName = scanner.nextLine();
        while (!inputValidate.checkName(employeeName)) {
            System.out.println("tên không hợp lệ, vui lòng nhập lại: ");
            employeeName = scanner.nextLine();
        }

        System.out.println("nhập ngày sinh: ");
        birthday = scanner.nextLine();
        while (!inputValidate.checkBirthday(birthday)) {
            System.out.println("ngày sinh không hợp lệ, vui lòng nhập lại: ");
            birthday = scanner.nextLine();
        }

        System.out.println("nhập số điện thoại: ");
        phoneNumber = scanner.nextLine();
        while (!inputValidate.checkPhoneNumber(phoneNumber)) {
            System.out.println("số điện thoại không hợp lệ, vui lòng nhập lại: ");
            phoneNumber = scanner.nextLine();
        }

        System.out.println("nhập giới tính(true là nam, false là nữ): ");
        sex = scanner.nextBoolean();
        while (!inputValidate.checkSex(sex)) {
            System.out.println("giới tính không hợp lệ, vui lòng nhập lại: ");
            sex = scanner.nextBoolean();
        }

        System.out.println("nhập hệ số lương: ");
        coefficient = scanner.nextFloat();
        while (!inputValidate.checkCoefficient(coefficient)) {
            System.out.println("hệ số lương không hợp lệ, vui lòng nhập lại: ");
            coefficient = scanner.nextFloat();
        }

        System.out.println("nhập phụ cấp: ");
        allowanceSalary = scanner.nextInt();
        while (!inputValidate.checkAllowanceSalary(allowanceSalary)) {
            System.out.println("phụ cấp không hợp lệ, vui lòng nhập lại: ");
            allowanceSalary = scanner.nextInt();
        }

        System.out.println("nhập tên phòng ban: ");
        department = scanner.nextLine();
        while (!inputValidate.checkDepartment(department)) {
            System.out.println("tên phòng ban không hợp lệ, vui lòng nhập lại: ");
            department = scanner.nextLine();
        }
    }
    @Override
    public void displayData()  {
        System.out.println("Mã nhân viên: " + employeeID);
        System.out.println("Tên nhân viên: " + employeeName);
        System.out.println("Ngày sinh: " + birthday);
        System.out.println("Số điện thoại: " + phoneNumber);
        //true thì in nam false thì in nữ
        System.out.print("Giới tính: ");
        if (sex) {
            System.out.println("Nam");
        } else {
            System.out.println("Nữ");
        }
        float totalSalary = BASE_SALARY*coefficient + allowanceSalary;
        System.out.println("tổng lương: " + totalSalary);
        System.out.println("tên phòng ban: " + department);
    }
}
