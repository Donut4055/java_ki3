package bt7;

public class Student {
    private String name;
    private String id;
    private double gpa;

    public Student(String name, String id, double gpa) {
        this.name = name;
        this.id = id;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public double getGpa() {
        return gpa;
    }

    public void setName(String name) {
        if (name == null) {
            System.out.println("Tên không hợp lệ.");
            return;
        }
        this.name = name;
    }

    public void setId(String id) {
        if (id == null) {
            System.out.println("Mã sinh viên không hợp lệ.");
            return;
        }
        this.id = id;
    }

    public void setGpa(double gpa) {
        if (gpa < 0 || gpa > 4.0) {
            System.out.println("GPA không hợp lệ.");
            return;
        }
        this.gpa = gpa;
    }

    public String getDetails() {
        return "Tên: " + name + ", Mã SV: " + id + ", GPA: " + gpa;
    }
}

