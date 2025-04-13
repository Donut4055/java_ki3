package validator;


import business.model.Department;

public class DepartmentValidator {

    public static boolean isValid(Department dept) {
        return isNameValid(dept.getName())
                && isDescriptionValid(dept.getDescription())
                && isStatusValid(dept.getStatus());
    }

    public static boolean isNameValid(String name) {
        return name != null && name.length() >= 10 && name.length() <= 100;
    }

    public static boolean isDescriptionValid(String desc) {
        return desc == null || desc.length() <= 255;
    }

    public static boolean isStatusValid(String status) {
        return "ACTIVE".equalsIgnoreCase(status) || "INACTIVE".equalsIgnoreCase(status);
    }
}
