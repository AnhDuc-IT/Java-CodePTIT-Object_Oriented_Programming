import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt(), k = sc.nextInt();
            int[] a = new int[n];
            for(int i = 0; i < n; i++){
                a[i] = sc.nextInt();
            }
            Arrays.sort(a);
            long cnt = 0;
            for(int i = 0; i < n - 1; i++){
                int l = i + 1, r = n - 1, pos = i;
                while(l <= r){
                    int m = (l + r) / 2;
                    if(a[m] - a[i] < k){
                        l = m + 1;
                        pos = m;
                    }else{
                        r = m - 1;
                    }
                }
                cnt += pos - i;
            }
            System.out.println(cnt);
        }
    }
}
