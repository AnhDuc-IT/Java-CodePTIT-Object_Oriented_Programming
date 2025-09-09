import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.IOException.*;
public class Solution {
    public static boolean Prime(int n){
        for(int i = 2; i * i <= n; i++){
            if(n % i == 0) return false;
        }
        return n > 1;
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        FileInputStream fis = new FileInputStream("DATA.in");
        ObjectInputStream ois = new ObjectInputStream(fis);
        ArrayList <Integer> arr = (ArrayList)ois.readObject();
        ois.close();
        fis.close();
        TreeMap <Integer, Integer> map = new TreeMap<>();
        for(Integer x : arr){
            if(Prime(x)){
                if(map.containsKey(x)){
                    map.put(x, map.get(x) + 1);
                }else{
                    map.put(x, 1);
                }
            }
        }
        ArrayList <Integer> res = new ArrayList<>();
        map.forEach((u, v) -> {
            res.add(u);
        });
        int cnt = 1;
        for(int i = res.size() - 1; i >= 0; i--){
            if(cnt <= 10){
                System.out.println(res.get(i) + " " + map.get(res.get(i)));
                ++cnt;
            }
        }
    }
}
