import java.io.FileInputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.lang.reflect.Array;
import java.util.*;
public class Solution{
    static boolean check(Integer n){
        String s = "" + n;
        return s.equals(new StringBuilder(s).reverse().toString());
    }
    static boolean[] nt = new boolean[10005];
    static void sieve(){
        for(int i = 2; i <= 10001; i++){
            nt[i] = true;
        }
        for(int i = 2; i * i <= 10001; i++){
            if(nt[i]){
                for(int j = i * i ; j <= 10001; j += i){
                    nt[j] = false;
                }
            }
        }
    }
    public static void main(String[] args){
        sieve();
        try {
            FileInputStream fis1 = new FileInputStream("DATA1.in");
            ObjectInputStream ois1 = new ObjectInputStream(fis1);
            FileInputStream fis2 = new FileInputStream("DATA2.in");
            ObjectInputStream ois2 = new ObjectInputStream(fis2);
            ArrayList <Integer> arr1 = (ArrayList)ois1.readObject();
            ArrayList <Integer> arr2 = (ArrayList)ois2.readObject();
            ois2.close();
            fis2.close();
            ois1.close();
            fis1.close();
            TreeMap <Integer, Integer> map = new TreeMap<>();
            Map <Integer, Integer> mp = new HashMap<>();
            for(int x : arr2){
                if(mp.containsKey(x)){
                    mp.put(x, mp.get(x) + 1);
                }else{
                    mp.put(x, 1);
                }
            }
            for(int x : arr1){
                if(mp.containsKey(x) && nt[x] && check(x)){
                    if(map.containsKey(x)){
                        map.put(x, map.get(x) + 1);
                    }else{
                        map.put(x, 1);
                    }
                }
            }
            map.forEach((u, v) -> System.out.println(u + " " + v + " " + mp.get(u)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
