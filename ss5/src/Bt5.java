import java.util.Scanner;

public class Bt5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int [n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        int max = arr[0], min = arr[0];
        for(int i = 0; i < n; i++){
            if((arr[i] > 0 ) && (arr[i]%2 !=0)){
                max = arr[i];
                min = arr[i];
                break;
            }
        }
        for(int i = 1; i < n; i++){
            if((arr[i] > max) && (arr[i] > 0 ) && (arr[i]%2 !=0)){
                max = arr[i];
            }
            if((arr[i] < min) && (arr[i] > 0 ) && (arr[i]%2 !=0)){
                min = arr[i];
            }
        }
        if((max%2 == 0) || (min%2 == 0)) {
            System.out.println("khong co phan tu le nguyen duong trong mang");
        } else System.out.println(max + " " + min);
    }
}
