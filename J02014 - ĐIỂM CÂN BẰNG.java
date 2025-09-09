import java.util.*;

public class Solution {
    public static int MOD = 1000000007;
    public static void change(String s){
        boolean check = true;
        char[] a = s.toCharArray();
        for(int i = 0; i < s.length(); i++){
            if(a[i] != '0' && a[i] != '1' && a[i] != '8' && a[i] != '9'){
                System.out.println("INVALID");
                return;
            }
            if(a[i] == '8') a[i] = '0';
            if(a[i] == '9') a[i] = '0';
        }
        for(char x : a){
            if(x != '0') check = false;
        }
        if(check){
            System.out.println("INVALID");
            return;
        }
        int pos = 0;
        for(int i = 0; i < s.length(); i++){
            if(a[i] != '0'){
                pos = i;
                break;
            }
        }
        for(int i = pos; i < s.length(); i++){
            System.out.print(a[i]);
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int[] a = new int[n + 1];
            int[] dp = new int[n + 1];
            int total = 0;
            for(int i = 1; i <= n; i++){
                a[i] = sc.nextInt();
                dp[i] = dp[i - 1] + a[i];
                total += a[i];
            }
            boolean check = true;
            for(int i = 1; i <= n; i++){
                if(dp[i - 1] * 2 + a[i] == total){
                    System.out.println(i);
                    check = false;
                    break;
                }
            }
            if(check){
                System.out.println(-1);
            }
        }
    }
}
