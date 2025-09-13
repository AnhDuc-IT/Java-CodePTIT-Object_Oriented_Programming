import java.io.*;
import java.util.*;
class Pair implements Comparable<Pair>{
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
    public String toString(){
        return this.first + " "  + this.second;
    }
    @Override
    public int compareTo(Pair other){
        return other.second - this.second;
    }
}
public class Solution{
    static boolean check(String s){
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) < s.charAt(i - 1)) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList <Pair> arr = new ArrayList<>();
        LinkedHashMap <Integer, Integer> map = new LinkedHashMap<>();
        while(sc.hasNext()){
            Integer x = Integer.parseInt(sc.next());
            if(map.containsKey(x)){
                map.put(x, map.get(x) + 1);
            }else{
                map.put(x, 1);
            }
        }
        map.forEach((u, v) -> {
            Pair a = new Pair(u, v);
            if(check("" + a.getFirst())){
                arr.add(a);
            }
        });
        Collections.sort(arr);
        for(Pair x : arr){
            System.out.println(x.getFirst() + " " + x.getSecond());
        }
    }
}
