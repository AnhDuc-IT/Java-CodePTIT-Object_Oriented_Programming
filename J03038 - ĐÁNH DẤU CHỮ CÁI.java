import java.util.*;
public class Solution {
    public static int MOD = 1000000007;
    static int n; static boolean check; static int[] a = new int[101];
    public static void ktao(){
        for(int i = 1; i <= n ; i++){
            a[i] = i;
        }
    }
    static void generte(){
        int i = n - 1;
        while(i >= 1 && a[i] > a[i + 1]){
            --i;
        }
        if(i == 0) check = false;
        else{
            int j = n;
            while(a[i] > a[j]){
                --j;
            }
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            int l = i + 1, r = n;
            while(l < r){
                int tmp = a[r];
                a[r] = a[l];
                a[l] = tmp;
                ++l; --r;
            }
        }
    }
    static boolean ok(){
        int[] cnt = new int[10];
        for(int i = 1; i <= n; i++){
            cnt[a[i]]++;
            if(a[i] == 0) return false;
        }
        for(int i = 1; i <= n; i++){
            if(cnt[a[i]] != 1) return false;
        }
        for(int i = 2; i <= n; i++){
            if(Math.abs(a[i] - a[i - 1]) == 1) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[] cnt = new int[256];
        for(int i = 0; i < s.length(); i++){
            cnt[s.charAt(i)]++;
        }
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            if(cnt[s.charAt(i)] != 0){
                ++res;
                cnt[s.charAt(i)] = 0;
            }
        }
        System.out.println(res);
    }
}
