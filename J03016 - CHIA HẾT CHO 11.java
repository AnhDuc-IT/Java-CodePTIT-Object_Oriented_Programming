import java.math.BigInteger;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0){
            BigInteger num1 = new BigInteger(sc.nextLine());
            BigInteger num2 = new BigInteger("11");
            if(num1.mod(num2).equals(BigInteger.ZERO)){
                System.out.println("1");
            }else{
                System.out.println("0");
            }
        }
    }
}
