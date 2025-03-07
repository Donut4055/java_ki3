import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.sqrt;

public class Practice01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        int[] arr = new int[1000];
        int choice;

        do {
            System.out.println("***********************MENU**************************");
            System.out.println("1. Nhập giá trị n phần tử của mảng");
            System.out.println("2. In giá trị các phần tử trong mảng");
            System.out.println("3. Tính trung bình các phần tử dương (>0) trong mảng");
            System.out.println("4. In ra vị trí các phần tử có giá trị bằng k");
            System.out.println("5. Sắp xếp mảng giảm dần (Bubble Sort)");
            System.out.println("6. Đếm số lượng phần tử là số nguyên tố trong mảng");
            System.out.println("7. Sắp xếp theo yêu cầu đặc biệt");
            System.out.println("8. Chèn giá trị m vào mảng (đã sắp xếp giảm dần)");
            System.out.println("9. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    n = sc.nextInt();
                    for (int i = 0; i < n; i++) {
                        arr[i] = sc.nextInt();
                    }
                    break;
                case 2:
                    for (int i = 0; i < n; i++) {
                        System.out.println(arr[i]);
                    }
                    break;
                case 3:
                    int sum = 0;
                    int count = 0;
                    for (int i = 0; i < n; i++) {
                        if (arr[i] > 0) {
                            sum += arr[i];
                            count++;
                        }
                    }
                    System.out.println("Trung bình các phần tử dương trong mảng: " + (double) sum / count);
                    break;
                case 4:
                    System.out.println("Nhập giá trị k: ");
                    int k = sc.nextInt();
                    System.out.println("Vị trí của phần tử " + k + " là: ");
                    for (int i = 0; i < n; i++) {
                        if (arr[i] == k) {
                            System.out.print( i);
                        }
                    }
                    break;
                case 5:
                    for (int i = 0; i < n; i++) {
                        for (int j = i + 1; j < n; j++) {
                            if (arr[i] < arr[j]) {
                                int temp = arr[i];
                                arr[i] = arr[j];
                                arr[j] = temp;
                            }
                        }
                    }
                    System.out.println("Mảng sau khi sắp xếp giảm dần: ");
                    for (int i = 0; i < n; i++) {
                        System.out.println(arr[i]);
                    }
                    break;
                case 6:
                    int countPrime = 0;
                    for (int i = 0; i < n; i++) {
                        if (isPrime(arr[i])) {
                            countPrime++;
                        }
                    }
                    System.out.println("Số lượng số nguyên tố trong mảng: " + countPrime);
                    break;
                case 7:
                    specialSort(arr);
                    break;
                case 8:
                    System.out.print("Nhập giá trị m: ");
                    int m = sc.nextInt();
                    arr = insertIntoSortedArray(arr, m);
                    System.out.println("Mảng sau khi chèn giá trị m: ");
                    for (int i = 0; i < n + 1; i++) {
                        System.out.println(arr[i]);
                    }
                    break;
                case 9:
                    System.out.println("Thoát chương trình!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
            }
        } while (choice != 9);

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

    public static void specialSort(int[] arr) {
        int countEven = 0, countOdd = 0, countOthers = 0;

        // Đếm số lượng phần tử của từng nhóm
        for (int num : arr) {
            if (num % 3 == 0) {
                if (num % 2 == 0) countEven++;
                else countOdd++;
            } else {
                countOthers++;
            }
        }

        int[] evenDiv3 = new int[countEven];
        int[] oddDiv3 = new int[countOdd];
        int[] others = new int[countOthers];

        int iEven = 0, iOdd = 0, iOthers = 0;

        for (int num : arr) {
            if (num % 3 == 0) {
                if (num % 2 == 0) evenDiv3[iEven++] = num; // Số chẵn chia hết cho 3
                else oddDiv3[iOdd++] = num;  // Số lẻ chia hết cho 3
            } else {
                others[iOthers++] = num;  // Các số còn lại
            }
        }

        // Sắp xếp theo yêu cầu
        Arrays.sort(evenDiv3);
        Arrays.sort(others);
        Arrays.sort(oddDiv3);
        reverseArray(oddDiv3);


        int index = 0;
        for (int num : evenDiv3) arr[index++] = num;
        for (int num : others) arr[index++] = num;
        for (int num : oddDiv3) arr[index++] = num;
    }

    public static void reverseArray(int[] array) {
        int left = 0, right = array.length - 1;
        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }

    public static int[] insertIntoSortedArray(int[] arr, int m) {
        int[] newArr = new int[arr.length + 1];
        int i = 0, j = 0;

        while (i < arr.length && arr[i] > m) {
            newArr[j++] = arr[i++];
        }
        newArr[j++] = m;
        while (i < arr.length) {
            newArr[j++] = arr[i++];
        }

        return newArr;
    }
}
