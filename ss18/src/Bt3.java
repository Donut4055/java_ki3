import java.util.LinkedHashMap;

public class Bt3 {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("Laptop",1);
        map.put("Mouse",2);
        map.put("Keyboard",3);
        map.put("Monitor",4);
        System.out.println(map);

        map.replace("Laptop",5);
        map.remove("Keyboard");
        System.out.println(map);
    }
}
