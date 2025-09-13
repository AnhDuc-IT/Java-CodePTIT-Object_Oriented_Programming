import java.util.*;

public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            Queue <String> queue = new LinkedList<>();
            ArrayList <String> arr = new ArrayList<>();
            queue.add("6");
            queue.add("8");
            while(true){
                String s = queue.poll();
                if(s.length() > n) break;
                arr.add(s);
                queue.add(s + "6");
                queue.add(s + "8");
            }
            System.out.println(arr.size());
            for(int i = arr.size() - 1; i >= 0; i--){
                System.out.print(arr.get(i) + " ");
            }
            System.out.println();
        }
    }
}
