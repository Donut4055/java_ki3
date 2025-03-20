
import java.util.ArrayList;

public class Bt8 {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();

        strings.add("apple");
        strings.add("zoo");
        strings.add("banana");
        strings.add("cat");
        strings.add("dog");
        strings.add("elephant");
        strings.add("bat");
        strings.add("fox");
        strings.add("ant");


        for (int i = 0; i < strings.size() - 1; i++) {
            for (int j = 0; j < strings.size() - 1 - i; j++) {
                String s1 = strings.get(j);
                String s2 = strings.get(j + 1);

                if (s1.length() > s2.length()) {
                    strings.set(j, s2);
                    strings.set(j + 1, s1);
                } else if (s1.length() == s2.length()) {
                    if (s1.compareTo(s2) > 0) {
                        strings.set(j, s2);
                        strings.set(j + 1, s1);
                    }
                }
            }
        }

        System.out.println("Danh sách sau khi sắp xếp:");
        System.out.println(strings);
    }
}