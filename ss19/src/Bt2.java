import java.util.function.Function;

public class Bt2 {
    public static void main(String[] args) {
        Function<Integer, Integer> quadraticFunction = x -> x * x + 3 * x + 2;

        System.out.println("f(1) = " + quadraticFunction.apply(1));
        System.out.println("f(2) = " + quadraticFunction.apply(2));
        System.out.println("f(3) = " + quadraticFunction.apply(3));
    }
}