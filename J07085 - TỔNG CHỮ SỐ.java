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
import java.math.BigInteger;
public class Solution {
    public static int Total(String s){
        int sum = 0;
        for(int i = 0; i < s.length() ;i++){
            sum += s.charAt(i) - '0';
        }
        return sum;
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        FileInputStream fis = new FileInputStream("DATA.in");
        ObjectInputStream ois = new ObjectInputStream(fis);
        ArrayList <String> arr = (ArrayList)ois.readObject();
        ArrayList <String> res = new ArrayList<>();
        ois.close();
        fis.close();
        for(String x : arr){
            String ans = "";
            for(int i = 0; i < x.length(); i++){
                if(Character.isDigit(x.charAt(i))){
                    ans += x.charAt(i);
                }
            }
            if(!ans.isEmpty()){
                res.add(ans);
            }
        }
        for(String x : res){
            System.out.println(new BigInteger(x) + " " + Total(x));
        }
    }
}
