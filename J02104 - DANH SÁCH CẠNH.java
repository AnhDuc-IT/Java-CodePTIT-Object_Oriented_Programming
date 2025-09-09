import java.util.*;
public class Solution {
    public static int MOD = 1000000007;
    public static int Process(int n){
        int cnt = 0;
        for(int i = 1; i * i <= n; i++){
            if(n % i == 0){
                ++cnt;
                if(n / i != i){
                    ++cnt;
                }
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                a[i][j] = sc.nextInt();
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(a[i][j] == 1 && i < j){
                    System.out.println("(" + (i + 1) + "," + (j + 1) + ")");
                }
            }
        }
    }
}
