import java.util.*;

public class Solution {
    public static int MOD = 1000000007;

    public static long binPow(long a, long b) {
        if (b == 0) return 1;
        if (b == 1) return a % MOD;

        long temp = binPow(a, b / 2) % MOD;
        temp = (temp * temp) % MOD;

        if (b % 2 == 1) {
            temp = (temp * (a % MOD)) % MOD;
        }
        return temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            long a = sc.nextLong(), b = sc.nextLong();
            if (a == 0 && b == 0) {
                break;
            }
            System.out.println(binPow(a, b));
        }
    }
}
