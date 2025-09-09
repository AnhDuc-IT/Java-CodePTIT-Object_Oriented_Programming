import java.io.IOException;
import java.nio.Buffer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;
class Pair <U, V>{
    private U first;
    private V second;
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
    public String toString(){
        return this.first + " " + this.second;
    }
}
public class Solution{
    static String Change(String s){
        String res = "";
        for(int i = 0; i < s.length(); i++){
            char x = s.charAt(i);
            if(Character.isAlphabetic(x) || x == ' ' || Character.isDigit(x)){
                res += x;
            }else{
                res += " ";
            }
        }
        return res;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("VANBAN.in"));
        int n = Integer.parseInt(br.readLine());
        TreeMap <String, Integer> map = new TreeMap<>();
        for(int i = 1; i <= n; i++){
            String a = br.readLine();
            a = Change(a);
            String[] line = a.split("\\s+");
            for(String x : line){
                x = x.toLowerCase();
                if(!x.isEmpty()){
                    if(map.containsKey(x)){
                        map.put(x, map.get(x) + 1);
                    }else{
                        map.put(x, 1);
                    }
                }
            }
        }
        ArrayList <Pair<String, Integer>> arr = new ArrayList<>();
        map.forEach((u, v) ->{
            arr.add(new Pair(u, v));
        });
        Collections.sort(arr, new Comparator<Pair<String, Integer>>() {
            @Override
            public int compare(Pair <String, Integer> o1, Pair <String, Integer> o2){
                int cmp = o2.getSecond().compareTo(o1.getSecond());
                if(cmp == 0){
                    return o1.getFirst().compareTo(o2.getFirst());
                }
                return cmp;
            }
        });
        for(Pair<String, Integer> x : arr){
            System.out.println(x);
        }
    }
}
