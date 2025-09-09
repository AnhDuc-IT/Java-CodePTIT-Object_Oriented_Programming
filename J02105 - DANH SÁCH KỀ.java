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
    static boolean check(String a, int n){
        int l = 0, r = n - 1;
        while(l <= r){
            if(a.charAt(l) != a.charAt(r)) return false;
            if(!Prime(a.charAt(l) - '0')) return false;
            ++l; --r;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int [n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                a[i][j] = sc.nextInt();
            }
        }
        for(int i = 0; i < n; i++){
            System.out.print("List(" + (i + 1) + ") = ");
            for(int j = 0; j < n; j++){
                if(a[i][j] == 1){
                    System.out.print((j + 1) + " ");
                }
            }
            System.out.println();
        }
    }
}
