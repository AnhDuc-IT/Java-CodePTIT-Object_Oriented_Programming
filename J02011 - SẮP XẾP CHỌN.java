import java.util.*;

public class Solution {
    public static int MOD = 1000000007;
    public static void selectionSort(int a[], int n){
        int step = 1;
        for(int i = 0; i < n - 1; i++){
            int pos = i;
            for(int j = i + 1; j < n; j++){
                if(a[j] < a[pos]){
                    pos = j;
                }
            }
            int temp = a[i];
            a[i] = a[pos];
            a[pos] = temp;
            System.out.print("Buoc " + (i + 1) + ": ");
            for(int j = 0 ; j < n; j++){
                System.out.print(a[j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        selectionSort(a, n);
    }
}
