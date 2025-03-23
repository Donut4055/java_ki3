import java.util.HashSet;
import java.util.TreeSet;

public class Bt5 {
    public static void main(String[] args) {
        HashSet<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);
        set1.add(5);

        HashSet<Integer> set2 = new HashSet<>();
        set2.add(4);
        set2.add(5);
        set2.add(6);
        set2.add(7);
        set2.add(8);

        set1.addAll(set2);

        TreeSet<Integer> sortedSet = new TreeSet<>(set1);

        System.out.println(sortedSet);
    }
}