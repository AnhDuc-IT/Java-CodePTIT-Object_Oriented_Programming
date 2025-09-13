import java.math.BigInteger;
import java.util.*;

public class Solution {
    public static int binPow(int a, int b){
        if(b == 0) return 1;
        return a * binPow(a, b - 1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            BigInteger n = new BigInteger(sc.next());
            int a = Integer.parseInt(n.mod(BigInteger.valueOf(4)).toString());
            int b = Integer.parseInt(n.mod(BigInteger.valueOf(2)).toString());
            int total = (binPow(2, a) + binPow(3, a) + binPow(4, b) + 1) % 5;
            System.out.println(total);
        }
        sc.close();
    }
}
