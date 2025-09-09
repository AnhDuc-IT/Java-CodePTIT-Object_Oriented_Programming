import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.Buffer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
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
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("DATA.in"));
        ArrayList <String> a = (ArrayList<String>)ois.readObject();
        ois.close();
        TreeMap <String, Integer> map = new TreeMap<>();
        for(String x : a){
            String[] line = (Change(x)).split("\\s+");
            for(String it : line){
                it = it.toLowerCase();
                if(!it.isEmpty()){
                    if(map.containsKey(it)){
                        map.put(it, map.get(it) + 1);
                    }else{
                        map.put(it, 1);
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
