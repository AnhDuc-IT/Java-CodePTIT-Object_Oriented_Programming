import java.util.*;

public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            long x =  sc.nextLong();
            Map <Long, Long> map = new LinkedHashMap<>();
            long[] a = new long[n];
            long cnt = 0;
            for(int i = 0; i < n; i++){
                a[i] = sc.nextLong();
            }
            for(int i = 0; i < n; i++){
                long temp = x - a[i];
                if(map.containsKey(temp)){
                    cnt += map.get(temp);
                }
                map.put(a[i], map.getOrDefault(a[i], 0L) + 1);
            }
            System.out.println(cnt);
        }
    }
}
