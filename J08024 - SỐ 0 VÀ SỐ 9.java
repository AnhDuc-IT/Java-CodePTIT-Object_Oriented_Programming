import java.util.*;
import java.util.Queue;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            Queue <Long> queue = new LinkedList<>();
            long s = 9;
            queue.add(s);
            while(!queue.isEmpty()){
                long temp = queue.poll();
                if(temp % n == 0){
                    System.out.println(temp);
                    break;
                }
                queue.add(Long.parseLong("" + temp + "0"));
                queue.add(Long.parseLong("" + temp + "9"));
            }
        }
    }
}
