import java.util.*;
public class Solution {
    public static int MOD = 1000000007;
    static long[] F = new long[94];
    static{
        F[1] = 1; F[2] = 1;
        for(int i = 3; i <= 92; i++){
            F[i] = F[i - 1] + F[i - 2];
        }
    }
    public static char Find(int n, long k){
        if(n == 1) return '0';
        if(n == 2) return '1';
        if(k <= F[n - 2]) return Find(n - 2, k);
        return Find(n - 1, k - F[n - 2]);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
            int n = sc.nextInt();
            long k = sc.nextLong();
            System.out.println(Find(n, k));
            t--;
        }
    }
}
