import java.awt.datatransfer.Transferable;
import java.util.TreeMap;

public class Bt4 {
    public static void main(String[] args) {
        TreeMap<String,Integer> map = new TreeMap<>();
        map.put("001",1000);
        map.put("002",1000);
        map.put("004",1000);
        map.put("003",1000);
        System.out.println(map);
        map.replace("003",3000);

        System.out.println(map);

        map.remove("002");
        System.out.println(map);
    }
}
