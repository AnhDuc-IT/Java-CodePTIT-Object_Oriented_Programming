import java.util.*;
public class Solution {
    public static int MOD = 1000000007;
    public static int Process(int n){
        int cnt = 0;
        for(int i = 1; i * i <= n; i++){
            if(n % i == 0){
                ++cnt;
                if(n / i != i){
                    ++cnt;
                }
            }
        }
        return cnt;
    }
    static int[] a = new int[100];
    static int n, k;
    static boolean check;
    public static void ktao(){
        for(int i = 1; i <= k; i++){
            a[i] = i;
        }
    }
    public static void generate(){
        int i = k;
        while(i >= 1 && a[i] == n - k + i){
            --i;
        }
        if(i == 0){
            check = false;
        }
        else{
            ++a[i];
            for(int j = i + 1; j <= k; j++){
                a[j] = a[j - 1] + 1;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); k = sc.nextInt();
        ktao();
        check = true;
        int cnt = 0;
        while(check){
            for(int i = 1; i <= k; i++){
                System.out.print(a[i]);
            }
            System.out.print(" ");
            ++cnt;
            generate();
        }
        System.out.println();
        System.out.println("Tong cong co " + cnt + " to hop");
    }
}
