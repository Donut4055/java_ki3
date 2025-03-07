import java.util.Scanner;

import static java.lang.Math.sqrt;

public class Bt6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("***********************MAIN MENU**************************");
            System.out.println("1. xử lí chuỗi");
            System.out.println("2. xử lí số nguyên");
            System.out.println("3. thoát");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    int strChoice;
                    String str = "";
                    do {
                        System.out.println("***********************STR MENU**************************");
                        System.out.println("1. nhập chuỗi");
                        System.out.println("2. loại khoảng trắng thừa");
                        System.out.println("3. đếm số lần xuất hiện của từng ký tự");
                        System.out.println("4. chuyển đổi chuỗi thành dạng chuẩn (viết hoa chữ cái đầu mỗi từ)");
                        System.out.println("5. thoát");
                        strChoice = sc.nextInt();
                        switch (strChoice) {
                            case 1:
                                System.out.println("Nhập chuỗi: ");
                                str = sc.nextLine();
                                break;
                            case 2:
                                str = str.replaceAll("\\s+", " ").trim();
                                System.out.println(str);
                                break;
                            case 3:
                                int[] freq = new int[256];
                                for (char ch : str.toCharArray()) {
                                    freq[ch]++;
                                }
                                System.out.println("Số lần xuất hiện của từng ký tự:");
                                for (int i = 0; i < 256; i++) {
                                    if (freq[i] > 0) {
                                        System.out.println("'" + (char) i + "': " + freq[i] + " lần");
                                    }
                                }
                                break;
                            case 4:
                                str = sc.nextLine().toLowerCase().trim();
                                String[] words = str.split("\\s+");
                                String result = "";
                                for (String word : words) {
                                    if (!word.isEmpty()) {
                                        result += Character.toUpperCase(word.charAt(0)) + word.substring(1) + " ";
                                    }
                                }
                                System.out.println(result);
                                break;
                            case 5:
                                System.out.println("Thoát chương trình");
                                break;
                            default:
                                System.out.println("Lựa chọn không hợp lệ");
                                break;
                        }
                    } while (strChoice != 5);
                    break;
                case 2:
                    int numChoice;
                    int n = 0;
                    int[] arr = new int[100];
                    do {
                        System.out.println("***********************NUM MENU**************************");
                        System.out.println("1. nhâp mảng số nguyên");
                        System.out.println("2. tìm số nguyên tố lớn nhất trong mảng");
                        System.out.println("3. đếm số phần tử có chữ số đầu tiên là số lẻ");
                        System.out.println("4. kiểm tra xem mảng có phải đối xứng không");
                        numChoice = sc.nextInt();
                        switch (numChoice) {
                            case 1:
                                n = sc.nextInt();
                                for (int i = 0; i < n; i++) {
                                    arr[i] = sc.nextInt();
                                }
                                break;
                            case 2:
                                int maxPrime = Integer.MIN_VALUE;
                                for (int i = 0; i < n; i++) {
                                    if (isPrime(arr[i]) && arr[i] > maxPrime) {
                                        maxPrime = arr[i];
                                    }
                                }
                                if (maxPrime != Integer.MIN_VALUE) {
                                    System.out.println("Số nguyên tố lớn nhất trong mảng: " + maxPrime);
                                } else {
                                    System.out.println("Không có số nguyên tố trong mảng");
                                }
                                break;
                            case 3:
                                int countOdd = 0;
                                for (int i = 0; i < n; i++) {
                                    int firstDigit = getFirstDigit(Math.abs(arr[i]));
                                    if (firstDigit % 2 == 1) {
                                        countOdd++;
                                    }
                                }
                                System.out.println("Số phần tử có chữ số đầu tiên là số lẻ: " + countOdd);
                                break;
                            case 4:
                                boolean isSymmetric = true;
                                for (int i = 0; i < n / 2; i++) {
                                    if (arr[i] != arr[n - 1 - i]) {
                                        isSymmetric = false;
                                        break;
                                    }
                                }

                                if (isSymmetric) {
                                    System.out.println("Mảng đối xứng.");
                                } else {
                                    System.out.println("Mảng không đối xứng.");
                                }
                                break;
                            case 5:
                                System.out.println("Thoát chương trình");
                                break;
                            default:
                                System.out.println("Lựa chọn không hợp lệ");
                                break;
                        }
                    } while (numChoice != 5);
            }
        } while (choice != 3);
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
    public static int getFirstDigit(int num) {
        while (num >= 10) {
            num /= 10;
        }
        return num;
    }
}

