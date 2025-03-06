import java.util.Scanner;

public class Bt6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int [n];
        int[] mark = new int[1000];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
            mark[arr[i]]++;
        }
        int max = 0;
        for(int i = 0; i < 1000; i++){
            if(mark[i] > max){
                max = mark[i];
            }
        }
        for (int i=0; i<1000; i++){
            if(mark[i] == max){
                System.out.println("phan tu " + i + " xuat hien " + mark[i] + " lan");
            }
        }
    }
}
