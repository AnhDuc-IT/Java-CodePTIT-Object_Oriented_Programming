import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        Integer[] a = new Integer[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        Arrays.sort(a, (x, y) -> Math.abs(y) - Math.abs(x));
        for(int i = 0; i < n; i++){
            if(k > 0){
                if(a[i] < 0){
                    a[i] = -a[i];
                    --k;
                }
            }
        }
        if(k % 2 == 1){
            a[n - 1] = -a[n - 1];
        }
        long total = 0;
        for(int x : a) total += x;
        System.out.println(total);
        sc.close();
    } 
}
