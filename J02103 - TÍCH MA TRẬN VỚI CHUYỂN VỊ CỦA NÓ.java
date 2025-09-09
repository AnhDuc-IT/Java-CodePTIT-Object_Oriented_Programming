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
        int t = sc.nextInt();
        for(int k = 1; k <= t; k++){
            int n = sc.nextInt(), m = sc.nextInt();
            int[][] a = new int[n][m];
            int[][] b = new int[m][n];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    a[i][j] = sc.nextInt();
                    b[j][i] = a[i][j];
                }
            }
            System.out.println("Test " + k + ":");
            int [][] res = new int[n][n];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m;j++){
                    for(int l = 0; l < n; l++){
                        res[i][l] += a[i][j] * b[j][l];
                    }
                }
            }
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    System.out.print(res[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
