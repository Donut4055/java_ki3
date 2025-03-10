import java.sql.SQLOutput;

public class Bt2 {
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder("Hello, Java World!");
        System.out.println(str);
        str.delete(5, 9);
        System.out.println(str);
        int start = str.indexOf("World");
        int end = start + "World".length();
        str.replace(start, end, "universal");
        System.out.println(str);
    }
}
