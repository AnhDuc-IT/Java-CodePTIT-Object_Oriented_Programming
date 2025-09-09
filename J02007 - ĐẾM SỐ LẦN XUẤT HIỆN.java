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
    public static boolean check(long n){
        long sum = 0;
        long a = n % 10;
        sum += n % 10;
        n /= 10;
        while(n > 0){
            long b = n % 10;
            sum += b;
            if(Math.abs(a - b) != 2) return false;
            a = b;
            n /= 10;

        }
        return sum % 10 == 0;
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
    static long[] F = new long[94];
    static{
        F[1] = 1; F[2] = 1;
        for(int i = 3; i <= 92; i++){
            F[i] = F[i - 1] + F[i - 2];
        }
    }
    public static char Find(int n, long k){
        if(n == 1) return '0';
        if(n == 2) return '1';
        if(k <= F[n - 2]) return Find(n - 2, k);
        return Find(n - 1, k - F[n - 2]);
    }
    static boolean check(int a[], int n){
        int l = 0, r = n - 1;
        while(l < r){
            if(a[l] != a[r]) return false;
            ++l; --r;
        }
        return true;
    }
    static void solve(int a[], int n){
        int[] cnt = new int[1000006];
        for (int i = 0; i < n; i++){
            cnt[a[i]]++;
        }
        for(int i = 0; i < n; i++){
            if(cnt[a[i]] > 0){
                System.out.println(a[i] + " xuat hien " + cnt[a[i]] + " lan");
                cnt[a[i]] = 0;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int j = 1; j <= t; j++){
            System.out.println("Test " + j + ":");
            int n = sc.nextInt();
            int[] a = new int[n];
            for(int i = 0; i < n; i++){
                a[i] = sc.nextInt();
            }
            solve(a, n);
        }
    }
}
