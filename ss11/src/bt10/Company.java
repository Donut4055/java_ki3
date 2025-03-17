package bt10;

public class Company {
    private Employee[] employees;
    private int count;
    private final int MAX_EMPLOYEES = 100;

    public Company() {
        employees = new Employee[MAX_EMPLOYEES];
        count = 0;
    }

    public void addEmployee(Employee employee) {
        if (count < MAX_EMPLOYEES) {
            employees[count] = employee;
            count++;
            System.out.println(employee.getName() + " đã được thêm vào công ty.");
        } else {
            System.out.println("Công ty đã đạt số lượng nhân viên tối đa.");
        }
    }

    public void allEmployeesWork() {
        System.out.println("\n=== Nhân viên đang làm việc ===");
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i].work());
        }
    }

    public void allEmployeesTakeVacation() {
        System.out.println("\n=== Nhân viên đang nghỉ phép ===");
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i].takeVacation());
        }
    }

    public void organizeMeeting() {
        System.out.println("\n=== Tổ chức cuộc họp ===");
        for (int i = 0; i < count; i++) {
            if (employees[i] instanceof IAttendMeeting) {
                IAttendMeeting attendee = (IAttendMeeting) employees[i];
                System.out.println(attendee.attendMeeting());
            } else {
                System.out.println(employees[i].getName() + " không tham gia cuộc họp.");
            }
        }
    }

    public void displayEmployeeList() {
        System.out.println("\n=== Danh sách nhân viên ===");
        if (count == 0) {
            System.out.println("Công ty chưa có nhân viên.");
            return;
        }

        for (int i = 0; i < count; i++) {
            String employeeType = (employees[i] instanceof Manager) ? "Quản lý" : "Lập trình viên";
            System.out.println((i+1) + ". " + employeeType + ": " + employees[i].getInfo());
        }
    }
}
