import java.math.BigInteger;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            String s = sc.next();
            int k = sc.nextInt();
            Set <Character> set = new HashSet<>();
            for(int i = 0; i < s.length(); i++){
                set.add(s.charAt(i));
            }
            if(s.length() < 26){
                System.out.println("NO");
            }else{
                if(set.size() + k >= 26){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
            }
        }
    }
}
