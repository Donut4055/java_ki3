package validate;

import entity.Employee;

public final class inputValidate {
    public static boolean checkID(String id) {
        return id.matches("NV[0-9]{4}");
    }

    public static boolean checkName(String name) {
        return name.matches("[a-zA-Z ]+")  && !name.isEmpty();
    }

    public static boolean checkBirthday(String birthday) {
        return birthday.matches("([0-2][0-9]|3[0-1])/(0[0-9]|1[0-2])/[0-9]{4}") && !birthday.isEmpty();
    }

    public static boolean checkPhoneNumber(String phoneNumber) {
        return phoneNumber.matches("0[0-9]{9}");
    }

    public static boolean checkSex(Boolean sex) {
        return true;
    }

    public static boolean checkEmail(String email) {
        return email.matches("^[a-zA-Z0-9]+@[a-zA-Z0-9]+(\\.[a-zA-Z0-9]+)");
    }

    public static boolean checkCoefficient(float coefficient) {
        return coefficient > 0;
    }

    public static boolean checkAllowanceSalary (int allowanceSalary) {
        return allowanceSalary >= 0;
    }

    public static boolean checkDepartment(String department) {
        return !department.isEmpty();
    }
}
