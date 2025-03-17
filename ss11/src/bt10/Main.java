package bt10;

public class Main {
    public static void main(String[] args) {
        Company company = new Company();

        Manager manager1 = new Manager("Alice", 8000);
        Manager manager2 = new Manager("David", 9000, 10);
        Developer developer1 = new Developer("Bob", 5000);
        Developer developer2 = new Developer("Emma", 5500, "Python");

        company.addEmployee(manager1);
        company.addEmployee(manager2);
        company.addEmployee(developer1);
        company.addEmployee(developer2);

        company.displayEmployeeList();

        company.allEmployeesWork();

        company.allEmployeesTakeVacation();

        company.organizeMeeting();
    }
}
