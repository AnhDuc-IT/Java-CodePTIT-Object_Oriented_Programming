import java.util.*;
class Pair<U, V>{
    private U first;
    private V second;
    public Pair(){}
    public Pair(U first, V second){
        this.first = first;
        this.second = second;
    }
    public U getFirst(){
        return this.first;
    }
    public V getSecond(){
        return this.second;
    }
}
public class Solution {
    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            String st = sc.next(), end = sc.next();
            int st1 = st.charAt(1) - '0', st2 = st.charAt(0) - 'a' + 1;
            int end1 = end.charAt(1) - '0', end2 = end.charAt(0) - 'a' + 1;
            boolean[][] used = new boolean[1005][1005];
            Pair <Integer, Integer> pair = new Pair();
            Queue<Pair<Pair<Integer, Integer>, Integer>> queue = new LinkedList<>();
            used[st1][st2] = true;
            queue.add(new Pair(new Pair(st1, st2), 0));
            while(!queue.isEmpty()){
                Pair<Pair<Integer, Integer>, Integer> it = queue.element(); queue.poll();
                if(it.getFirst().getFirst() == end1 && it.getFirst().getSecond() == end2){
                    System.out.println(it.getSecond());
                    break;
                }
                for(int k = 0; k < 8; k++){
                    int i1 = it.getFirst().getFirst() + dx[k];
                    int j1 = it.getFirst().getSecond() + dy[k];
                    if(i1 <= 8 && i1 >=1 && j1 <= 8 && j1 >= 1 && !used[i1][j1]){
                        queue.add(new Pair(new Pair(i1, j1), it.getSecond() + 1));
                        used[i1][j1] = true;
                    }
                }
            }
        }
    }
}
