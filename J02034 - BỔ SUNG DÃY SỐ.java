import java.util.*;
public class Solution {
    public static int MOD = 1000000007;
    public static boolean Prime(long n){
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        int cnt = 1;
        boolean check = false;
        for(int i = 0; i < n; i++){
            if(cnt != a[i]){
                check = true;
                while(cnt != a[i]){
                    System.out.println(cnt);
                    ++cnt;
                }
                ++cnt;
            }
            else{
                ++cnt;
            }
        }
        if(!check){
            System.out.println("Excellent!");
        }
    }
}
 
