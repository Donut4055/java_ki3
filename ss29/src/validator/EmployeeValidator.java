package validator;
import business.model.Employee;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public class EmployeeValidator {

    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$"
    );

    private static final Pattern PHONE_PATTERN = Pattern.compile(
            "^(03|05|07|08|09)\\d{8}$"
    );

    public static boolean isValid(Employee emp) {
        return isIdValid(emp.getId())
                && isNameValid(emp.getName())
                && isEmailValid(emp.getEmail())
                && isPhoneValid(emp.getPhone())
                && isGenderValid(emp.getGender())
                && isLevelValid(emp.getLevel())
                && isSalaryValid(emp.getSalary())
                && isDobValid(emp.getDob())
                && isAddressValid(emp.getAddress())
                && isStatusValid(emp.getStatus())
                && isDepartmentIdValid(emp.getDepartmentId());
    }

    public static boolean isIdValid(String id) {
        return id != null && id.matches("^E\\w{4}$");
    }

    public static boolean isNameValid(String name) {
        return name != null && name.length() >= 15 && name.length() <= 150;
    }

    public static boolean isEmailValid(String email) {
        return email != null && EMAIL_PATTERN.matcher(email).matches();
    }

    public static boolean isPhoneValid(String phone) {
        return phone != null && PHONE_PATTERN.matcher(phone).matches();
    }

    public static boolean isGenderValid(String gender) {
        return "MALE".equalsIgnoreCase(gender)
                || "FEMALE".equalsIgnoreCase(gender)
                || "OTHER".equalsIgnoreCase(gender);
    }

    public static boolean isLevelValid(int level) {
        return level > 0;
    }

    public static boolean isSalaryValid(double salary) {
        return salary > 0;
    }

    public static boolean isDobValid(LocalDate dob) {
        return dob != null && dob.isBefore(LocalDate.now());
    }

    public static boolean isAddressValid(String addr) {
        return addr != null && !addr.isBlank();
    }

    public static boolean isStatusValid(String status) {
        return "ACTIVE".equalsIgnoreCase(status)
                || "INACTIVE".equalsIgnoreCase(status)
                || "ONLEAVE".equalsIgnoreCase(status)
                || "POLICYLEAVE".equalsIgnoreCase(status);
    }

    public static boolean isDepartmentIdValid(int deptId) {
        return deptId > 0;
    }
}
