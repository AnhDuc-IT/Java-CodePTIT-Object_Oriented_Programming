import java.util.*;
public class Solution {
    public static int MOD = 1000000007;
    public static boolean Prime(long n){
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0) return false;
        }
        return true;
    }
    public static boolean binarySearch(ArrayList<Integer> arr, int n, int x){
        int l = 0, r = n - 1;
        while(l <= r){
            int m = (l + r) / 2;
            if(arr.get(m) == x) return true;
            else if(arr.get(m) < x){
                l = m + 1;
            }
            else{
                r = m - 1;
            }
        } 
        return false;
    }
    public static void solution(ArrayList <Long> arr, int n, int x){
        for(int i = 0; i < n; i++){
            if(arr.get(i) == x) System.out.println("YES");
            return;
        }
        System.out.println("NONE\n");
    }
    public static long define(long a, long b){
        while(b != 0){
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
    public static void solve(){
        ArrayList <Integer> arr = new ArrayList<>();
        arr.forEach((x) -> System.out.print(x + " "));
        return ;
    }
    public static long gcd(long a, long b){
        while(b != 0){
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
    public static long binPow(long a, long b){
        if(b == 1) return a;
        long temp = binPow(a, b / 2);
        if(b % 2 == 1){
            return (((temp % MOD) * (temp % MOD)) % MOD * (a % MOD)) % MOD;
        }else{
            return (temp % MOD) * (temp % MOD) % MOD;
        }
    }
    static boolean check(String s){
        int[] cnt = new int[10];
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '0') return false;
            cnt[s.charAt(i) - '0']++;
        }
        for(int i = 1; i <= s.length(); i++){
            if(cnt[i] != 1) return false;
        }
        for(int i = 1; i < s.length(); i++){
            if(Math.abs(s.charAt(i) - s.charAt(i - 1)) == 1) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        Set <Integer> se1 = new HashSet<>();
        Set <Integer> se2 = new HashSet<>();
        ArrayList <Integer> res = new ArrayList<>();
        for(int i = 0; i < n; i++){
            int x = sc.nextInt();
            se1.add(x);
        }
        for(int i = 0; i < m; i++){
            int x = sc.nextInt();
            se2.add(x);
        }
        for(int x : se2){
            if(se1.contains(x)){
                res.add(x);
            }
        }
        Collections.sort(res);
        res.forEach((x) -> System.out.print(x + " "));
    }
}
