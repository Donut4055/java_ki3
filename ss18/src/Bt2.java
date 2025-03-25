import java.util.HashMap;

public class Bt2 {
    public static void main(String[] args) {
        HashMap<String,Integer> map = new HashMap<>();
        map.put("Laptop",1);
        map.put("Mouse",2);
        map.put("Keyboard",3);
        map.put("Monitor",4);

        if (map.containsKey("Laptop")) {
            System.out.println("Co laptop");
        } else {
            System.out.println("Khong co laptop");
        }

        if (map.containsValue(1000)) {
            System.out.println("Co 1000");
        } else {
            System.out.println("Khong co 1000");
        }
    }
}
