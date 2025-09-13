import java.awt.*;
import java.util.*;
import java.util.Queue;
class Pair{
    private int first, second;
    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
    public int getFirst(){
        return this.first;
    }
    public int getSecond(){
        return this.second;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            TreeSet <Integer> set = new TreeSet<>();
            int s = sc.nextInt(), T = sc.nextInt();
            Queue <Pair> queue = new LinkedList<>();
            queue.add(new Pair(s, 0));
            int temp = T * 2;
            while(!queue.isEmpty()){
                Pair a = queue.poll();
                if(a.getFirst() == T){
                    System.out.println(a.getSecond());
                    break;
                }
                if(!set.contains(a.getFirst() - 1)){
                    set.add(a.getFirst() - 1);
                    queue.add(new Pair(a.getFirst() - 1, a.getSecond() + 1));
                }
                if(!set.contains(a.getFirst() * 2) && a.getFirst() * 2 <= temp){
                    set.add(a.getFirst() * 2);
                    queue.add(new Pair(a.getFirst() * 2, a.getSecond() + 1));
                }
            }
        }
    }
}
