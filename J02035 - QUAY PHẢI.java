import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int step = 0;
            long[] a = new long[n];
            for(int i = 0; i < n; i++){
                a[i] = sc.nextLong();
            }
            for(int i = 1; i < n; i++){
                if(a[i] < a[i - 1]){
                    step = i;
                }
            }
            System.out.println(step);
        }
    }
}
