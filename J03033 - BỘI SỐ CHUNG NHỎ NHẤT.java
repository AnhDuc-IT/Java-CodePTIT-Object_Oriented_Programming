import java.util.*;
import java.math.BigInteger;
public class Solution {
    public static BigInteger Process(BigInteger a, BigInteger b){
        BigInteger temp = a.gcd(b);
        return a.multiply(b).divide(temp);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            BigInteger num1 = new BigInteger(sc.next());
            BigInteger num2 = new BigInteger(sc.next());
            System.out.println(Process(num1, num2));
        }
    }
}
