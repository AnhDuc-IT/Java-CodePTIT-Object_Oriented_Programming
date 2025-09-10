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
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
            int n = sc.nextInt();
            System.out.println(1l * n * (n + 1) / 2);
            t--;
        }
    }
}
