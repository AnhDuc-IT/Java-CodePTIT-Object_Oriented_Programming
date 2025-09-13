import java.util.*;
public class Solution {
    public static int MOD = 1000000007;
    public static int check(String s){
        int cnt = 0;
        for(int i = 0; i < s.length(); i++){
            if(!Character.isDigit(s.charAt(i))) return 0;
            if((s.charAt(i) - '0') % 2 == 0) ++cnt;
        }
        int n = s.length();
        if(n % 2 == 0 && cnt > (n - cnt)) return 1;
        if(n % 2 == 1 && cnt < (n - cnt)) return 1;
        return 2;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0){
            String s = sc.nextLine();
            if(check(s) == 1) System.out.println("YES");
            else if(check(s) == 0) System.out.println("INVALID");
            else System.out.println("NO");
        }
    }
}
