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
        int total = 0;
        if(a.charAt(r) != '8' && a.charAt(l) != '8') return false;
        while(l < r){
            if(a.charAt(l) != a.charAt(r)) return false;
            total += 2 * (a.charAt(l) - '0');
            ++l; --r;
        }
        if(n % 2 == 1){
            total += (a.charAt(l) - '0');
        }
        return total % 10 == 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0){
            String s = sc.nextLine();
            if(check(s, s.length())) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
