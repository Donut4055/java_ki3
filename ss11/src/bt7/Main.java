package bt7;

public class Main {
    public static void main(String[] args) {
        PartTimeEmployee partTimeEmployee = new PartTimeEmployee("Alice", 50, 4);
        FullTimeEmployee fullTimeEmployee = new FullTimeEmployee("Bob", 100);

        System.out.println("Part-time Employee: " + partTimeEmployee.getName());
        System.out.println("Salary: " + partTimeEmployee.calculateSalary());

        System.out.println("\nFull-time Employee: " + fullTimeEmployee.getName());
        System.out.println("Salary: " + fullTimeEmployee.calculateSalary());
    }
}
