
import java.util.*;
public class Solution {
    public static boolean Prime(int n){
        for(int i = 2; i * i <= n; i++){
            if(n % i == 0) return false;
        }
        return n > 1;
    }
    public static boolean check(int n){
        int temp = n;
        int rev = 0;
        while(n > 0){
            rev = rev * 10 + n % 10;
            n /= 10;
        }
        return rev == temp;
    }
    public static long gcd(long a, long b){
        while(b > 0){
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
            double a = sc.nextDouble(), b = sc.nextDouble(), c = sc.nextDouble(), d = sc.nextDouble();
            double res = Math.sqrt((double)(a - c) * (a - c) + (b - d) * (b - d));
            System.out.printf("%.4f", res);
            System.out.println();
        }
    }
}
