import java.util.*;
public class Solution {
    public static int MOD = 1000000007;
    public static boolean Prime(long n){
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0) return false;
        }
        return true;
    }
    static boolean check(String s){
        int cnt = 0;
        int l = 0, r = s.length() - 1;
        while(l < r){
            if(s.charAt(l) != s.charAt(r)){
                ++cnt;
            }
            ++l; --r;
        }
        if(cnt == 1) return true;
        if(cnt == 0 && s.length() % 2 == 1) return true;
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
