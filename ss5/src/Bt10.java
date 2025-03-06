import java.util.Scanner;

public class Bt10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();


        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        int start = 0, end = 0, tempStart = 0;

        for (int i = 0; i < n; i++) {
            currentSum += arr[i];

            if (currentSum > maxSum) {
                maxSum = currentSum;
                start = tempStart;
                end = i;
            }

            if (currentSum < 0) {
                currentSum = 0;
                tempStart = i + 1;
            }
        }

        if (maxSum < 0) {
            maxSum = arr[0];
            start = end = 0;
            for (int i = 1; i < n; i++) {
                if (arr[i] > maxSum) {
                    maxSum = arr[i];
                    start = end = i;
                }
            }
        }

        System.out.println(maxSum);
        System.out.print("day con co tong lon nhat: ");
        for (int i = start; i <= end; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
