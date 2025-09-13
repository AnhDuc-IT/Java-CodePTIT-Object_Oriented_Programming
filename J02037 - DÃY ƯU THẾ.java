import java.math.BigInteger;
import java.util.*;

public class Solution {
    public static boolean check(String s){
        String[] a = s.split(" ");
        int cnt = 0, count = 0;
        for(String x : a){
            int temp = Integer.parseInt(x);
            if(temp % 2 == 0){
                ++cnt;
            }else{
                ++count;
            }
        }
        if(a.length % 2 == 0 && cnt > count || a.length % 2 == 1 && cnt < count){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0){
            String s = sc.nextLine();
            if(check(s)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}
