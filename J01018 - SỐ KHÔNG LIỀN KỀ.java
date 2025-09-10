import java.util.*;
public class Solution {
    public static boolean Prime(int n){
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
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
            long n = sc.nextLong();
            if(check(n)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
            t -=1;
        }
    }
}
