
import java.util.ArrayList;

public class Bt6 {
    public static void main(String[] args) {
        ArrayList<Integer> test1 = new ArrayList<>();
        test1.add(5);
        test1.add(12);
        test1.add(8);
        test1.add(5);
        test1.add(12);
        test1.add(7);
        test1.add(8);
        test1.add(12);
        test1.add(5);
        test1.add(10);
        removeDuplicates(test1);
        System.out.println(test1);
    }

    public static void removeDuplicates(ArrayList<Integer> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (list.get(j).equals(list.get(i))) {
                    list.remove(i);
                    break;
                }
            }
        }
    }
}