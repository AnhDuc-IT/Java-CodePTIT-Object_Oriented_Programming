import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            long k = sc.nextLong();
            int[] a = new int[n];
            for(int i = 0; i < n; i++){
                a[i] = sc.nextInt();
            }
            Set <Long> set = new HashSet<>();
            long total = 0;
            boolean find = true;
            set.add(1l * 0);
            for(int i = 0; i < n; i++){
                total += a[i];
                if(set.contains(total - k)){
                    System.out.println("YES");
                    find = false;
                    break;
                }
                set.add(total);
            }
            if(find){
                System.out.println("NO");
            }
        }
    }
}
