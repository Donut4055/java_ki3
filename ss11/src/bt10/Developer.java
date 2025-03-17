package bt10;

public class Developer extends Employee {
    private String programmingLanguage;

    public Developer(String name, double salary) {
        super(name, salary);
        this.programmingLanguage = "Java";
    }

    public Developer(String name, double salary, String programmingLanguage) {
        super(name, salary);
        this.programmingLanguage = programmingLanguage;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    @Override
    public String work() {
        return "Lập trình viên " + getInfo() + " đang viết code cho hệ thống mới";
    }

    @Override
    public String takeVacation() {
        return "Lập trình viên " + getInfo() + " đang đi nghỉ phép ở Bali.";
    }
}