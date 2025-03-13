package bt7;

public class Main {
    public static void main(String[] args) {
        Student[] students = new Student[5];

            students[0] = new Student("aaa", "a1", 3.5);
            students[1] = new GraduateStudent("bbbbb", "a2", 3.8, "abcd", "TS. ảar");
            students[2] = new Student("cccc", "a3", 2.9);
            students[3] = new GraduateStudent("dddd", "a4", 3.2, "dcba", "ThS. fasf");
            students[4] = new Student("eeee", "a5", 3.0);

        System.out.println("===== DANH SÁCH SINH VIÊN =====");
        for (Student s : students) {
            if (s != null) {
                System.out.println(s.getDetails());
            }
        }
    }
}

