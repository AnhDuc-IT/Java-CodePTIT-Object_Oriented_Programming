import java.util.*;
import java.math.BigInteger;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n][n];
        ArrayList <Integer> arr = new ArrayList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                arr.add(sc.nextInt());
            }
        }
        int cnt = 0;
        int c1 = 0, c2 = n - 1, h1 = 0, h2 = n - 1;
        Collections.sort(arr);
        while(cnt < n * n){
            for(int i = c1; i <= c2; i++){
                a[h1][i] = arr.get(cnt++);
            }
            ++h1;
            for(int i = h1; i <= h2; i++){
                a[i][c2] = arr.get(cnt++);
            }
            --c2;
            for(int i = c2; i >= c1; i--){
                a[h2][i] = arr.get(cnt++);
            }
            --h2;
            for(int i = h2; i >= h1; i--){
                a[i][c1] = arr.get(cnt++);
            }
            ++c1;
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}
