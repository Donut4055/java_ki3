import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Math.sqrt;

public class Bt9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        ArrayList<Integer> Even = new ArrayList<Integer>();
        ArrayList<Integer> Odd = new ArrayList<Integer>();
        ArrayList<Integer> Prime = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            int value = arr[i];
            if (Prime.contains(value) || Even.contains(value) || Odd.contains(value)) {
                continue;
            }
            if (isPrime(value)) {

                    Prime.add(value);

            } else if (isEven(value)) {
                    Even.add(value);
            } else {
                    Odd.add(value);
            }
        }
        System.out.println("Even: " + Even);
        System.out.println("Odd: " + Odd);
        System.out.println("Prime: " + Prime);
    }

    public static boolean isPrime(int n)  {
        if (n < 2) {
            return false;
        } else if (n == 2 || n == 3 || n == 5 || n == 7) {
            return true;
        } else if (n % 2 == 0 || n % 3 == 0) {
            return false;
        } else {
            int i = -1;
            while (i < sqrt(n)) {
                i += 6;
                if (n % i == 0 || n % (i + 2) == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isEven(int n) {
        return n % 2 == 0;
    }

    public static boolean isOdd(int n) {
        return n % 2 != 0;
    }
}
