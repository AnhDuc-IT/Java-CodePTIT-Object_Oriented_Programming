import java.util.*;
import java.math.BigInteger;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0){
            BigInteger num1 = new BigInteger(sc.next());
            BigInteger num2 = new BigInteger(sc.next());
            int max = Math.max(num1.toString().length(), num2.toString().length());
            String ans = num1.subtract(num2).abs().toString();
            while(ans.length() < max){
                ans = "0" + ans;
            }
            System.out.println(ans);
        }
    }
}
