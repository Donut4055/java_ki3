import java.util.Scanner;

public class Bt7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int [n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int mark = 0;
        for(int i = 0; i <n; i++){
            for(int j = 0; j < i; j++){
                if((arr[i]%2 == 0) && (arr[j]%2 != 0)) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    mark++;
                    break;
                }
            }
        }
        if(mark == 0){
            System.out.println("giu nguyen thu tu mang");
        } else {
            for(int i = 0; i < n; i++){
                System.out.print(arr[i] + " ");
            }
        }
    }
}
