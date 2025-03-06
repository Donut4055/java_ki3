import java.util.Scanner;

import static java.lang.Math.sqrt;

public class est {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 != 0) {
                System.out.print(arr[i] + " ");
                sum1 += arr[i];
            }
        }
        System.out.println();
        System.out.println("tong cac so le trong mang "+sum1);



        boolean isPrime = true;
        for (int i = 0; i < n; i++) {
            if (arr[i] < 2) {
                isPrime = false;
            } else if (arr[i] == 2 || arr[i] == 3 || arr[i] == 5 || arr[i] == 7) {
                isPrime = true;
            } else if (arr[i] % 2 == 0 || arr[i] % 3 == 0) {
                isPrime = false;
            } else {
                int j = -1;
                while (j < sqrt(arr[i])) {
                    j += 6;
                    if (arr[i] % j == 0 || arr[i] % (j + 2) == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }
            if (isPrime) {
                System.out.print(arr[i] + " ");
                sum2 += arr[i];
            }
        }
        System.out.println();
        System.out.println("tong cac so nguyen to trong mang "+sum2);
    }
}
