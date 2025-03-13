package bt9;

public class Main {
    public static void main(String[] args) {
        Employee emp = new Employee("aaaa", "a1", 1000);
        Manager mgr = new Manager("bbbb", "a2", 2000, 2000);
        Developer dev = new Developer("cccc", "a3", 5678, "ccc");

        System.out.println(emp.toString());
        System.out.println("Lương thực tế: " + emp.getSalary());
        System.out.println("---------------------------");

        System.out.println(mgr.toString());
        System.out.println("Lương thực tế: " + mgr.getSalary());
        System.out.println("---------------------------");

        System.out.println(dev.toString());
        System.out.println("Lương thực tế: " + dev.getSalary());
        System.out.println("---------------------------");

        System.out.println("Tăng lương cho nhân viên " + emp.name + " thêm 1500...");
        emp.increaseSalary(1500);
        System.out.println(emp.toString());
        System.out.println("Lương sau tăng: " + emp.getSalary());
    }
}
