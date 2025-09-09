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
import java.lang.reflect.Array;
public class Solution {
    public static boolean check(Integer a){
        Integer temp = a;
        String b = "";
        while(temp > 0){
            b += temp % 10;
            if(temp % 10 % 2 == 0) return false;
            temp /= 10;
        }
        if(b.length() % 2 == 0 || b.length() == 1) return false;
        if(a != Integer.parseInt(b)) return false;
        return true;
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        FileInputStream fis = new FileInputStream("DATA1.in");
        FileInputStream fis2 = new FileInputStream("DATA2.in");
        ObjectInputStream ois = new ObjectInputStream(fis);
        ObjectInputStream ois2 = new ObjectInputStream(fis2);
        TreeMap <Integer, Integer> map = new TreeMap<>();
        ArrayList <Integer> arr1 = (ArrayList)ois.readObject();
        ArrayList <Integer> arr2 = (ArrayList)ois2.readObject();
        ois2.close();
        ois.close();
        fis2.close();
        fis.close();
        Set <Integer> set = new HashSet<>(arr2);
        for(Integer x : arr1){
            if(check(x) && set.contains(x)){
                if(map.containsKey(x)){
                    map.put(x, map.get(x) + 1);
                }else{
                    map.put(x, 1);
                }
            }
        }
        for(Integer x : arr2){
            if(map.containsKey(x)){
                map.put(x, map.get(x) + 1);
            }
        }
        int cnt = 1;
        for(Integer x : set){
            if(map.containsKey(x) && cnt <= 10){
                ++cnt;
                System.out.println(x + " " + map.get(x));
            }
        }
    }
}
