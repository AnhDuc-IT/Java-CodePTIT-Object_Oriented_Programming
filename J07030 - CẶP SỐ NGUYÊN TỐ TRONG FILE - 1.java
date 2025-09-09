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
    public static boolean[] nt = new boolean[1000006];
    public static void sieve(){
        for(int i = 2; i <= 1000005; i++){
            nt[i] = true;
        }
        for(int i = 2; i * i <= 1000005; i++){
            if(nt[i]){
                for(int j = i * i; j <= 1000005; j += i){
                    nt[j] = false;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        sieve();
        FileInputStream fis = new FileInputStream("DATA1.in");
        FileInputStream fis2 = new FileInputStream("DATA2.in");
        ObjectInputStream ois = new ObjectInputStream(fis);
        ObjectInputStream ois2 = new ObjectInputStream(fis2);
        ArrayList <Integer> arr1 = (ArrayList)ois.readObject();
        ArrayList <Integer> arr2 = (ArrayList)ois2.readObject();
        Set <Integer> set2 = new HashSet<>(arr2);
        ois2.close();
        ois.close();
        fis2.close();
        fis.close();
        TreeMap <Integer, Integer> map = new TreeMap<>();
        for(Integer x : arr1){
            int temp = 1000000 - x;
            if(set2.contains(temp) && x < temp && nt[x] && nt[temp]){
                map.put(x, temp);
            }
        }
        map.forEach((u, v) -> {
            System.out.println(u + " " + v);
        });
    }
}
