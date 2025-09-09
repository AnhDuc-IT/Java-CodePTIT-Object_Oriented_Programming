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
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        FileInputStream fis = new FileInputStream("NHIPHAN.in");
        BufferedReader br = new BufferedReader(new FileReader("VANBAN.in"));
        ObjectInputStream ois = new ObjectInputStream(fis);
        ArrayList <String> arr1 = (ArrayList)ois.readObject();
        ArrayList <String> arr2 = new ArrayList<>();
        String line;
        while((line = br.readLine()) != null){
            String[] a = line.split("\\s+");
            for(String it : a){
                if(!arr2.contains(it.toLowerCase())){
                    arr2.add(it.toLowerCase());
                }
            }
        }
        ArrayList <String> arr= new ArrayList<>();
        for(String x : arr1){
            String[] token = x.split("\\s+");
            for(String it : token){
                if(!arr.contains(it.toLowerCase())){
                    arr.add(it.toLowerCase());
                }
            }
        }
        ArrayList <String> set = new ArrayList<>();
        for(String x : arr2){
            if(arr.contains(x.toLowerCase())){
                set.add(x.toLowerCase());
            }
        }
        for(String x : set){
            System.out.println(x);
        }
        br.close();
        ois.close();
        fis.close();
    }
}
