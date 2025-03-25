import java.util.HashMap;
public class Bt5 {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("abcd",1000);
        map.put("efgh",200);
        map.put("ijkl",300);
        map.put("mnop",700);
        map.put("qrst",800);
        map.forEach((key, value) -> {
            if ((value >= 500) && (value <= 1500)) {
                System.out.println(key + " " + value);
            }
        });
    }
}
