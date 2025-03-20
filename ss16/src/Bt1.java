import java.util.ArrayList;
import java.util.Iterator;

public class Bt1 {
    public static void main(String[] args) {
        ArrayList<String> students = new ArrayList<>();

        students.add("sv1");
        students.add("sv2");
        students.add("sv3");
        students.add("sv4");
        students.add("sv5");

        System.out.println("Danh sách sinh viên (vòng lặp for):");
        for (int i = 0; i < students.size(); i++) {
            System.out.println((i + 1) + ". " + students.get(i));
        }

        System.out.println("Danh sách sinh viên (vòng lặp foreach):");
        int index = 1;
        for (String student : students) {
            System.out.println(index + ". " + student);
            index++;
        }

        System.out.println("Danh sách sinh viên (Iterator):");
        Iterator<String> iterator = students.iterator();
        index = 1;
        while (iterator.hasNext()) {
            System.out.println(index + ". " + iterator.next());
            index++;
        }
    }
}
