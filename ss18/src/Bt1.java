import java.util.HashMap;

public class Bt1 {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("abcd",1);
        map.put("efgh",2);
        map.put("ijkl",3);
        map.put("mnop",4);
        map.put("qrst",5);

        System.out.println(map.get("abcd"));
    }
}
