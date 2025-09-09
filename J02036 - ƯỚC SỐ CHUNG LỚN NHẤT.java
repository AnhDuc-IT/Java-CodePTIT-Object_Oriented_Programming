import java.util.*;

public class Solution {
    static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[n + 1];
            for(int i = 0; i < n; i++){
                a[i] = sc.nextInt();
            }
            b[0] = a[0];
            b[n] = a[n - 1];
            for(int i = 1; i < n; i++){
                b[i] = lcm(a[i], a[i - 1]);
            }
            for(int x : b){
                System.out.print(x + " ");
            }
            System.out.println();
        } 
    }
}
