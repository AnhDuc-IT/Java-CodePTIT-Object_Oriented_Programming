import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        int[] dp = new int[n];
        int index= - 1;
        for(int i = 0; i < n; i++){
            if(index >= 0 && (dp[index] + a[i]) % 2 == 0){
                --index;
            }else{
                dp[++index] = a[i];
            }
        }
        System.out.println(index + 1);
    }
}
