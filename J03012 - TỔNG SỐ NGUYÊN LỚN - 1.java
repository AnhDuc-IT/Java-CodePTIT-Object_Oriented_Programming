import java.math.BigInteger;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            BigInteger num1 = new BigInteger(sc.next());
            BigInteger num2 = new BigInteger(sc.next());
            System.out.println(num1.add(num2));
        }
    }
}
