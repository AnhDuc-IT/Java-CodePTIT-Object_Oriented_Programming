import java.util.*;
public class Solution {
    public static long gcd(long a, long b){
        while(b != 0){
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
        int n = sc.nextInt();
        long ans = 1;
        for(int i = 1; i <= n; i++){
            ans = i * ans / gcd(i, ans);
        }
        System.out.println(ans);
        }
    }
}
