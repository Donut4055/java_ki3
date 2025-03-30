import java.util.Scanner;

public class Bt2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {1, 2, 3, 4, 5};
        try{
            int i = sc.nextInt();
            if (i < 0 || i >= arr.length) {
                throw new ArrayIndexOutOfBoundsException("Chỉ số ngoài phạm vi của mảng");
            }
            System.out.println(arr[i]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }
}
