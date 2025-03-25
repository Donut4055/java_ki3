import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Bt6 {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("Nguyen Van A",6);
        map.put("Nguyen Van B",7);
        map.put("Nguyen Van C",8);
        map.put("Nguyen Van D",4);
        map.put("Nguyen Van E",5);
        map.put("Nguyen Van F",3);
        map.put("Nguyen Van G",2);
        map.put("Nguyen Van H",1);
        map.put("Nguyen Van I",0);
        map.put("Nguyen Van K",9);
        System.out.println(map);
        AtomicInteger sum = new AtomicInteger();
        map.forEach((key, value) -> {
            sum.addAndGet(value);
        });
        System.out.println("diem trung binh: " + sum.doubleValue() / map.size());

        map.entrySet().removeIf(entry -> entry.getValue() < 5);
        System.out.println(map);
    }
}
