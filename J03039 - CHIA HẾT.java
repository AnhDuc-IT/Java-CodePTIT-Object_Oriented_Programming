import java.math.BigInteger;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0){
            BigInteger num1 = new BigInteger(sc.next());
            BigInteger num2 = new BigInteger(sc.next());
            if(num1.mod(num2).equals(BigInteger.ZERO) || num2.mod(num1).equals(BigInteger.ZERO)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}
